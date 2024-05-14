package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "/user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
//        model.addAttribute("user", user);
//        model.addAttribute("verify", verify);
        if (errors.hasErrors()){
            model.addAttribute("title", "Add User");
            return "user/add";
       } else if (!user.getPassword().equals(verify)) {
            model.addAttribute("title", "Add User");
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        } else {
            return "user/index";
            }
        }

    }