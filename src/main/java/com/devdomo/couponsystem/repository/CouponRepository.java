package com.devdomo.couponsystem.repository;

import com.devdomo.couponsystem.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
