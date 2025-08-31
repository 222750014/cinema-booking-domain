<template>
  <form class="booking-form" @submit.prevent="submitBooking">



    <div class="form-group">

      <label for="customerId">Customer ID:</label>
      <input type="text" id="customerId" v-model="form.customerId" Customer ID is required>
    </div>

    <div class="form-group">
      <label for="customerName">Customer Name:</label>
      <input type="text" id="customerName" v-model="form.customerName" required>
    </div>

    <div class="form-group">
      <label for="movieTitle">Movie Title:</label>
      <select id="movieTitle" v-model="form.movieTitle" required>
        <option value="">Select...</option>
        <option value="moana">Moana</option>
        <option value="mothersinstinct">Mothers Instinct</option>
        <option value="theconjuring">The Conjuring</option>
      </select>
    </div>

    <div class="form-group">
      <label for="bookingDate">Booking Date:</label>
      <input type="date" id="bookingDate" v-model="form.bookingDate" required>
    </div>

    <div class="form-group">
      <label for="bookingTime">Booking Time:</label>
      <select id="bookingTime" v-model="form.bookingTime" required>
        <option value="">Select...</option>
        <option value="">10:30</option>
        <option value="">15:00</option>
        <option value="">17:00</option>
      </select>
    </div>

    <div class="form-group">
      <label for="ticketPrice">Ticket Price:</label>
      <select id="ticketPrice" v-model="form.ticketPrice" required>
        <option value="">Select...</option>
        <option value="">R100</option>
        <option value="">R250</option>
        <option value="">R160</option>
      </select>
    </div>

    <div class="form-group">
      <label for="paymentMethod">Payment Method:</label>
      <select id="paymentMethod" v-model="form.paymentMethod" required>
        <option value="">Select...</option>
        <option value="Credit Card">Credit Card</option>
        <option value="Cash">Cash</option>
        <option value="EFT">EFT</option>
      </select>
    </div>

    <div class="form-group">
      <label for="status">Status:</label>
      <select id="status" v-model="form.status" required>
        <option value="">Select...</option>
        <option value="Pending">Pending</option>
        <option value="Confirmed">Confirmed</option>
        <option value="Cancelled">Cancelled</option>
      </select>
    </div>

    <button type="submit">Submit Booking</button>
  </form>

</template>

<script>
export default {
  name: 'BookingForm',
  data() {
    return {
      form: {
        customerId: '',
        customerName: '',
        bookingDate: '',
        bookingTime: '',
        movieTitle: '',
        ticketPrice: '',
        paymentMethod: '',
        status: ''
      }
    }
  },
  methods: {
    submitBooking() {
      console.log('Booking submitted:', this.form)
      alert('Booking submitted successfully!')
      // You can send this.form to your backend API here
    }
  }
}
</script>

<style>
.booking-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 15px;
  background: #ff6b35;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
  color: white;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
}

input, select, button {
  padding: 8px;
  width: 100%;
  box-sizing: border-box;
}

button {
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 5px;
}

button:hover {
  background-color: #0056b3;
}
</style>
