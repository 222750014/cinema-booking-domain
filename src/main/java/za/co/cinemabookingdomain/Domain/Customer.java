package za.co.cinemabookingdomain.Domain;

/*
Author Emmanuel Posholi 222144408
Date: 11 May 2025
 */

public class Customer {

    private final String name;
    private final String email;
    private final String phone;
    private final Integer loyaltyPoints; // Optional

    private Customer(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.loyaltyPoints = builder.loyaltyPoints;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public static class Builder {
        private String name;
        private String email;
        private String phone;
        private Integer loyaltyPoints;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setLoyaltyPoints(Integer loyaltyPoints) {
            this.loyaltyPoints = loyaltyPoints;
            return this;
        }

        public Builder copy(Customer customer) {
            this.name = customer.getName();
            this.email = customer.getEmail();
            this.phone = customer.getPhone();
            this.loyaltyPoints = customer.getLoyaltyPoints();
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", loyaltyPoints=" + (loyaltyPoints != null ? loyaltyPoints : "N/A") +
                '}';
    }
}