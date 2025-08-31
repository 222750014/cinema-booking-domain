<template>
  <div class="home">
    <div class="main-content">
      <div class="content-area">
        <QuickBook />
        
        <div class="hero-slider">
          <div class="slider-container">
            <img src="https://via.placeholder.com/600x300/333/fff?text=Featured+Movies" alt="Hero Image" class="hero-image">
            <div class="slider-dots">
              <span class="dot active"></span>
              <span class="dot"></span>
              <span class="dot"></span>
              <span class="dot"></span>
              <span class="dot"></span>
            </div>
          </div>
        </div>
       Now Showing
           <button 
              :class="{ active: activeTab === 'coming' }"
              @click="activeTab = 'coming'"
              class="tab-btn"
            >
              Coming Soon
            </button>
            <button 
              :class="{ active: activeTab === 'trailers' }"
              @click="activeTab = 'trailers'"
              class="tab-btn"
            >
              Trailers
            </button>
          </div>
          
          <div class="movies-grid">
            <MovieCard 
              v-for="movie in filteredMovies" 
              :key="movie.id" 
              :movie="movie"
            />
          </div>
        </div>
        
        <div class="sidebar">
          <div class="ad-section">
            <div class="ad-banner airfrance">
              <h3>AIRFRANCE</h3>
              <p>To discover all our offers</p>
              <button class="ad-btn">CLICK HERE</button>
            </div>
            
            <div class="ad-banner replay">
              <h3>REPLAY</h3>
              <div class="tintin-ad">
                <img src="https://via.placeholder.com/200x150/4a90e2/fff?text=TINTIN" alt="Tintin" class="tintin-image">
              </div>
            </div>
          </div>
        </div>
      </div>
</template>

<script>
import { mapState } from 'vuex'
import QuickBook from '../components/QuickBook.vue'
import MovieCard from '../components/MovieCard.vue'

export default {
  name: 'Home',
  components: {
    QuickBook,
    MovieCard
  },
  data() {
    return {
      activeTab: 'showing'
    }
  },
  computed: {
    ...mapState('movies', ['movies']),
    filteredMovies() {
      return this.movies.filter(movie => {
        if (this.activeTab === 'showing') return movie.status === 'showing'
        if (this.activeTab === 'coming') return movie.status === 'coming'
        return movie.status === 'showing'
      })
    }
  },
  mounted() {
    this.$store.dispatch('movies/fetchMovies')
  }
}
</script>

<style scoped>
.home {
  background: #1a1a1a;
  min-height: 100vh;
  color: white;
}

.main-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.content-area {
  display: grid;
  grid-template-columns: 300px 1fr 250px;
  gap: 20px;
  align-items: start;
}

.hero-slider {
  grid-column: 2;
}

.slider-container {
  position: relative;
  border-radius: 10px;
  overflow: hidden;
}

.hero-image {
  width: 100%;
  height: 300px;
  object-fit: cover;
}

.slider-dots {
  position: absolute;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  gap: 10px;
}

.dot {
  width: 12px;
  height: 12px;
  border-radius: 50%;
  background: rgba(255,255,255,0.5);
  cursor: pointer;
  transition: background 0.3s;
}

.dot.active {
  background: white;
}

.movies-section {
  grid-column: 1 / -1;
  margin-top: 30px;
}

.section-tabs {
  display: flex;
  gap: 0;
  margin-bottom: 20px;
  border-radius: 10px;
  overflow: hidden;
}

.tab-btn {
  background: #ffa500;
  color: white;
  border: none;
  padding: 15px 30px;
  cursor: pointer;
  flex: 1;
  font-weight: bold;
  transition: background 0.3s;
}

.tab-btn.active {
  background: #ff8c00;
}

.tab-btn:hover {
  background: #ff8c00;
}

.movies-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  gap: 20px;
}

.sidebar {
  grid-column: 3;
}

.ad-section {
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.ad-banner {
  padding: 20px;
  border-radius: 10px;
  text-align: center;
}

.airfrance {
  background: linear-gradient(135deg, #4a90e2, #7bb3f7);
}

.airfrance h3 {
  margin: 0 0 10px 0;
  font-size: 1.5em;
}

.ad-btn {
  background: #ff4444;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  font-weight: bold;
  margin-top: 10px;
}

.replay {
  background: #e6f3ff;
  color: #333;
}

.tintin-image {
  width: 100%;
  border-radius: 5px;
  margin-top: 10px;
}

@media (max-width: 768px) {
  .content-area {
    grid-template-columns: 1fr;
    gap: 20px;
  }
  
  .hero-slider {
    grid-column: 1;
  }
  
  .movies-section {
    grid-column: 1;
  }
  
  .sidebar {
    grid-column: 1;
  }
}
</style>