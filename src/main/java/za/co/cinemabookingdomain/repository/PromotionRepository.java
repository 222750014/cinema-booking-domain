/*Customer.java
Customer POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */

package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.cinemabookingdomain.domain.Promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    Optional<Promotion> findByPromotionCode(String promotionCode); // ✅ NEW METHOD

    Optional<Promotion> findByName(String name);
    List<Promotion> findByIsActiveTrue();

    @Query("SELECT p FROM Promotion p WHERE p.startDate <= :now AND p.endDate >= :now AND p.isActive = true")
    List<Promotion> findValidPromotions(@Param("now") LocalDateTime now);

    List<Promotion> findByDescriptionContainingIgnoreCase(String keyword);
    List<Promotion> findByDiscountPercentageGreaterThan(BigDecimal minPercentage);

    @Query("SELECT p FROM Promotion p WHERE p.maxUsageCount IS NULL OR p.currentUsageCount < p.maxUsageCount")
    List<Promotion> findAvailablePromotions();

    @Query("SELECT p FROM Promotion p WHERE p.endDate BETWEEN :now AND :futureDate AND p.isActive = true")
    List<Promotion> findPromotionsEndingSoon(@Param("now") LocalDateTime now, @Param("futureDate") LocalDateTime futureDate);

    List<Promotion> findByDiscountAmount(BigDecimal discountAmount);

    long countByIsActiveTrue();

    @Query("SELECT p FROM Promotion p WHERE p.endDate < :now")
    List<Promotion> findExpiredPromotions(@Param("now") LocalDateTime now);
}
