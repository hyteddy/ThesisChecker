package com.thesischecker.controller;

import com.thesischecker.models.ResourcesModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to thesis service
 */
@Controller
@RequestMapping(value = "/resources")
public class ResourcesController {

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
        return new ModelAndView("/resources/index");
    }
}
