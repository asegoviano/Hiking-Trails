/**
 * Angel Segoviano 
 * 12/10/2020
 * RegisterController
 * register controller was created for testing methods before implementing the react application
 */
package com.ht.controller;

import com.ht.business.UserBusinessServiceInterface;
import com.ht.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    // variable for UserBusinessServiceInterface
    @Autowired
    UserBusinessServiceInterface service;

    /**
     * displays the login page
     */
    @GetMapping("/")
    public String displayRegisterPage(Model model) {
        model.addAttribute("title", "Register Form");
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * method calls the userbusinessServiceInterface to use the create method when
     * the action is executed on the registerpage
     * 
     * @param model
     * @return returns the home page
     */
    @PostMapping("/doRegister")
    public String doRegister(User user, Model model) {
        // sets the values of role and status to User and Active when user is created
        user.setRole("User");
        user.setStatus("Active");
        service.makeUser(user);
        model.addAttribute("title", "login");
        return "redirect:/";
    }
}