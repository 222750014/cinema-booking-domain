package za.co.cinemabookingdomain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.cinemabookingdomain.Domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find customer by email (matches your entity field)
    Optional<Customer> findByEmail(String email);

    // Find customers by name containing keyword (case-insensitive)
    List<Customer> findByNameContainingIgnoreCase(String name);

    // Find customers with loyalty points greater than minimum
    List<Customer> findByLoyaltyPointsGreaterThan(Integer minPoints);

    // Find customers with loyalty points between range
    List<Customer> findByLoyaltyPointsBetween(Integer minPoints, Integer maxPoints);

    // Find customers by phone number
    Optional<Customer> findByPhone(String phone);

    // Custom query to find top customers by loyalty points
    @Query("SELECT c FROM Customer c ORDER BY c.loyaltyPoints DESC")
    List<Customer> findTopCustomersByLoyaltyPoints();

    // Count customers with loyalty points above threshold
    @Query("SELECT COUNT(c) FROM Customer c WHERE c.loyaltyPoints > :points")
    long countCustomersWithLoyaltyPointsAbove(@Param("points") Integer points);
}
