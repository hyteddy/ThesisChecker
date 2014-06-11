package com.thesischecker.controller;

import com.thesischecker.domain.Resource;
import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.dto.UserProfileEntity;
import com.thesischecker.models.ResourcesModel;
import com.thesischecker.services.interfaces.IResourcesService;
import com.thesischecker.services.interfaces.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
     * Search action
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public List<Resource> search() {
        List<ResourceEntity> resourceEntities = this.resourcesService.find();
        List<Resource> resources = new ArrayList<Resource>();
        for (ResourceEntity resourceEntity : resourceEntities) {
            resources.add(new Resource(resourceEntity));
        }
        return resources;
    }
}
