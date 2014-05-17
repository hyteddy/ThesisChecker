package com.thesischecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thesischecker.services.interfaces.IAnalysisService;

/**
 * Test dto
 * 
 * @author Tomasz Morek
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private IAnalysisService analysisService;

    /**
     * Index text method
     * 
     * @return view name
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("test/index");
    }
}
