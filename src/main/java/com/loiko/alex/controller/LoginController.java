package com.loiko.alex.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    @GetMapping("/")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}