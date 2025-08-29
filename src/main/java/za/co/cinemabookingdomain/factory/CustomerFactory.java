/*CustomerFactory.java
CustomerFactory POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */

package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Customer;

public class CustomerFactory {

    public static Customer createCustomer(String name, String email, String phone, Integer loyaltyPoints) {
        return new Customer.Builder()
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setLoyaltyPoints(loyaltyPoints)
                .build();
    }
}
