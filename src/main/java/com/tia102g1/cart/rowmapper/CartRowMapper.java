package com.tia102g1.cart.rowmapper;

import com.tia102g1.cart.model.Cart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRowMapper implements RowMapper<Cart> {

    @Override
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cart cart = new Cart();

        cart.setCartId(rs.getInt("cartId"));
        cart.setProductId(rs.getInt("productId"));
        cart.setMemberId(rs.getInt("memberId"));
        cart.setProAmount(rs.getInt("proAmount"));
        cart.setJoinDt(rs.getDate("joinDt"));
        return cart;
    }
}
