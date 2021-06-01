package com.loiko.alex.controller;

import com.loiko.alex.enumerable.Role;
import com.loiko.alex.model.UserAccount;
import com.loiko.alex.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Alexey Loiko
 * @project user-interface
 */
@SessionAttributes(value = "user")
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserAccountController {

    private final UserAccountService service;

    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @GetMapping("/new")
    public String openUserSave(Model model) {
        model.addAttribute("userAccount", new UserAccount());
        return "/new";
    }

    @PostMapping("/new")
    public String saveNewUser(UserAccount account) {
        account.setRole(Role.ADMIN);
        service.saveAccount(account);
        return "redirect:/login";
    }
}