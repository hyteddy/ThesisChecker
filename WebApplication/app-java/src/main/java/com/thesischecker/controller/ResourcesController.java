package com.thesischecker.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.thesischecker.domain.File;
import com.thesischecker.domain.Resource;
import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.dto.UserProfileEntity;
import com.thesischecker.extractor.DocxTextExtractor;
import com.thesischecker.extractor.ITextExtractor;
import com.thesischecker.extractor.PDFExtractor;
import com.thesischecker.extractor.TextExtractorException;
import com.thesischecker.filesystem.FileProcess;
import com.thesischecker.models.ResourcesModel;
import com.thesischecker.services.interfaces.IResourcesService;
import com.thesischecker.services.interfaces.IUsersService;
import com.thesischecker.utils.Constants;
import com.thesischecker.utils.ResponseUtil;
import com.thesischecker.utils.ValidationUtil;
import com.thesischecker.validators.ResourcesModelValidator;

/**
 * Controller to thesis service
 */
@Controller
@RequestMapping(value = "/resources")
public class ResourcesController {

    /**
     * Resources service
     */
    @Autowired
    private IResourcesService resourcesService;

    /**
     * Users service
     */
    @Autowired
    private IUsersService usersService;

    /**
     * Render add view
     * 
     * @return view name
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("/resources/add");
    }

    /**
     * Index method
     * 
     * @return view name
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("/resources/index");
    }

    /**
     * Initialize model attribute
     * 
     * @param model
     * @return
     */
    @ModelAttribute(value = ResourcesModel.MODEL_NAME)
    public ResourcesModel initModelAttribute(Model model) {
        List<UserProfileEntity> users = this.usersService.getFullNames();
        return new ResourcesModel(users);
    }

    /**
     * Extract plain text from file and save file to file system
     * 
     * @param file
     * @param plainText
     * @param path
     *            @return
     * @throws TextExtractorException
     * @throws IOException
     */
    private String saveFile(MultipartFile file, String plainText, String path)
            throws TextExtractorException, IOException {
        ITextExtractor textExtractor;
        if (file.getContentType().equals("application/msword")) {
            textExtractor = new DocxTextExtractor(file.getInputStream());
            plainText = textExtractor.extract();
        } else if (file.getContentType().equals("application/pdf")) {
            textExtractor = new PDFExtractor(file.getInputStream());
            plainText = textExtractor.extract();
        }

        InputStream is = file.getInputStream();
        FileProcess fileProcess = new FileProcess(path);
        java.io.File fileToUpload = new java.io.File(file.getOriginalFilename());
        OutputStream os = new FileOutputStream(fileToUpload);

        byte[] bytes = new byte[1024];
        int read = 0;
        while ((read = is.read(bytes)) != -1) {
            os.write(bytes, 0, read);
        }

        String absolutePath = fileProcess.saveFileOnDisk(fileToUpload);
        fileProcess.consistencyMechanism();

        return absolutePath;
    }

    /**
     * Search action
     * 
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseUtil search(@RequestBody ResourcesModel resourcesModel,
            BindingResult result) {
        ResourcesModelValidator validator = new ResourcesModelValidator();
        validator.validate(resourcesModel, result);
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return new ResponseUtil(Constants.FORM_VALIDATION_ERRORS, errors);
        } else {
            List<ResourceEntity> resourceEntities = this.resourcesService.find(
                    resourcesModel.getUserId(),
                    ValidationUtil.parseDate(resourcesModel.getDateFrom()),
                    ValidationUtil.parseDate(resourcesModel.getDateTo()));
            if (resourceEntities.size() != 0) {
                List resources = new ArrayList<Resource>();
                for (ResourceEntity resourceEntity : resourceEntities) {
                    resources.add(new Resource(resourceEntity));
                }
                return new ResponseUtil(resources);
            } else {
                return new ResponseUtil(Constants.NO_RECORDS_FOUND);
            }
        }
    }

    /**
     * Upload file to file system and database
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseUtil upload(MultipartHttpServletRequest request,
            HttpServletResponse response) {
        Iterator<String> filesIterator = request.getFileNames();
        String path = System.getProperty("user.dir") + "/resources";
        if (filesIterator.hasNext()) {
            String fileContext = filesIterator.next();
            MultipartFile file = request.getFile(fileContext);
            String fileName = file.getOriginalFilename();
            String fileType = file.getContentType();
            String filePath = null;
            String plainText = null;
            ITextExtractor textExtractor;
            try {
                filePath = saveFile(file, plainText, path);
                Subject currentUser = SecurityUtils.getSubject();
                String userEmail = (String) currentUser.getPrincipal();
                Long userId = this.usersService.getUserId(userEmail);
                Long resourceId = this.resourcesService.save(fileName,
                        fileType, filePath, plainText, new Date(), userId);
                File uploadedFile = new File(resourceId, fileName, fileType);
                return new ResponseUtil(uploadedFile, "Upload file success");
            } catch (TextExtractorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseUtil("Unexpected error. File can't be uploaded",
                new ArrayList());
    }
}
