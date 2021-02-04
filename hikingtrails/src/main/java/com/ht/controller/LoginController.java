/**
 * Angel Segoviano 
 * 12/10/2020
 * Login Controller
 * login controller was created for testing methods before implementing the react application
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
@RequestMapping("/")
public class LoginController {

    // variable for UserBusinessServiceInterface
    @Autowired
    UserBusinessServiceInterface service;

    /**
     * displays the login page
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("user", new User());
        return "login";
    }

    /**
     * method calls the userbusinessServiceInterface to use the authenticate method
     * and validate the user attempting to login.
     * 
     * @param model
     * @return
     */
    @PostMapping("/doLogin")
    public String doLogin(User user, Model model) {
        System.out.println("Entering doLogin in Login Controller");
        User users = service.authentication(user.getUsername());
        // checks if the username and password entered matches one in the databases
        if (users.getUsername().equals(user.getUsername()) && users.getPassword().equals(user.getPassword())) {
            System.out.println(" user is now logged in");
            model.addAttribute("title", "Home");
            return "home";
        }
        model.addAttribute("title", "login page");
        return "redirect:/";
    }

    // displays the test home page
    @GetMapping("/home")
    public String displayHomePage(Model model) {
        model.addAttribute("title", "Home Form");
        model.addAttribute("user", new User());
        return "home";
    }
}
