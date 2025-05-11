package za.co.cinemabookingdomain.Domain;


/*
Author Emmanuel Posholi 222144408
Date: 11 May 2025
 */


import java.time.LocalDate;

public class Promotion {
    private final String discountCode;
    private final String description;
    private final LocalDate validity;

    private Promotion(Builder builder) {
        this.discountCode = builder.discountCode;
        this.description = builder.description;
        this.validity = builder.validity;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public static class Builder {
        private String discountCode;
        private String description;
        private LocalDate validity;

        public Builder setDiscountCode(String discountCode) {
            this.discountCode = discountCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setValidity(LocalDate validity) {
            this.validity = validity;
            return this;
        }

        public Builder copy(Promotion promotion) {
            this.discountCode = promotion.getDiscountCode();
            this.description = promotion.getDescription();
            this.validity = promotion.getValidity();
            return this;
        }

        public Promotion build() {
            return new Promotion(this);
        }
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "discountCode='" + discountCode + '\'' +
                ", description='" + description + '\'' +
                ", validity=" + validity +
                '}';
    }
}