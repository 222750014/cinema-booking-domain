<template>
  <div class="cinemas-page">
    <div class="container">
      <h1>Cinemas & Theaters</h1>
      
      <div class="city-selector">
        <select v-model="selectedCity" class="city-select">
          <option value="">Select City</option>
          <option value="visakhapatnam">Visakhapatnam</option>
          <option value="hyderabad">Hyderabad</option>
          <option value="chennai">Chennai</option>
          <option value="bangalore">Bangalore</option>
        </select>
      </div>
      
      <div class="theaters-grid">
        <div 
          v-for="theater in filteredTheaters" 
          :key="theater.id"
          class="theater-card"
        >
          <h3>{{ theater.name }}</h3>
          <p class="location">📍 {{ theater.location }}</p>
          <div class="facilities">
            <span 
              v-for="facility in theater.facilities" 
              :key="facility"
              class="facility-tag"
            >
              {{ facility }}
            </span>
          </div>
          <button class="view-showtimes-btn" @click="$router.push('/movies')">View Showtimes</button>
          <button class="nav-btn" @click="$router.push('/tickets')">Go to Tickets</button>
          <button class="nav-btn" @click="$router.push('/payment')">Go to Payment</button>
          <button class="nav-btn" @click="$router.push('/')">Go to Home</button>
        </div>
      </div>
      <div class="nav-buttons">
        <button @click="$router.push('/movies')">Movies</button>
        <button @click="$router.push('/')">Home</button>
        <button @click="$router.push('/tickets')">Tickets</button>
        <button @click="$router.push('/payment')">Payment</button>
      </div>
        </div>
      </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'Cinemas',
  data() {
    return {
      selectedCity: ''
    }
  },
  computed: {
    ...mapState('theaters', ['theaters']),
    filteredTheaters() {
      if (!this.selectedCity) return this.theaters
      return this.theaters.filter(theater => 
        theater.location.toLowerCase().includes(this.selectedCity.toLowerCase())
      )
    }
  },
  mounted() {
    this.$store.dispatch('theaters/fetchTheaters')
  }
}
</script>

<style scoped>
.cinemas-page {
  background: #1a1a1a;
  min-height: 100vh;
  color: white;
  padding: 20px 0;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
}

h1 {
  text-align: center;
  margin-bottom: 30px;
  color: #ffa500;
}

.city-selector {
  text-align: center;
  margin-bottom: 40px;
}

.city-select {
  padding: 12px 20px;
  border: none;
  border-radius: 25px;
  outline: none;
  font-size: 1em;
  min-width: 200px;
}

.theaters-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 30px;
}

.theater-card {
  background: #2a2a2a;
  padding: 25px;
  border-radius: 15px;
  text-align: center;
  transition: transform 0.3s ease;
}

.theater-card:hover {
  transform: translateY(-5px);
}

.theater-card h3 {
  margin: 0 0 15px 0;
  color: #ffa500;
  font-size: 1.3em;
}

.location {
  color: #ccc;
  margin-bottom: 20px;
  font-size: 1em;
}

.facilities {
  display: flex;
  flex-wrap: wrap;
  gap: 8px;
  justify-content: center;
  margin-bottom: 20px;
}

.facility-tag {
  background: #ff6b35;
  color: white;
  padding: 5px 12px;
  border-radius: 15px;
  font-size: 0.8em;
  font-weight: bold;
}

.view-showtimes-btn {
  background: #4CAF50;
  color: white;
  border: none;
  padding: 12px 25px;
  border-radius: 25px;
  cursor: pointer;
  font-weight: bold;
  transition: background 0.3s;
}

.view-showtimes-btn:hover {
  background: #45a049;
}
</style>