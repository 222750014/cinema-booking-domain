<template>
  <div class="movies-page">
    <div class="container">
      <h1>Movies</h1>
      
      <div class="filters">
        <select v-model="selectedGenre" class="filter-select">
          <option value="">All Genres</option>
          <option value="action">Action</option>
          <option value="comedy">Comedy</option>
          <option value="drama">Drama</option>
          <option value="animation">Animation</option>
        </select>
        
        <select v-model="selectedLanguage" class="filter-select">
          <option value="">All Languages</option>
          <option value="english">English</option>
          <option value="hindi">Hindi</option>
          <option value="telugu">Telugu</option>
        </select>
      </div>
      
      <div class="movies-grid">
        <MovieCard 
          v-for="movie in filteredMovies" 
          :key="movie.id" 
          :movie="movie"
        />
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import MovieCard from '../components/MovieCard.vue'

export default {
  name: 'Movies',
  components: {
    MovieCard
  },
  data() {
    return {
      selectedGenre: '',
      selectedLanguage: ''
    }
  },
  computed: {
    ...mapState('movies', ['movies']),
    filteredMovies() {
      return this.movies.filter(movie => {
        const genreMatch = !this.selectedGenre || movie.genre.includes(this.selectedGenre)
        const languageMatch = !this.selectedLanguage || movie.language === this.selectedLanguage
        return genreMatch && languageMatch
      })
    }
  },
  mounted() {
    this.$store.dispatch('movies/fetchMovies')
  }
}
</script>

<style scoped>
.movies-page {
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

.filters {
  display: flex;
  gap: 20px;
  margin-bottom: 30px;
  justify-content: center;
}

.filter-select {
  padding: 10px;
  border: none;
  border-radius: 5px;
  outline: none;
  background: white;
}

.movies-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  gap: 30px;
}
</style>