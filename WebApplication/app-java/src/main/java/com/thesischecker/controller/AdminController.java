package com.thesischecker.controller;

import com.thesischecker.dao.impl.UserDao;
import com.thesischecker.models.NewAccountModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Paweł on 2014-06-21.
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model){
        model.addAttribute("NewAccountModel",new NewAccountModel());
        return "/admin/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute("NewAccountModel") NewAccountModel model, BindingResult result) {
        String username = model.getEmail();
        String password = model.getPassword();

        UserDao user = new UserDao();
        user.addUser(username,password);
        ModelAndView m= new ModelAndView("/admin/index");
        m.addObject("creationString", "Account for user "+username+" created");

        return m;
    }
}
