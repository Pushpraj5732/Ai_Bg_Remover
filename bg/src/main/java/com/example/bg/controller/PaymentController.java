package com.example.bg.controller;

import com.example.bg.model.PaymentRequest;
import com.example.bg.Res.PaymentRequestRepository;
import com.example.bg.service.UserCreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/pay")
public class PaymentController {

    private final UserCreditService userCreditService;
    private final PaymentRequestRepository paymentRepo;

    public PaymentController(
            UserCreditService userCreditService,
            PaymentRequestRepository paymentRepo
    ) {
        this.userCreditService = userCreditService;
        this.paymentRepo = paymentRepo;
    }

    // ✅ MOCK PAYMENT (DEV ONLY)
    @PostMapping("/mock-payment")
    public ResponseEntity<String> mockPayment(
            @RequestParam String clerkUserId
    ) {
        userCreditService.addCredits(clerkUserId, 10);

        return ResponseEntity.ok(
                "Mock payment successful. 10 credits added."
        );
    }

    // ✅ MANUAL UPI PAYMENT
    @PostMapping("/manual")
    public ResponseEntity<String> manualPayment(
            @RequestBody PaymentRequest req
    ) {
        // 🔒 UTR format validation
        if (!req.getTxnId().matches("\\d{12,16}")) {
            throw new RuntimeException("Invalid UTR format");
        }

        // 🔒 Duplicate UTR
        if (paymentRepo.findByTxnId(req.getTxnId()).isPresent()) {
            throw new RuntimeException("UTR already used");
        }

        // 🔒 Reference code required
        if (req.getReferenceCode() == null || req.getReferenceCode().isBlank()) {
            throw new RuntimeException("Reference code missing");
        }

        req.setVerified(false);
        paymentRepo.save(req);

        return ResponseEntity.ok(
                "Payment submitted. Waiting for verification."
        );
    }
}
