package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Concession;
import java.util.UUID;

public class ConcessionFactory {
    public static Concession createConcession(String itemName, double price, int quantityAvailable) {
        return new Concession.Builder()
                .setId(UUID.randomUUID().toString())
                .setItemName(itemName)
                .setPrice(price)
                .setQuantityAvailable(quantityAvailable)
                .build();
    }
}
