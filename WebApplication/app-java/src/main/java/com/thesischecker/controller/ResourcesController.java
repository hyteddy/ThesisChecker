package com.thesischecker.controller;

import com.thesischecker.dto.ResourceEntity;
import com.thesischecker.models.ResourcesModel;
import com.thesischecker.services.interfaces.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller to thesis service
 */
@Controller
@RequestMapping(value = "/resources")
public class ResourcesController {

    @Autowired
    private IResourcesService resourcesService;

    /**
     * Initialize model attribute
     * @param model
     * @return
     */
    @ModelAttribute(value = ResourcesModel.MODEL_NAME)
    public ResourcesModel initModelAttribute(Model model) {
        return new ResourcesModel();
    }

    /**
     * Index method
     * @return view name
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        List<ResourceEntity> resources = this.resourcesService.findAll();
        return new ModelAndView("/resources/index");
    }
}
