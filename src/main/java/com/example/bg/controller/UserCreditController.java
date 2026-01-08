package com.example.bg.controller;

import com.example.bg.service.UserCreditService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credits")
@CrossOrigin(origins = "http://localhost:5173")
public class UserCreditController {

    private final UserCreditService userCreditService;

    public UserCreditController(UserCreditService userCreditService) {
        this.userCreditService = userCreditService;
    }

    @PostMapping("/create/{clerkUserId}")
    public void initUser(@PathVariable String clerkUserId) {
        userCreditService.createUserIfNotExists(clerkUserId);
    }

    @GetMapping("/{clerkUserId}")
    public int getCredits(@PathVariable String clerkUserId) {
        return userCreditService.getCredits(clerkUserId);
    }
}

