/*PromotionController.java
PromotionController POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */

package za.co.cinemabookingdomain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.cinemabookingdomain.Domain.Promotion;
import za.co.cinemabookingdomain.Service.PromotionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }


    @GetMapping
    public List<Promotion> getAllPromotions() {
        return promotionService.getAllPromotions();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getPromotionById(@PathVariable Long id) {
        return promotionService.getPromotionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/code/{code}")
    public ResponseEntity<Promotion> getPromotionByCode(@PathVariable String code) {
        return promotionService.getPromotionByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Promotion> createPromotion(@RequestBody Promotion promotion) {
        Promotion created = promotionService.createPromotion(promotion);
        return ResponseEntity.ok(created);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Promotion> updatePromotion(@PathVariable Long id, @RequestBody Promotion updatedPromotion) {
        try {
            Promotion updated = promotionService.updatePromotion(id, updatedPromotion);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePromotion(@PathVariable Long id) {
        try {
            promotionService.deletePromotion(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/search")
    public List<Promotion> searchPromotions(@RequestParam String description) {
        return promotionService.searchPromotionsByDescription(description);
    }


    @GetMapping("/active")
    public List<Promotion> getActivePromotions() {
        return promotionService.getActivePromotions();
    }


    @GetMapping("/validate/{code}")
    public boolean validatePromotion(@PathVariable String code, @RequestParam LocalDate bookingDate) {
        return promotionService.isValidPromotion(code, bookingDate);
    }
}
