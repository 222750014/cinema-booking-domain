package za.co.cinemabookingdomain.Domain;

import org.hibernate.AssertionFailure;
import org.junit.jupiter.api.AssertionFailureBuilder;

public class Concession {
    private String id;
    private final String itemName;
    private final double price;
    private final int availableQuantity;

    private Concession(Builder builder) {
        this.itemName = builder.itemName;
        this.price = builder.price;
        this.availableQuantity = builder.availableQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public String getId(String id) {
        return this.id;
    }

    public static class Builder {
        private String itemName;
        private double price;
        private int availableQuantity;
        private String id;

        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setAvailableQuantity(int availableQuantity) {
            this.availableQuantity = availableQuantity;
            return this;
        }

        public Builder copy(Concession concession) {
            this.itemName = concession.getItemName();
            this.price = concession.getPrice();
            this.availableQuantity = concession.getAvailableQuantity();
            return this;
        }

        public Concession build() {

            return new Concession(this);
        }


        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public AssertionFailureBuilder setQuantityAvailable(int i) {
            return null;

        }
    }

    @Override
    public String toString() {
        return "Concession{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}

