package com.devdomo.couponsystem.service;

import com.devdomo.couponsystem.domain.Coupon;
import com.devdomo.couponsystem.producer.CouponCreateProducer;
import com.devdomo.couponsystem.repository.AppliedUserRepository;
import com.devdomo.couponsystem.repository.CouponCountRepository;
import com.devdomo.couponsystem.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;
    private final AppliedUserRepository appliedUserRepository;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository, CouponCreateProducer couponCreateProducer, AppliedUserRepository appliedUserRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
        this.appliedUserRepository = appliedUserRepository;
    }

    public void apply(Long userId) {
        Long apply = appliedUserRepository.add(userId);

        if (apply != 1) {
            return;
        }

        Long count = couponCountRepository.increment();

        if (count > 100) {
            return;
        }
        couponCreateProducer.create(userId);
    }
}
