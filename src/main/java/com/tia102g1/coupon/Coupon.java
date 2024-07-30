package com.tia102g1.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coupon implements Serializable {
    private Integer couponId;
    private String couponCode;
    private String couponName;
    private Integer couponStatus;
    private LocalDate startDt;
    private LocalDate endDt;
    private Integer discType;
    private Integer discAmount;
    private BigDecimal discPercentage;
    private String createdBy;
    private LocalDateTime dateCreated;
    private String lastUpdatedBy;
    private LocalDateTime lastUpdated;

}
