package com.example.ass.controller;

import com.example.ass.config.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ass.beans.SignUpBean;
import com.example.ass.config.Constants;
import com.example.ass.entities.Account;
import com.example.ass.repositories.AccountRepository;
@Controller
public class SignUpController {
	@Autowired
    private AccountRepository accountRepository;

    @GetMapping("/register")
    public String registerForm(@ModelAttribute("user")SignUpBean accBean) {
        return "/auth/register";
    }


    @PostMapping("/register")
    public String registerSubmit(Model model,@ModelAttribute("user") SignUpBean accBean) {
        Account accEntity = new Account();
        if (accountRepository.findByEmail(accBean.getEmail())==null && accountRepository.findByUsername(accBean.getUsername())==null){
            accEntity.setFullname(accBean.getFullname());
            accEntity.setUsername(accBean.getUsername());
            accEntity.setPassword(accBean.getPassword());
            accEntity.setEmail(accBean.getEmail());
            accEntity.setActivated(1);
            accEntity.setAdmin(String.valueOf(Role.ROLE_USER));
            accEntity.setPhoto("user");
            System.out.println(1);
            accountRepository.save(accEntity);
            return "auth/login";
        }else {
            model.addAttribute("message","Đã tồn tại Gmail hoặc UserName");
        }
        return "auth/register";
    }
}
