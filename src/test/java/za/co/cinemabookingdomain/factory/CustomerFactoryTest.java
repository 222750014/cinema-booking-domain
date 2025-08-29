/*CustomerFactoryTest.java
CustomerFactoryTest POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */
package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {

    @Test
    public void testCreateCustomer() {
        Customer customer = CustomerFactory.createCustomer(
                "Jane Doe", "jane13@gmail.com", "0734267890", 50);

        assertNotNull(customer);
        assertEquals("Jane Doe", customer.getName());
        assertEquals("jane@gmail.com", customer.getEmail());
        assertEquals("0734267890", customer.getPhone());
        assertEquals(50, customer.getLoyaltyPoints());
    }
}
