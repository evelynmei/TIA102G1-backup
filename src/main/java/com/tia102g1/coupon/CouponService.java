package com.tia102g1.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class CouponService {

    private static final String COUPON_KEY = "coupon:";

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

// 創建優惠券
//    public void createCoupon(Coupon coupon) {
//        String key = COUPON_KEY + coupon.getCode();
//        Map<String, Object> couponMap = objectToMap(coupon);
//        redisTemplate.opsForHash().putAll(key, couponMap);
//
//        // 設置過期時間
//        long daysUntilExpiration = LocalDate.now().until(coupon.getExpirationDate()).getDays();
//        redisTemplate.expire(key, daysUntilExpiration, TimeUnit.DAYS);
//    }

//    /**
//     * 讀取優惠券
//     *
//     * @param couponCode
//     * @return Coupon
//     */
//    public Coupon getCoupon(String couponCode) {
//        if (!StringUtils.hasText(couponCode)) {
//            throw new IllegalArgumentException("Coupon code cannot be empty");
//        }
//
//        String key = COUPON_KEY + couponCode;
//        Map<Object, Object> couponMap = redisTemplate.opsForHash().entries(key);
//        if (couponMap.isEmpty()) {
//            return null;
//        }
//        return mapToObject(couponMap);
//    }
//
//    public String getTest(String couponCode) {
//        return couponCode;
//    }

    //    /**
//     * 更新優惠券
//     *
//     * @param coupon
//     */
//    public void updateCoupon(Coupon coupon) {
//        validateCoupon(coupon);
//        String key = COUPON_KEY + coupon.getCouponCode();
//        if (!redisTemplate.hasKey(key)) {
//            throw new IllegalArgumentException("Coupon with code " + coupon.getCouponCode() + " does not exist");
//        }
//        coupon.setLastUpdated(LocalDateTime.now());
//        Map<String, Object> couponMap = objectToMap(coupon);
//        redisTemplate.opsForHash().putAll(key, couponMap);
//    }
//
//    /**
//     * 刪除優惠券
//     *
//     * @param couponCode
//     */
//    public void deleteCoupon(String couponCode) {
//        if (!StringUtils.hasText(couponCode)) {
//            throw new IllegalArgumentException("Coupon code cannot be empty");
//        }
//        String key = COUPON_KEY + couponCode;
//        redisTemplate.delete(key);
//    }
//

    /**
     * 取得優惠券清單
     *
     * @return List of coupons
     */
    public List<Coupon> getAllCoupons() {
        Set<Object> keys = redisTemplate.keys(COUPON_KEY + "*");
        List<Coupon> coupons = new ArrayList<>();
        for (Object key : keys) {
            Map<Object, Object> couponMap = redisTemplate.opsForHash().entries(key);
            coupons.add(mapToObject(couponMap));
        }
        return coupons;
    }

    //
//    /**
//     * 確認優惠券是否有效
//     *
//     * @param couponCode
//     * @return true if a coupon is valid, otherwise false
//     */
//    public boolean isCouponValid(String couponCode) {
//        Coupon coupon = getCoupon(couponCode);
//        if (coupon == null || coupon.getCouponStatus() != 1) {
//            return false;
//        }
//        LocalDate now = LocalDate.now();
//        return !now.isBefore(coupon.getStartDt()) && !now.isAfter(coupon.getEndDt());
//    }
//
//    /**
//     * 取得優惠券折扣
//     *
//     * @param coupon
//     */
//    private void validateCoupon(Coupon coupon) {
//        if (coupon == null) {
//            throw new IllegalArgumentException("Coupon cannot be null");
//        }
//        if (!StringUtils.hasText(coupon.getCouponCode())) {
//            throw new IllegalArgumentException("Coupon code cannot be empty");
//        }
//        if (coupon.getStartDt() == null || coupon.getEndDt() == null) {
//            throw new IllegalArgumentException("Start date and end date must be provided");
//        }
//        if (coupon.getStartDt().isAfter(coupon.getEndDt())) {
//            throw new IllegalArgumentException("Start date must be before or equal to end date");
//        }
//    }
//
//    private Map<String, Object> objectToMap(Coupon coupon) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("couponId", coupon.getCouponId());
//        map.put("couponCode", coupon.getCouponCode());
//        map.put("couponName", coupon.getCouponName());
//        map.put("couponStatus", coupon.getCouponStatus());
//        map.put("startDt", coupon.getStartDt().toString());
//        map.put("endDt", coupon.getEndDt().toString());
//        map.put("discType", coupon.getDiscType());
//        map.put("discAmount", coupon.getDiscAmount());
//        map.put("discPercentage", coupon.getDiscPercentage().toString());
//        map.put("createdBy", coupon.getCreatedBy());
//        map.put("dateCreated", coupon.getDateCreated().toString());
//        map.put("lastUpdatedBy", coupon.getLastUpdatedBy());
//        map.put("lastUpdated", coupon.getLastUpdated().toString());
//        return map;
//    }
//
    private Coupon mapToObject(Map<Object, Object> map) {
        Coupon coupon = new Coupon();
        coupon.setCouponId((Integer) map.get("couponId"));
        coupon.setCouponCode((String) map.get("couponCode"));
        coupon.setCouponName((String) map.get("couponName"));
        coupon.setCouponStatus((Integer) map.get("couponStatus"));
        coupon.setStartDt(LocalDate.parse((String) map.get("startDt")));
        coupon.setEndDt(LocalDate.parse((String) map.get("endDt")));
        coupon.setDiscType((Integer) map.get("discType"));
        coupon.setDiscAmount((Integer) map.get("discAmount"));
        coupon.setDiscPercentage(new BigDecimal((String) map.get("discPercentage")));
        coupon.setCreatedBy((String) map.get("createdBy"));
        coupon.setDateCreated(LocalDateTime.parse((String) map.get("dateCreated")));
        coupon.setLastUpdatedBy((String) map.get("lastUpdatedBy"));
        coupon.setLastUpdated(LocalDateTime.parse((String) map.get("lastUpdated")));
        return coupon;
    }

//    // 讀取優惠券
//    public Coupon getCoupon(String code) {
//        String key = COUPON_KEY + code;
//        Map<Object, Object> couponMap = redisTemplate.opsForHash().entries(key);
//        return mapToObject(couponMap);
//    }
//
//    // 更新優惠券
//    public void updateCoupon(Coupon coupon) {
//        String key = COUPON_KEY + coupon.getCode();
//        Map<String, Object> couponMap = objectToMap(coupon);
//        redisTemplate.opsForHash().putAll(key, couponMap);
//
//        // 更新過期時間
//        long daysUntilExpiration = LocalDate.now().until(coupon.getExpirationDate()).getDays();
//        redisTemplate.expire(key, daysUntilExpiration, TimeUnit.DAYS);
//    }
//
//    // 刪除優惠券
//    public void deleteCoupon(String code) {
//        String key = COUPON_KEY + code;
//        redisTemplate.delete(key);
//    }
//
//    // 輔助方法：將Coupon對象轉換為Map
//    private Map<String, Object> objectToMap(Coupon coupon) {
//        // 實現省略，使用反射或手動轉換
//    }
//
//    // 輔助方法：將Map轉換為Coupon對象
//    private Coupon mapToObject(Map<Object, Object> map) {
//        // 實現省略，使用反射或手動轉換
//    }
}