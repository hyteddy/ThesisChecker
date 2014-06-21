package com.thesischecker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to thesis service
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {


    /**
     * Index method
     * @return view name
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("/admin/index");
    }

}
