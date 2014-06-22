package com.thesischecker.controller;

import com.thesischecker.dao.impl.UserDao;
import com.thesischecker.dto.UserEntity;
import com.thesischecker.models.LoginModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.*;
import org.apache.shiro.util.Factory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Paweł on 2014-06-20.
 */

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model){
        org.apache.shiro.subject.Subject user = SecurityUtils.getSubject();

        if (user.isAuthenticated()) {
            if(user.hasRole("ROLE_ADMIN"))
                return "redirect:/admin/";
            else if (user.hasRole("ROLE_PROMOTER"))
                return "redirect:/resources/index";
        }
        model.addAttribute("login",new LoginModel());
        return "/index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("login") LoginModel model, BindingResult result){
        String username = model.getLogin();
        String password = model.getPassword();

        ModelAndView ret = new ModelAndView("/index");
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
        //collect user principals and credentials in a gui specific manner
        //such as username/password html form, X509 certificate, OpenID, etc.
        //We'll use the username/password example here since it is the most common.
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //this is all you have to do to support 'remember me' (no config - built in!):
        token.setRememberMe(true);

        try {
            currentUser.login(token);
            ret = new ModelAndView("redirect:/");
            System.out.println("User [" + currentUser.getPrincipal().toString() + "] logged in successfully.");

            // save current username in the session, so we have access to our User model
            currentUser.getSession().setAttribute("username", username);
        } catch (UnknownAccountException uae) {
            System.out.println("There is no user with username of "
                    + token.getPrincipal());
            ret.addObject("erstr","Invalid login/password");
        } catch (IncorrectCredentialsException ice) {
            System.out.println("Password for account " + token.getPrincipal()
                    + " was incorrect!");
            System.out.println(ice.getMessage());
            System.out.println(ice.getStackTrace());
            ret.addObject("erstr","Invalid login/password");
        } catch (LockedAccountException lae) {
            System.out.println("The account for username " + token.getPrincipal()
                    + " is locked.  ");
            ret.addObject("erstr", "Account " + token.getPrincipal() +
                    " is locked. Please contact administrator.");
        }
        return ret;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout()
    {
        ModelAndView ret = new ModelAndView("redirect:/");
        org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ret;
    }
}