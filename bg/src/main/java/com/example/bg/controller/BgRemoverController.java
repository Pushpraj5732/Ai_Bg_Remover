package com.example.bg.controller;

import com.example.bg.service.BgRemoverService;
import com.example.bg.service.UserCreditService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/bg")
public class BgRemoverController {

    private final BgRemoverService bgRemoverService;
    private final UserCreditService userCreditService;

    public BgRemoverController(
            BgRemoverService bgRemoverService,
            UserCreditService userCreditService
    ) {
        this.bgRemoverService = bgRemoverService;
        this.userCreditService = userCreditService;
    }

    @PostMapping(
            value = "/remove",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.IMAGE_PNG_VALUE   // ✅ VERY IMPORTANT
    )
    public @ResponseBody byte[] removeBackground(
            @RequestParam("image") MultipartFile image,
            @RequestParam("clerkUserId") String clerkUserId
    ) throws Exception {

        // 1️⃣ deduct credit
        userCreditService.decrementCredit(clerkUserId);

        // 2️⃣ return image bytes
        return bgRemoverService.removeBackground(image.getBytes());
    }
}
