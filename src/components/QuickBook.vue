<template>
  <div class="quick-book">
    <h3>Quick Book</h3>
    <div class="booking-form">
      <div class="form-group">
        <div class="radio-group">
          <label>
            <input type="radio" value="movies" v-model="bookingType"> Movies
          </label>
          <label>
            <input type="radio" value="theaters" v-model="bookingType"> Theaters
          </label>
        </div>
      </div>
      
      <div class="form-group">
        <select v-model="selectedCity" class="form-select">
          <option value="">Select City</option>
          <option value="visakhapatnam">Visakhapatnam</option>
          <option value="hyderabad">Hyderabad</option>
          <option value="chennai">Chennai</option>
        </select>
      </div>
      
      <div class="form-group">
        <select v-model="selectedMovie" class="form-select">
          <option value="">Select Movie</option>
          <option v-for="movie in movies" :key="movie.id" :value="movie.id">
            {{ movie.title }}
          </option>
        </select>
      </div>
      
      <div class="form-group">
        <input type="date" v-model="selectedDate" class="form-select">
      </div>
      
      <button @click="bookNow" class="book-btn">Book Now</button>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'

export default {
  name: 'QuickBook',
  data() {
    return {
      bookingType: 'movies',
      selectedCity: '',
      selectedMovie: '',
      selectedDate: ''
    }
  },
  computed: {
    ...mapState('movies', ['movies'])
  },
  methods: {
    bookNow() {
      if (this.selectedMovie && this.selectedDate) {
        this.$router.push(`/seat-selection/${this.selectedMovie}`)
      }
    }
  },
  mounted() {
    this.$store.dispatch('movies/fetchMovies')
  }
}
</script>

<style scoped>
.quick-book {
  background: #ff6b35;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
  color: white;
}

.quick-book h3 {
  margin: 0 0 20px 0;
  background: #e55a2b;
  padding: 10px;
  border-radius: 5px;
  text-align: center;
}

.form-group {
  margin-bottom: 15px;
}

.radio-group {
  display: flex;
  gap: 20px;
}

.radio-group label {
  display: flex;
  align-items: center;
  gap: 5px;
  cursor: pointer;
}

.form-select {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 5px;
  outline: none;
}

.book-btn {
  background: #ffa500;
  color: white;
  border: none;
  padding: 12px 30px;
  border-radius: 20px;
  cursor: pointer;
  font-weight: bold;
  width: 100%;
  margin-top: 10px;
}

.book-btn:hover {
  background: #ff8c00;
}
</style>