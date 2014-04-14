package com.thesischecker.dto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Test dto
 * @author Tomasz Morek
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    /**
     * Index text method
     * @return view name
     */
    @RequestMapping(value = "/test/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
