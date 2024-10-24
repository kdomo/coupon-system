package com.github.kdomo.consumer.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    public Coupon(Long id) {
        this.id = id;
    }

    public Coupon() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }
}
