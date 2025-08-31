package za.co.cinemabookingdomain.domain;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String paymentId;
    @Column
    private String paymentMethod;
    @Column
    private double amount;
    @Column
    private LocalTime time;

    public Payment(){}


    private Payment(Builder builder) {
        this.paymentMethod = builder.paymentMethod;
        this.paymentId = builder.paymentId;
        this.amount = builder.amount;
        this.time = builder.time;
    }

    public String getPaymentId() {
        return paymentId;
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
                ", PaymentId=" + paymentId +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }

    public static class Builder {
        private String paymentId;
        private String paymentMethod;
        private double amount;
        private LocalTime time;

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setTime(LocalTime time) {
            this.time = time;
            return this;
        }

        public Builder copy(Payment payment) {
            this.paymentId = payment.paymentId;
            this.paymentMethod = payment.paymentMethod;
            this.amount = payment.amount;
            this.time = payment.time;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}

