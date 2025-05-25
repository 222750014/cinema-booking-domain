package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.cinemabookingdomain.Domain.Customer;
import za.co.cinemabookingdomain.Repository.CustomerRepository;
import za.co.cinemabookingdomain.Service.CustomerService;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    @Transactional
    public Customer createCustomer(Customer customer) {
        // Business logic: Email must be unique
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already in use: " + customer.getEmail());
        }
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer updateCustomer(Long id, Customer customerDetails) {
        return customerRepository.findById(id).map(existingCustomer -> {
            // Update fields
            if (!existingCustomer.getEmail().equalsIgnoreCase(customerDetails.getEmail())) {
                if (customerRepository.findByEmail(customerDetails.getEmail()).isPresent()) {
                    throw new IllegalArgumentException("Email already in use: " + customerDetails.getEmail());
                }
                existingCustomer.setEmail(customerDetails.getEmail());
            }
            existingCustomer.setName(customerDetails.getName());
            existingCustomer.setPhone(customerDetails.getPhone());
            existingCustomer.setLoyaltyPoints(customerDetails.getLoyaltyPoints());
            return customerRepository.save(existingCustomer);
        }).orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    @Override
    @Transactional
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found with id " + id);
        }
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> searchCustomersByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getTopCustomersByLoyaltyPoints() {
        return customerRepository.findTopCustomersByLoyaltyPoints();
    }

    @Override
    @Transactional(readOnly = true)
    public long countCustomersWithLoyaltyPointsAbove(Integer points) {
        return customerRepository.countCustomersWithLoyaltyPointsAbove(points);
    }
}