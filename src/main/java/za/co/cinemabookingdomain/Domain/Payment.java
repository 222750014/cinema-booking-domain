package za.co.cinemabookingdomain.Domain;
import java.time.LocalTime;

public class Payment {
    private final String  paymentMethod;
    private final int transactionID;
    private final double amount;
    private final LocalTime time;

    private Payment(Builder builder) {
        this.paymentMethod = builder.paymentMethod;
        this.transactionID = builder.transactionID;
        this.amount = builder.amount;
        this.time = builder.time;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentMethod='" + paymentMethod + '\'' +
                ", transactionID=" + transactionID +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }

    public static class Builder {
        private  String  paymentMethod;
        private int transactionID;
        private double amount;
        private LocalTime time;

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setTransactionID(int transactionID) {
            this.transactionID = transactionID;
            return this;
        }

        public  Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }
        public Builder copy(Payment payment) {
            this.paymentMethod = payment.paymentMethod;
            this.transactionID = payment.transactionID;
            this.amount = payment.amount;
            this.time =payment.time;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
