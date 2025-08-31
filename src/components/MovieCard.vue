<template>
  <div class="movie-card">

    <img :src="movie.image" alt="Movie Poster" />
    <h3>{{ movie.title }}</h3>
    <p>{{ movie.description }}</p>
    <button @click="bookMovie">Book</button>
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
    bookMovie() {
      // Placeholder for booking logic
      alert(`Booked: ${this.movie.title}`);
    }
  }
}
</script>

<style scoped>
.movie-card {

  border: 1px solid #ccc;
  padding: 16px;
  border-radius: 8px;
  text-align: center;
}
.movie-card img {
  width: 100%;
  height: auto;
  border-radius: 4px;
}
button {
  margin-top: 12px;
  padding: 8px 16px;
  background-color: #1976d2;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
button:hover {
  background-color: #1565c0;
}
</style>
