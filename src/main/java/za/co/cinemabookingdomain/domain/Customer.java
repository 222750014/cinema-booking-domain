/*Customer.java
Customer POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */

package za.co.cinemabookingdomain.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
    private Integer loyaltyPoints;

    // Relationship with Booking entity
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    protected Customer() {}

    private Customer(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.loyaltyPoints = builder.loyaltyPoints;
    }

    // Getters
    public Long getId() {
        return id;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    // Setters (Added for update logic)
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLoyaltyPoints(Integer loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    // Helper methods for managing relationships
    public void addBooking(Booking booking) {
        bookings.add(booking);
        // Note: You'll need to add setCustomer method to Booking class
        // booking.setCustomer(this);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        // Note: You'll need to add setCustomer method to Booking class
        // booking.setCustomer(null);
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

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", bookingsCount=" + bookings.size() +
                '}';
    }
}