//package com.example.bg.controller;
//
//import com.example.bg.service.UserCreditService;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin(origins = "http://localhost:5173")
//@RestController
//@RequestMapping("/api/pay")
//public class PaymentController {
//
//    private final UserCreditService userCreditService;
//
//    public PaymentController(UserCreditService userCreditService) {
//        this.userCreditService = userCreditService;
//    }
//
//    // ✅ MOCK PAYMENT (NO Razorpay, NO Stripe)
//    @PostMapping("/mock-payment")
//    public String mockPayment(@RequestParam String clerkUserId) {
//        userCreditService.addCredits(clerkUserId, 10);
//        return "Mock payment successful. 10 credits added.";
//    }
//}
