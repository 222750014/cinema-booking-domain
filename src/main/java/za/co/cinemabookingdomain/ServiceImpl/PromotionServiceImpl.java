/*Customer.java
Customer POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */

package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.cinemabookingdomain.Domain.Promotion;
import za.co.cinemabookingdomain.Repository.PromotionRepository;
import za.co.cinemabookingdomain.Service.PromotionService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Promotion> getPromotionById(Long id) {
        return promotionRepository.findById(id);
    }

    @Override
    @Transactional
    public Promotion createPromotion(Promotion promotion) {
        if (promotionRepository.findByPromotionCode(promotion.getPromotionCode()).isPresent()) {
            throw new IllegalArgumentException("Promotion with this code already exists: " + promotion.getPromotionCode());
        }

        if (promotion.getStartDate().isAfter(promotion.getEndDate())) {
            throw new IllegalArgumentException("Promotion start date cannot be after end date.");
        }

        return promotionRepository.save(promotion);
    }

    @Override
    @Transactional
    public Promotion updatePromotion(Long id, Promotion promotionDetails) {
        return promotionRepository.findById(id).map(existingPromotion -> {

            if (!existingPromotion.getPromotionCode().equalsIgnoreCase(promotionDetails.getPromotionCode())) {
                Optional<Promotion> existingCode = promotionRepository.findByPromotionCode(promotionDetails.getPromotionCode());
                if (existingCode.isPresent() && !existingCode.get().getId().equals(id)) {
                    throw new IllegalArgumentException("Promotion code already taken by another promotion: " + promotionDetails.getPromotionCode());
                }
                existingPromotion.setPromotionCode(promotionDetails.getPromotionCode());
            }

            existingPromotion.setName(promotionDetails.getName());
            existingPromotion.setDescription(promotionDetails.getDescription());
            existingPromotion.setStartDate(promotionDetails.getStartDate());
            existingPromotion.setEndDate(promotionDetails.getEndDate());
            existingPromotion.setDiscountPercentage(promotionDetails.getDiscountPercentage());
            existingPromotion.setDiscountAmount(promotionDetails.getDiscountAmount());
            existingPromotion.setMaxUsageCount(promotionDetails.getMaxUsageCount());
            existingPromotion.setIsActive(promotionDetails.getIsActive());

            if (existingPromotion.getStartDate().isAfter(existingPromotion.getEndDate())) {
                throw new IllegalArgumentException("Updated promotion start date cannot be after end date.");
            }

            return promotionRepository.save(existingPromotion);
        }).orElseThrow(() -> new RuntimeException("Promotion not found with id " + id));
    }

    @Override
    @Transactional
    public void deletePromotion(Long id) {
        if (!promotionRepository.existsById(id)) {
            throw new RuntimeException("Promotion not found with id " + id);
        }
        promotionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Promotion> getPromotionByCode(String promotionCode) {
        return promotionRepository.findByPromotionCode(promotionCode);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Promotion> getActivePromotions() {
        LocalDateTime now = LocalDateTime.now();
        return promotionRepository.findValidPromotions(now);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Promotion> searchPromotionsByDescription(String description) {
        return promotionRepository.findByDescriptionContainingIgnoreCase(description);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isValidPromotion(String promotionCode, LocalDate bookingDate) {
        return promotionRepository.findByPromotionCode(promotionCode)
                .filter(p -> Boolean.TRUE.equals(p.getIsActive())
                        && !bookingDate.atStartOfDay().isBefore(p.getStartDate())
                        && !bookingDate.atStartOfDay().isAfter(p.getEndDate()))
                .isPresent();
    }
}
