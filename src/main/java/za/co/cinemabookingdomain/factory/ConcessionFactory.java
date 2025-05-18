package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Concession;

public class ConcessionFactory {
    public static Concession createConcession(String itemName, double price, int availableQuantity) {
        return new Concession.Builder()
                .setItemName(itemName)
                .setPrice(price)
                .setAvailableQuantity(availableQuantity)
                .build();
    }
}
