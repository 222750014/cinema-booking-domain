package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customerDetails);

    void deleteCustomer(Long id);

    Optional<Customer> getCustomerByEmail(String email);

    List<Customer> searchCustomersByName(String name);

    List<Customer> getTopCustomersByLoyaltyPoints();

    long countCustomersWithLoyaltyPointsAbove(Integer points);
}