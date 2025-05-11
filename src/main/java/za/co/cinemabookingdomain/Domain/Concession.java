package za.co.cinemabookingdomain.Domain;

public class Concession {
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

    public static class Builder {
        private String itemName;
        private double price;
        private int availableQuantity;

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
