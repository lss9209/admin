package com.enuri.makeshop.admin.modules.account;

import com.enuri.makeshop.admin.modules.account.validator.SignUpFormValidator;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final SignUpFormValidator signUpFormValidator;
    private final AccountService accountService;
    private final AccountRepository accountRepository;

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @GetMapping("/sign-up")
    public String signUpForm(Model model) {
        //model.addAttribute(new SignUpForm());
        return "account/sign-up";
    }

    @GetMapping("/profile/{nickname}")
    public String viewProfile(@PathVariable String nickname, Model model, @CurrentAccount Account account) {
        Account accountToView = accountService.getAccount(nickname);
        model.addAttribute(accountToView);
        model.addAttribute("isOwner", accountToView.equals(account));
        return "account/profile";
    }
}
