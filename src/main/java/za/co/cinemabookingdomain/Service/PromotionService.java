/*Customer.java
Customer POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */

package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Promotion; 
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionService {
    List<Promotion> getAllPromotions();
    Optional<Promotion> getPromotionById(Long id);
    Promotion createPromotion(Promotion promotion);
    Promotion updatePromotion(Long id, Promotion promotionDetails);
    void deletePromotion(Long id);
    Optional<Promotion> getPromotionByCode(String promotionCode);
    List<Promotion> getActivePromotions();
    List<Promotion> searchPromotionsByDescription(String description);
    boolean isValidPromotion(String promotionCode, LocalDate bookingDate);
}
