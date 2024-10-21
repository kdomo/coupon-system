package com.devdomo.couponsystem.service;

import com.devdomo.couponsystem.domain.Coupon;
import com.devdomo.couponsystem.repository.CouponCountRepository;
import com.devdomo.couponsystem.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }

    public void apply(Long userId) {
        Long count = couponCountRepository.increment();

        if (count > 100) {
            return;
        }
        couponRepository.save(new Coupon(userId));
    }
}
