package com.spring.demologin.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String form(Model theModel){
        User theUser= new User();
        theModel.addAttribute("user",theUser);

        return "user-form";
    }

    @PostMapping("/processUserForm")
    public String processForm(@ModelAttribute("user") User theUser){
        System.out.println("theStudent: " + theUser.getFirstName() + " " + theUser.getLastName());
        return "user-confirmation";
    }
}
