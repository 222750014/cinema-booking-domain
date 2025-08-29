<template>
  <div class="movie-card">
    <div class="movie-poster">
      <img :src="movie.poster" :alt="movie.title" />
      <div class="movie-overlay">
        <div class="movie-rating">{{ movie.rating }}</div>
      </div>
    </div>
    <div class="movie-info">
      <h4>{{ movie.title }}</h4>
      <p class="movie-certificate">{{ movie.certificate }}</p>
      <button @click="buyTickets" class="buy-tickets-btn">Buy Tickets</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MovieCard',
  props: {
    movie: {
      type: Object,
      required: true
    }
  },
  methods: {
    buyTickets() {
      this.$router.push(`/seat-selection/${this.movie.id}`)
    }
  }
}
</script>

<style scoped>
.movie-card {
  background: white;
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 4px 8px rgba(0,0,0,0.1);
  transition: transform 0.3s ease;
}

.movie-card:hover {
  transform: translateY(-5px);
}

.movie-poster {
  position: relative;
  height: 300px;
  overflow: hidden;
}

.movie-poster img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.movie-overlay {
  position: absolute;
  top: 10px;
  right: 10px;
}

.movie-rating {
  background: rgba(0,0,0,0.7);
  color: white;
  padding: 5px 10px;
  border-radius: 15px;
  font-size: 0.8em;
}

.movie-info {
  padding: 15px;
  text-align: center;
}

.movie-info h4 {
  margin: 0 0 10px 0;
  font-size: 1.1em;
}

.movie-certificate {
  color: #666;
  font-size: 0.9em;
  margin: 0 0 15px 0;
}

.buy-tickets-btn {
  background: #333;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  font-weight: bold;
  width: 100%;
}

.buy-tickets-btn:hover {
  background: #555;
}
</style>