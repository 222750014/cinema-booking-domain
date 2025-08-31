<template>
  <div class="payment-page">
    <div class="container">
      <h1>Payment</h1>
      <form @submit.prevent="submitPayment" class="payment-form">
        <div class="form-group">
          <label for="paymentMethod">Payment Method</label>
          <select v-model="payment.paymentMethod" id="paymentMethod">
            <option value="">Select Method</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="UPI">UPI</option>
          </select>
        </div>
        <div v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'" class="form-group">
          <label for="cardNumber">Card Number</label>
          <input v-model="payment.cardNumber" id="cardNumber" type="text" maxlength="16" placeholder="Enter Card Number" />
        </div>
        <div v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'" class="form-group">
          <label for="cardName">Cardholder Name</label>
          <input v-model="payment.cardName" id="cardName" type="text" placeholder="Enter Cardholder Name" />
        </div>
        <div v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'" class="form-group">
          <label for="expiry">Expiry Date</label>
          <input v-model="payment.expiry" id="expiry" type="month" placeholder="MM/YY" />
        </div>
        <div v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'" class="form-group">
          <label for="cvv">CVV</label>
          <input v-model="payment.cvv" id="cvv" type="password" maxlength="4" placeholder="CVV" />
        </div>
        <div class="form-group">
          <label for="amount">Amount</label>
          <input v-model.number="payment.amount" id="amount" type="number" min="0" step="0.01" placeholder="Enter Amount" />
        </div>
        <div class="form-group">
          <label for="time">Time</label>
          <input v-model="payment.time" id="time" type="time" />
        </div>
        <button type="submit" class="submit-btn">Submit Payment</button>
        <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
      </form>
      <div v-if="submitted" class="payment-summary">
        <h2>Payment Summary</h2>
        <p><strong>Method:</strong> {{ payment.paymentMethod }}</p>
        <p v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'"><strong>Card Number:</strong> {{ payment.cardNumber }}</p>
        <p v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'"><strong>Cardholder Name:</strong> {{ payment.cardName }}</p>
        <p v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'"><strong>Expiry:</strong> {{ payment.expiry }}</p>
        <p v-if="payment.paymentMethod === 'Credit Card' || payment.paymentMethod === 'Debit Card'"><strong>CVV:</strong> ****</p>
        <p><strong>Amount:</strong> {{ payment.amount }}</p>
        <p><strong>Time:</strong> {{ payment.time }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Payment',
  data() {
    return {
      payment: {
        paymentMethod: '',
        amount: 0,
        time: '',
        cardNumber: '',
        cardName: '',
        expiry: '',
        cvv: ''
      },
      submitted: false,
      errorMessage: ''
    }
  },
  methods: {
    submitPayment() {
      this.errorMessage = '';
      if ((this.payment.paymentMethod === 'Credit Card' || this.payment.paymentMethod === 'Debit Card')) {
        if (!this.payment.cardNumber || this.payment.cardNumber.length < 16) {
          this.errorMessage = 'Please enter a valid 16-digit card number.';
          return;
        }
        if (!this.payment.cardName) {
          this.errorMessage = 'Please enter the cardholder name.';
          return;
        }
        if (!this.payment.expiry) {
          this.errorMessage = 'Please enter the expiry date.';
          return;
        }
        if (!this.payment.cvv || this.payment.cvv.length < 3) {
          this.errorMessage = 'Please enter a valid CVV.';
          return;
        }
      }
      if (!this.payment.amount || this.payment.amount <= 0) {
        this.errorMessage = 'Please enter a valid amount.';
        return;
      }
      this.submitted = true;
      // Here you could send payment to backend if needed
    }
  }
}
</script>

<style scoped>
.payment-page {
  background: #1a1a1a;
  min-height: 100vh;
  color: white;
  padding: 20px 0;
}

.container {
  max-width: 500px;
  margin: 0 auto;
  padding: 0 20px;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
  color: #ffa500;
}

.payment-form {
  background: #2a2a2a;
  padding: 25px;
  border-radius: 15px;
  margin-bottom: 30px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 8px;
  color: #ffa500;
}

input, select {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 8px;
  font-size: 1em;
  background: #333;
  color: white;
}

.submit-btn {
  background: #4CAF50;
  color: white;
  border: none;
  padding: 12px 25px;
  border-radius: 25px;
  cursor: pointer;
  font-weight: bold;
  transition: background 0.3s;
}

.submit-btn:hover {
  background: #45a049;
}

.payment-summary {
  background: #222;
  padding: 20px;
  border-radius: 10px;
  color: #fff;
}

.error-message {
  color: #ff4d4f;
  background: #fff0f0;
  padding: 10px;
  border-radius: 8px;
  margin-bottom: 15px;
  text-align: center;
}
</style>