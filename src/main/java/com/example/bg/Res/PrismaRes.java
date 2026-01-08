package com.example.bg.Res;

import com.example.bg.model.UserCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrismaRes extends JpaRepository<UserCredit, Long> {

    Optional<UserCredit> findByClerkUserId(String clerkUserId);
}
