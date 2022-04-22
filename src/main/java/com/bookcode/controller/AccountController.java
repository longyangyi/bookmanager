package com.bookcode.controller;

import com.bookcode.dao.AccountDao;
import com.bookcode.entity.Account;
import com.bookcode.service.AccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @Resource
    private AccountDao accountDao;

    @RequestMapping("/add")
    @ResponseBody
    public String addAccount(@RequestParam String username, @RequestParam float balance) {
        Account account = new Account(username, balance);
        accountDao.save(account);
        return "Saved";
    }

    @RequestMapping("/transfer")
    public String transferAccount() {
        try {
            accountService.transferAccounts(1, 2, 200);
            return "OK";
        } catch (Exception e) {
            return "NO";
        }
    }
}
