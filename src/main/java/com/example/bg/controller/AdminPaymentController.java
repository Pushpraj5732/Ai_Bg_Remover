package com.example.bg.controller;

import com.example.bg.Res.PaymentRequestRepository;
import com.example.bg.model.PaymentRequest;
import com.example.bg.service.UserCreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminPaymentController {

    private final PaymentRequestRepository paymentRepo;
    private final UserCreditService userCreditService;

    // ✅ Constructor injection
    public AdminPaymentController(
            PaymentRequestRepository paymentRepo,
            UserCreditService userCreditService
    ) {
        this.paymentRepo = paymentRepo;
        this.userCreditService = userCreditService;
    }

    // ✅ 1️⃣ Get all pending payments
    @GetMapping("/pending")
    public List<PaymentRequest> getPendingPayments() {
        return paymentRepo.findAll()
                .stream()
                .filter(p -> !p.isVerified())
                .toList();
    }

    // ✅ 2️⃣ Verify payment & add credits
    @PostMapping("/verify/id/{id}")
    public String verifyPayment(@PathVariable Long id) {

        PaymentRequest payment = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        if (payment.isVerified()) {
            return "Payment already verified";
        }

        // mark verified
        payment.setVerified(true);
        payment.setStatus("APPROVED");
        paymentRepo.save(payment);

        // add credits
        userCreditService.addCredits(
                payment.getClerkUserId(),
                10
        );

        return "Payment approved & credits added";
    }
}
