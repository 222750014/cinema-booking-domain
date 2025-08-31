<template>
  <div class="tickets-page">
    <div class="container">
      <h1>My Tickets</h1>
      
      <div v-if="bookings.length === 0" class="no-bookings">
        <div class="nav-buttons">
          <button @click="$router.push('/movies')">Movies</button>
          <button @click="$router.push('/')">Home</button>
          <button @click="$router.push('/cinemas')">Cinemas</button>
          <button @click="$router.push('/payment')">Payment</button>
        </div>
        <h3>No bookings found</h3>
        <p>You haven't booked any tickets yet.</p>
        <router-link to="/movies" class="browse-movies-btn">
          Browse Movies
        </router-link>
      </div>
      
      <div v-else class="bookings-list">
        <div class="nav-buttons">
          <button @click="$router.push('/movies')">Movies</button>
          <button @click="$router.push('/')">Home</button>
          <button @click="$router.push('/cinemas')">Cinemas</button>
          <button @click="$router.push('/payment')">Payment</button>
        </div>
        <div 
          v-for="booking in bookings" 
          :key="booking.id"
          class="booking-card"
        >
          <div class="booking-header">
            <h3>{{ booking.movieDetails.title }}</h3>
            <span class="booking-id">Booking ID: {{ booking.id }}</span>
          </div>
          
          <div class="booking-details">
            <div class="detail-row">
              <span class="label">Theater:</span>
              <span class="value">{{ booking.movieDetails.theater }}</span>
            </div>
            <div class="detail-row">
              <span class="label">Date & Time:</span>
              <span class="value">{{ booking.movieDetails.date }} at {{ booking.movieDetails.time }}</span>
            </div>
            <div class="detail-row">
              <span class="label">Seats:</span>
              <span class="value">{{ booking.seats.map(s => s.id).join(', ') }}</span>
            </div>
            <div class="detail-row">
              <span class="label">Total Amount:</span>
              <span class="value total-amount">Rs. {{ booking.totalCost }}</span>
            </div>
          </div>
          
          <div class="booking-actions">
            <button class="download-btn">Download Ticket</button>
            <button class="cancel-btn">Cancel Booking</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'Tickets',
  computed: {
    ...mapState('bookings', ['bookings'])
  }
}
</script>

<style scoped>
.tickets-page {
  background: #1a1a1a;
  min-height: 100vh;
  color: white;
  padding: 20px 0;
}

.container {
  max-width: 800px;
  margin: 0 auto;
  padding: 0 20px;
}

h1 {
  text-align: center;
  margin-bottom: 40px;
  color: #ffa500;
}

.no-bookings {
  text-align: center;
  padding: 60px 20px;
  background: #2a2a2a;
  border-radius: 15px;
}

.no-bookings h3 {
  margin-bottom: 15px;
  color: #ccc;
}

.no-bookings p {
  margin-bottom: 30px;
  color: #999;
}

.browse-movies-btn {
  background: #ffa500;
  color: white;
  text-decoration: none;
  padding: 12px 30px;
  border-radius: 25px;
  font-weight: bold;
  display: inline-block;
  transition: background 0.3s;
}

.browse-movies-btn:hover {
  background: #ff8c00;
}

.bookings-list {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.booking-card {
  background: #2a2a2a;
  border-radius: 15px;
  padding: 25px;
  border-left: 4px solid #ffa500;
}

.booking-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  padding-bottom: 15px;
  border-bottom: 1px solid #444;
}

.booking-header h3 {
  margin: 0;
  color: #ffa500;
}

.booking-id {
  font-size: 0.9em;
  color: #ccc;
}

.booking-details {
  margin-bottom: 20px;
}

.detail-row {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
}

.label {
  color: #ccc;
  font-weight: bold;
}

.value {
  color: white;
}

.total-amount {
  color: #4CAF50;
  font-weight: bold;
  font-size: 1.1em;
}

.booking-actions {
  display: flex;
  gap: 15px;
}

.download-btn, .cancel-btn {
  flex: 1;
  padding: 10px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-weight: bold;
  transition: background 0.3s;
}

.download-btn {
  background: #4CAF50;
  color: white;
}

.download-btn:hover {
  background: #45a049;
}

.cancel-btn {
  background: #f44336;
  color: white;
}

.cancel-btn:hover {
  background: #da190b;
}
</style>
