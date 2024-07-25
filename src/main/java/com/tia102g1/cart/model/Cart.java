package com.tia102g1.cart.model;

import java.sql.Date;

public class Cart {

    private Integer cartId;
    private Integer memberId;
    private Integer productId;
    private Integer proAmount;
    private Date joinDt;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProAmount() {
        return proAmount;
    }

    public void setProAmount(Integer proAmount) {
        this.proAmount = proAmount;
    }

    public Date getJoinDt() {
        return joinDt;
    }

    public void setJoinDt(Date joinDt) {
        this.joinDt = joinDt;
    }
}
