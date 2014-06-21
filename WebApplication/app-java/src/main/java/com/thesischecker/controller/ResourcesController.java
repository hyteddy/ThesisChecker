package com.thesischecker.controller;

import com.thesischecker.domain.Resource;
import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.dto.UserProfileEntity;
import com.thesischecker.models.ResourcesModel;
import com.thesischecker.services.interfaces.IResourcesService;
import com.thesischecker.services.interfaces.IUsersService;
import com.thesischecker.utils.Constants;
import com.thesischecker.utils.ResponseUtil;
import com.thesischecker.utils.ValidationUtil;
import com.thesischecker.validators.ResourcesModelValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
     * Initialize model attribute
     * @param model
     * @return
     */
    @ModelAttribute(value = ResourcesModel.MODEL_NAME)
    public ResourcesModel initModelAttribute(Model model) {
        List<UserProfileEntity> users = this.usersService.getFullNames();
        return new ResourcesModel(users);
    }

    /**
     * Index method
     * @return view name
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("/resources/index");
    }

    /**
     * Render add view
     * @return view name
     */
    @RequestMapping(value = "/add", method =  RequestMethod.GET)
    public ModelAndView add() {
        return new ModelAndView("/resources/add");
    }

    /**
     * Search action
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
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
}
