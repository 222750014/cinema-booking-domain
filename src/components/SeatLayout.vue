<template>
  <div class="seat-layout">
    <div class="movie-details">
      <div class="movie-info-header">
        <img src="https://via.placeholder.com/80x100/0066cc/fff?text=Movie" :alt="movieDetails.title" class="movie-poster-small">
        <div class="movie-text">
          <h3>{{ movieDetails.title }}</h3>
          <p>Theater: {{ movieDetails.theater }}</p>
          <p>City: {{ movieDetails.city }}</p>
          <p>Date: {{ movieDetails.date }}</p>
          <p>Time: {{ movieDetails.time }}</p>
          <p>Seats: {{ movieDetails.seats }}</p>
        </div>
      </div>
      <div class="total-cost">
        <h3>Cost: {{ totalCost }} (inclusive of all costs, charges & taxes)</h3>
      </div>
    </div>

    <div class="seat-selection-area">
      <h3>Seat Layout</h3>
      <button class="proceed-btn" @click="proceedToPayment">Proceed to Order</button>
      
      <div class="seat-legend">
        <div class="legend-item">
          <div class="seat-sample available"></div>
          <span>Available Seats</span>
        </div>
        <div class="legend-item">
          <div class="seat-sample booked"></div>
          <span>Booked Seats</span>
        </div>
        <div class="legend-item">
          <div class="seat-sample selected"></div>
          <span>Your Selection</span>
        </div>
        <div class="legend-item">
          <div class="seat-sample unavailable"></div>
          <span>Unavailable Seats</span>
        </div>
      </div>

      <div class="seat-grid">
        <div class="class-section">
          <h4>Class1 Rs.100.00</h4>
          <div class="seat-rows">
            <div v-for="row in class1Seats" :key="row.row" class="seat-row">
              <span class="row-label">{{ row.row }}</span>
              <div 
                v-for="seat in row.seats" 
                :key="seat.id"
                @click="toggleSeat(seat)"
                class="seat"
                :class="seat.status"
              >
                {{ seat.number }}
              </div>
              <span class="row-label">{{ row.row }}</span>
            </div>
          </div>
        </div>

        <div class="class-section">
          <div class="seat-rows">
            <div v-for="row in class2Seats" :key="row.row" class="seat-row">
              <span class="row-label">{{ row.row }}</span>
              <div 
                v-for="seat in row.seats" 
                :key="seat.id"
                @click="toggleSeat(seat)"
                class="seat"
                :class="seat.status"
              >
                {{ seat.number }}
              </div>
              <span class="row-label">{{ row.row }}</span>
            </div>
          </div>
        </div>
      </div>

      <div class="screen-area">
        <div class="screen">SCREEN</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SeatLayout',
  props: {
    movieId: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      selectedSeats: [],
      movieDetails: {
        title: 'Finding Nemo 3D',
        theater: 'IMAX',
        city: 'Visakhapatnam',
        date: '6/9/2015',
        time: '03:00 PM',
        seats: 'J404,J405,J406,J407'
      },
      class1Seats: [
        {
          row: 'A',
          seats: this.generateSeats('A', 1, 12, ['available', 'available', 'available', 'available', 'selected', 'selected', 'selected', 'selected', 'available', 'available', 'available', 'available'])
        }
      ],
      class2Seats: [
        {
          row: 'B',
          seats: this.generateSeats('B', 1, 12, ['available', 'available', 'available', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'available', 'available', 'available'])
        },
        {
          row: 'C',
          seats: this.generateSeats('C', 1, 12, ['available', 'available', 'available', 'available', 'available', 'available', 'available', 'available', 'available', 'available', 'available', 'available'])
        },
        {
          row: 'D',
          seats: this.generateSeats('D', 1, 12, ['booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked'])
        },
        {
          row: 'E',
          seats: this.generateSeats('E', 1, 12, ['booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked', 'booked'])
        }
      ]
    }
  },
  computed: {
    totalCost() {
      const selectedCount = this.selectedSeats.length
      return `Rs.${selectedCount * 100}.00`
    }
  },
  methods: {
    generateSeats(row, start, end, statuses) {
      const seats = []
      for (let i = start; i <= end; i++) {
        seats.push({
          id: `${row}${i}`,
          row,
          number: i,
          status: statuses[i - 1] || 'available'
        })
      }
      return seats
    },
    toggleSeat(seat) {
      if (seat.status === 'booked' || seat.status === 'unavailable') {
        return
      }

      if (seat.status === 'selected') {
        seat.status = 'available'
        this.selectedSeats = this.selectedSeats.filter(s => s.id !== seat.id)
      } else {
        seat.status = 'selected'
        this.selectedSeats.push(seat)
      }
    },
    proceedToPayment() {
      if (this.selectedSeats.length === 0) {
        alert('Please select at least one seat')
        return
      }
      
      // Here you would proceed to payment
      const booking = {
        movieId: this.movieId,
        seats: this.selectedSeats,
        totalCost: this.selectedSeats.length * 100,
        movieDetails: this.movieDetails
      }
      
      this.$store.dispatch('bookings/createBooking', booking)
      alert(`Booking confirmed for ${this.selectedSeats.length} seats!`)
    }
  }
}
</script>

<style scoped>
.seat-layout {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  background: #1a1a1a;
  color: white;
  min-height: 100vh;
}

.movie-details {
  background: linear-gradient(135deg, #8B4513, #D2691E);
  padding: 20px;
  border-radius: 10px;
  margin-bottom: 20px;
}

.movie-info-header {
  display: flex;
  gap: 20px;
  align-items: center;
  margin-bottom: 15px;
}

.movie-poster-small {
  width: 80px;
  height: 100px;
  object-fit: cover;
  border-radius: 5px;
}

.movie-text h3 {
  margin: 0 0 10px 0;
  font-size: 1.5em;
}

.movie-text p {
  margin: 5px 0;
  font-size: 0.9em;
}

.total-cost {
  border-top: 1px solid rgba(255,255,255,0.3);
  padding-top: 15px;
}

.total-cost h3 {
  margin: 0;
  font-size: 1.2em;
}

.seat-selection-area {
  background: #2a2a2a;
  padding: 20px;
  border-radius: 10px;
}

.seat-selection-area h3 {
  text-align: center;
  margin-bottom: 10px;
}

.proceed-btn {
  background: #ffa500;
  color: white;
  border: none;
  padding: 10px 30px;
  border-radius: 20px;
  cursor: pointer;
  font-weight: bold;
  float: right;
  margin-bottom: 20px;
}

.proceed-btn:hover {
  background: #ff8c00;
}

.seat-legend {
  display: flex;
  justify-content: center;
  gap: 30px;
  margin-bottom: 30px;
  clear: both;
}

.legend-item {
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 0.9em;
}

.seat-sample {
  width: 20px;
  height: 20px;
  border-radius: 3px;
  border: 1px solid #666;
}

.class-section {
  margin-bottom: 30px;
}

.class-section h4 {
  text-align: center;
  color: #ffa500;
  margin-bottom: 15px;
}

.seat-grid {
  max-width: 600px;
  margin: 0 auto;
}

.seat-row {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 8px;
  gap: 5px;
}

.row-label {
  width: 20px;
  text-align: center;
  font-weight: bold;
  color: #ccc;
}

.seat {
  width: 30px;
  height: 30px;
  border: 1px solid #666;
  border-radius: 3px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  font-size: 0.8em;
  font-weight: bold;
  transition: all 0.3s ease;
}

.seat.available {
  background: #666;
  color: white;
}

.seat.available:hover {
  background: #888;
}

.seat.booked {
  background: #ff6b35;
  color: white;
  cursor: not-allowed;
}

.seat.selected {
  background: #4CAF50;
  color: white;
}

.seat.unavailable {
  background: #444;
  color: #666;
  cursor: not-allowed;
}

.screen-area {
  margin-top: 40px;
  text-align: center;
}

.screen {
  background: #333;
  color: white;
  padding: 15px;
  border-radius: 20px;
  font-weight: bold;
  font-size: 1.2em;
  display: inline-block;
  min-width: 300px;
  border: 2px solid #666;
}
</style>