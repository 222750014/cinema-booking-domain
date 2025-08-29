package za.co.cinemabookingdomain.domain;

public class Concession {
    private final String id;
    private final String itemName;
    private final double price;
    private final int quantityAvailable;

    private Concession(Builder builder) {
        this.id = builder.id;
        this.itemName = builder.itemName;
        this.price = builder.price;
        this.quantityAvailable = builder.quantityAvailable;
    }

    public String getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public static class Builder {
        private String id;
        private String itemName;
        private double price;
        private int quantityAvailable;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setItemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setQuantityAvailable(int quantityAvailable) {
            this.quantityAvailable = quantityAvailable;
            return this;
        }


        public Builder copy(Concession concession) {
            this.id = concession.getId();
            this.itemName = concession.getItemName();
            this.price = concession.getPrice();
            this.quantityAvailable = concession.getQuantityAvailable();
            return this;
        }

        public Concession build() {
            return new Concession(this);
        }
    }

    @Override
    public String toString() {
        return "Concession{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}