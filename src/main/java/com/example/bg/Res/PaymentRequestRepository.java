package com.example.bg.Res;

import com.example.bg.model.PaymentRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRequestRepository
        extends JpaRepository<PaymentRequest, Long> {
    Optional<Object> findByTxnId(String txnId);
}
