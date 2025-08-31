<template>
  <form class="seat-form" @submit.prevent="submitSeat">
    <!-- Seat Number -->
    <div class="form-group">
      <label for="seatNumber">Seat Number:</label>
      <select id="seatNumber" v-model="seat.seatNumber" required>
        <option value="">Select...</option>
        <option value="">1</option>
        <option value="">2</option>
        <option value="">3</option>
      </select>
    </div>

    <!-- Seat Type -->
    <div class="form-group">
      <label for="seatType">Seat Type:</label>
      <select id="seatType" v-model="seat.seatType" required>
        <option value="">Select...</option>
        <option value="Standard">Standard</option>
        <option value="VIP">VIP</option>
        <option value="Recliner">Luxury Seat</option>
      </select>
    </div>

    <!-- Seat Row -->
    <div class="form-group">
      <label for="seatRow">Seat Row:</label>
      <select id="seatRow" v-model="seat.seatRow" required>
        <option value="">Select...</option>
        <option value="">1</option>
        <option value="">2</option>
        <option value="">3</option>
      </select>

    </div>

    <button type="submit">Confirm Seat</button>
  </form>
</template>

<script>
export default {
  name: 'SeatForm',
  data() {
    return {
      seat: {
        seatNumber: '',
        seatType: '',
        seatRow: ''
      }
    }
  },
  methods: {
    submitSeat() {
      console.log('Selected Seat:', this.seat)
      alert(`Seat confirmed: ${this.seat.seatRow}-${this.seat.seatNumber} (${this.seat.seatType})`)
      // You can send this.seat to your backend API here
    }
  }
}
</script>

<style>
.seat-form {
  display: flex;
  flex-direction: column;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
  color: #000;
}

input, select, button {
  padding: 8px;
  width: 100%;
  box-sizing: border-box;
}

button {
  background-color: #28a745;
  color: white;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  padding: 10px;
}

button:hover {
  background-color: #1e7e34;
}
</style>
