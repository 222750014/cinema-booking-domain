/*Promotion.java
Promotion POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */

package za.co.cinemabookingdomain.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String promotionCode;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal discountPercentage;

    private BigDecimal discountAmount;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    private Integer maxUsageCount;
    private Integer currentUsageCount = 0;
    private Boolean isActive = true;

    protected Promotion() {}

    private Promotion(Builder builder) {
        this.promotionCode = builder.promotionCode;
        this.name = builder.name;
        this.description = builder.description;
        this.discountPercentage = builder.discountPercentage;
        this.discountAmount = builder.discountAmount;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.maxUsageCount = builder.maxUsageCount;
        this.currentUsageCount = builder.currentUsageCount;
        this.isActive = builder.isActive;
    }


    public Long getId() { return id; }
    public String getPromotionCode() { return promotionCode; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getDiscountPercentage() { return discountPercentage; }
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public LocalDateTime getStartDate() { return startDate; }
    public LocalDateTime getEndDate() { return endDate; }
    public Integer getMaxUsageCount() { return maxUsageCount; }
    public Integer getCurrentUsageCount() { return currentUsageCount; }
    public Boolean getIsActive() { return isActive; }


    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDiscountPercentage(BigDecimal discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setMaxUsageCount(Integer maxUsageCount) {
        this.maxUsageCount = maxUsageCount;
    }

    public void setCurrentUsageCount(Integer currentUsageCount) {
        this.currentUsageCount = currentUsageCount;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


    public void incrementUsageCount() {
        if (currentUsageCount != null) currentUsageCount++;
    }

    public void decrementUsageCount() {
        if (currentUsageCount != null && currentUsageCount > 0) currentUsageCount--;
    }

    public boolean isValidForUse() {
        LocalDateTime now = LocalDateTime.now();
        return isActive != null && isActive &&
                now.isAfter(startDate) &&
                now.isBefore(endDate) &&
                (maxUsageCount == null || currentUsageCount < maxUsageCount);
    }


    public static class Builder {
        private String promotionCode;
        private String name;
        private String description;
        private BigDecimal discountPercentage;
        private BigDecimal discountAmount;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Integer maxUsageCount;
        private Integer currentUsageCount = 0;
        private Boolean isActive = true;

        public Builder setPromotionCode(String promotionCode) {
            this.promotionCode = promotionCode;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDiscountPercentage(BigDecimal discountPercentage) {
            this.discountPercentage = discountPercentage;
            return this;
        }

        public Builder setDiscountAmount(BigDecimal discountAmount) {
            this.discountAmount = discountAmount;
            return this;
        }

        public Builder setStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder setMaxUsageCount(Integer maxUsageCount) {
            this.maxUsageCount = maxUsageCount;
            return this;
        }

        public Builder setCurrentUsageCount(Integer currentUsageCount) {
            this.currentUsageCount = currentUsageCount;
            return this;
        }

        public Builder setIsActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Promotion build() {
            return new Promotion(this);
        }
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", promotionCode='" + promotionCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", discountAmount=" + discountAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", maxUsageCount=" + maxUsageCount +
                ", currentUsageCount=" + currentUsageCount +
                ", isActive=" + isActive +
                '}';
    }
}
