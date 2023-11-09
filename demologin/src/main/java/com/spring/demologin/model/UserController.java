package com.spring.demologin.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Value("${countries}")
    private List<String> countries;


    @GetMapping("/login")
    public String form(Model theModel){
        User theUser= new User();
        theModel.addAttribute("user",theUser);

        theModel.addAttribute("countries",countries);
        return "user-form";
    }

    @PostMapping("/processUserForm")
    public String processForm(@ModelAttribute("user") User theUser){
        System.out.println("theStudent: " + theUser.getFirstName() + " " + theUser.getLastName());
        return "user-confirmation";
    }
}
