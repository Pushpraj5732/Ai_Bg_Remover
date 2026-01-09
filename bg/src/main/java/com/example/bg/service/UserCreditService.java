package com.example.bg.service;

import com.example.bg.Res.PrismaRes;
import com.example.bg.model.PaymentRequest;
import com.example.bg.model.UserCredit;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserCreditService {

    private final PrismaRes prismaRes;

    public UserCreditService(PrismaRes prismaRes) {
        this.prismaRes = prismaRes;
    }

    @Transactional
    public void createUserIfNotExists(String clerkUserId) {
        prismaRes.findByClerkUserId(clerkUserId)
                .orElseGet(() -> {
                    UserCredit user = new UserCredit();
                    user.setClerkUserId(clerkUserId);
                    user.setCredits(10);
                    return prismaRes.save(user);
                });
    }

    @Transactional
    public void decrementCredit(String clerkUserId) {
        UserCredit user = prismaRes.findByClerkUserId(clerkUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getCredits() <= 0) {
            throw new RuntimeException("No credits left");
        }

        user.setCredits(user.getCredits() - 1);
        prismaRes.save(user);
    }

    @Transactional
    public void addCredits(String clerkUserId, int amount) {
        UserCredit user = prismaRes.findByClerkUserId(clerkUserId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setCredits(user.getCredits() + amount);
        prismaRes.save(user);
    }

    @Transactional
    public int getCredits(String clerkUserId) {
        UserCredit user = prismaRes.findByClerkUserId(clerkUserId)
                .orElseGet(() -> {
                    UserCredit newUser = new UserCredit();
                    newUser.setClerkUserId(clerkUserId);
                    newUser.setCredits(5);
                    return prismaRes.save(newUser);
                });

        return user.getCredits();
    }
}
