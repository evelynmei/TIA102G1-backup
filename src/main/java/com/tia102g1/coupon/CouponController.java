package com.tia102g1.coupon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController

public class CouponController {

    @Autowired
    private CouponService couponService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

//    /**
//     * 新增優惠券
//     *
//     * @param coupon
//     * @return
//     */
//    @PostMapping("/coupon")
//    public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
//        try {
//            couponService.createCoupon(coupon);
//            return ResponseEntity.status(HttpStatus.CREATED).body(coupon);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    //    /**
//     * 取得優惠券
//     *
//     * @param couponCode
//     * @return
//     */
//    @GetMapping("/coupon")
//    public ResponseEntity<Coupon> getCoupon() {
//        try {
//            String key = "coupon:1";
//            Map<Object, Object> couponMap = redisTemplate.opsForHash().entries("coupon:1");
//            Coupon coupon = couponService.getCoupon("PAPA88");
//
//            if (coupon != null) {
//                return ResponseEntity.ok(coupon);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

//      測試假資料
//    @GetMapping("/test")
//    public String save() {
//        String mapName = "coupon:1";
//        redisTemplate.opsForHash().put(mapName, "couponCode", "PAPA88");
//        redisTemplate.opsForHash().put(mapName, "couponName", "父親節全館88折");
//        redisTemplate.opsForHash().put(mapName, "couponStatus", "父親節全館88折");
//        redisTemplate.opsForHash().put(mapName, "startDt", "2024/08/08");
//        redisTemplate.opsForHash().put(mapName, "endDt", "2024/08/10");
//        redisTemplate.opsForHash().put(mapName, "discType", "2");
//        redisTemplate.opsForHash().put(mapName, "discPercentage", "0.88");
//        redisTemplate.opsForHash().put(mapName, "createdBy", "Evelyn");
//        redisTemplate.opsForHash().put(mapName, "dateCreated", "2024/07/30");
//        redisTemplate.opsForHash().put(mapName, "lastUpdatedBy", "Evelyn");
//        redisTemplate.opsForHash().put(mapName, "lastUpdated", "2024/07/30");
//        return "新增成功";
//    }
//
//    /**
//     * 更新優惠券
//     *
//     * @param couponCode
//     * @param coupon
//     * @return
//     */
//    @PutMapping("/{couponCode}")
//    public ResponseEntity<Void> updateCoupon(@PathVariable String couponCode, @RequestBody Coupon coupon) {
//        try {
//            if (!couponCode.equals(coupon.getCouponCode())) {
//                return ResponseEntity.badRequest().build();
//            }
//            couponService.updateCoupon(coupon);
//            return ResponseEntity.ok().build();
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    /**
//     * 刪除優惠券
//     *
//     * @param couponCode
//     * @return
//     */
//    @DeleteMapping("/{couponCode}")
//    public ResponseEntity<Void> deleteCoupon(@PathVariable String couponCode) {
//        try {
//            couponService.deleteCoupon(couponCode);
//            return ResponseEntity.ok().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//

    /**
     * 取得所有優惠券
     *
     * @return
     */
    @GetMapping("/coupon")
    public ResponseEntity<List<Coupon>> getAllCoupons() {
        try {
            List<Coupon> coupons = couponService.getAllCoupons();
            return ResponseEntity.ok(coupons);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//
//    /**
//     * 判斷優惠券是否有效
//     *
//     * @param couponCode
//     * @return
//     */
//    @GetMapping("/{couponCode}/valid")
//    public ResponseEntity<Boolean> isCouponValid(@PathVariable String couponCode) {
//        try {
//            boolean isValid = couponService.isCouponValid(couponCode);
//            return ResponseEntity.ok(isValid);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @GetMapping("/test")
    public String test() {
        String mapName = "coupon:1";
//        Object objTemplate = redisTemplate.opsForValue().get("coupon:1");
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        Object obj = redisTemplate.opsForHash().get("coupon", "coupon:1");
//        System.out.println(objTemplate);
        System.out.println(obj);
        return "test, Hello";
    }
}