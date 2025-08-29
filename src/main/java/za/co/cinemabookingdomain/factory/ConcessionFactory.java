package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.domain.Concession;

public class ConcessionFactory {

    public static Concession createConcession(String itemName, double price, int quantityAvailable, String id) {
        return new Concession.Builder()
                .setId(id)
                .setItemName(itemName)
                .setPrice(price)
                .setQuantityAvailable(quantityAvailable)
                .build();
    }
}
