<template>
  <div class="movie-slider">
    <div class="slider-container" ref="sliderContainer">
      <div 
        class="slider-track" 
        :style="{ transform: `translateX(-${currentSlide * slideWidth}%)` }"
      >
        <div 
          v-for="(movie, index) in movies" 
          :key="movie.id"
          class="slide"
          :class="{ active: index === currentSlide }"
        >
          <div class="slide-content">
            <div class="movie-backdrop">
              <img 
                :src="movie.backdrop || movie.poster" 
                :alt="movie.title"
                class="backdrop-image"
              >
              <div class="backdrop-overlay"></div>
            </div>
            
            <div class="movie-details">
              <div class="movie-info">
                <h2 class="movie-title">{{ movie.title }}</h2>
                <p class="movie-description">{{ movie.description }}</p>
                
                <div class="movie-meta">
                  <span class="rating">{{ movie.rating }}</span>
                  <span class="duration">{{ movie.duration }}</span>
                  <span class="genre">{{ movie.genre.join(', ') }}</span>
                </div>
                
                <div class="movie-actions">
                  <button 
                    @click="bookTickets(movie)" 
                    class="book-now-btn"
                  >
                    Book Now
                  </button>
                  <button 
                    @click="watchTrailer(movie)" 
                    class="trailer-btn"
                  >
                    <svg width="16" height="16" viewBox="0 0 24 24" fill="currentColor">
                      <path d="M8 5v14l11-7z"/>
                    </svg>
                    Watch Trailer
                  </button>
                </div>
              </div>
              
              <div class="movie-poster">
                <img 
                  :src="movie.poster" 
                  :alt="movie.title"
                  class="poster-image"
                >
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Navigation Controls -->
    <div class="slider-controls">
      <button 
        @click="prevSlide" 
        class="slider-btn prev-btn"
        :disabled="currentSlide === 0"
      >
        <svg width="24" height="24" viewBox="0 0 24 24" fill="currentColor">
          <path d="M15.41 7.41L14 6l-6 6 6 6 1.41-1.41L10.83 12z"/>
        </svg>
      </button>
      
      <button 
        @click="nextSlide" 
        class="slider-btn next-btn"
        :disabled="currentSlide === movies.length - 1"
      >
        <svg width="24" height="24" viewBox="0 0 24 24" fill="currentColor">
          <path d="M10 6L8.59 7.41 13.17 12l-4.58 4.59L10 18l6-6z"/>
        </svg>
      </button>
    </div>
    
    <!-- Slide Indicators -->
    <div class="slider-indicators">
      <button
        v-for="(movie, index) in movies"
        :key="`indicator-${index}`"
        @click="goToSlide(index)"
        class="indicator"
        :class="{ active: index === currentSlide }"
        :aria-label="`Go to slide ${index + 1}`"
      >
        <span class="indicator-dot"></span>
      </button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'MovieSlider',
  props: {
    movies: {
      type: Array,
      required: true,
      default: () => []
    },
    autoplay: {
      type: Boolean,
      default: true
    },
    autoplayDelay: {
      type: Number,
      default: 5000
    },
    showControls: {
      type: Boolean,
      default: true
    },
    showIndicators: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      currentSlide: 0,
      slideWidth: 100,
      autoplayInterval: null,
      isHovered: false
    }
  },
  mounted() {
    this.startAutoplay()
    this.addEventListeners()
  },
  beforeUnmount() {
    this.stopAutoplay()
    this.removeEventListeners()
  },
  methods: {
    nextSlide() {
      if (this.currentSlide < this.movies.length - 1) {
        this.currentSlide++
      } else {
        this.currentSlide = 0 // Loop back to first slide
      }
      this.resetAutoplay()
    },
    
    prevSlide() {
      if (this.currentSlide > 0) {
        this.currentSlide--
      } else {
        this.currentSlide = this.movies.length - 1 // Loop to last slide
      }
      this.resetAutoplay()
    },
    
    goToSlide(index) {
      if (index >= 0 && index < this.movies.length) {
        this.currentSlide = index
        this.resetAutoplay()
      }
    },
    
    startAutoplay() {
      if (this.autoplay && this.movies.length > 1) {
        this.autoplayInterval = setInterval(() => {
          if (!this.isHovered) {
            this.nextSlide()
          }
        }, this.autoplayDelay)
      }
    },
    
    stopAutoplay() {
      if (this.autoplayInterval) {
        clearInterval(this.autoplayInterval)
        this.autoplayInterval = null
      }
    },
    
    resetAutoplay() {
      this.stopAutoplay()
      this.startAutoplay()
    },
    
    addEventListeners() {
      const container = this.$refs.sliderContainer
      if (container) {
        container.addEventListener('mouseenter', this.handleMouseEnter)
        container.addEventListener('mouseleave', this.handleMouseLeave)
        
        // Add keyboard navigation
        container.addEventListener('keydown', this.handleKeydown)
        container.setAttribute('tabindex', '0')
      }
    },
    
    removeEventListeners() {
      const container = this.$refs.sliderContainer
      if (container) {
        container.removeEventListener('mouseenter', this.handleMouseEnter)
        container.removeEventListener('mouseleave', this.handleMouseLeave)
        container.removeEventListener('keydown', this.handleKeydown)
      }
    },
    
    handleMouseEnter() {
      this.isHovered = true
    },
    
    handleMouseLeave() {
      this.isHovered = false
    },
    
    handleKeydown(event) {
      switch (event.key) {
        case 'ArrowLeft':
          event.preventDefault()
          this.prevSlide()
          break
        case 'ArrowRight':
          event.preventDefault()
          this.nextSlide()
          break
        case 'Home':
          event.preventDefault()
          this.goToSlide(0)
          break
        case 'End':
          event.preventDefault()
          this.goToSlide(this.movies.length - 1)
          break
      }
    },
    
    bookTickets(movie) {
      this.$emit('book-tickets', movie)
      this.$router.push(`/seat-selection/${movie.id}`)
    },
    
    watchTrailer(movie) {
      this.$emit('watch-trailer', movie)
      // Open trailer in modal or new window
      console.log('Watch trailer for:', movie.title)
    }
  },
  
  watch: {
    movies: {
      handler(newMovies) {
        if (newMovies.length === 0) {
          this.currentSlide = 0
          this.stopAutoplay()
        } else if (this.currentSlide >= newMovies.length) {
          this.currentSlide = newMovies.length - 1
        }
      },
      immediate: true
    }
  }
}
</script>

<style scoped>
.movie-slider {
  position: relative;
  width: 100%;
  height: 500px;
  overflow: hidden;
  border-radius: 15px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
}

.slider-container {
  width: 100%;
  height: 100%;
  position: relative;
  outline: none;
}

.slider-track {
  display: flex;
  width: 100%;
  height: 100%;
  transition: transform 0.6s cubic-bezier(0.25, 0.46, 0.45, 0.94);
}

.slide {
  flex: 0 0 100%;
  width: 100%;
  height: 100%;
  position: relative;
}

.slide-content {
  width: 100%;
  height: 100%;
  position: relative;
  display: flex;
  align-items: center;
}

.movie-backdrop {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
}

.backdrop-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.backdrop-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    135deg, 
    rgba(0, 0, 0, 0.8) 0%, 
    rgba(0, 0, 0, 0.6) 50%, 
    rgba(0, 0, 0, 0.9) 100%
  );
}

.movie-details {
  position: relative;
  z-index: 2;
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 40px;
  gap: 40px;
}

.movie-info {
  flex: 1;
  color: white;
}

.movie-title {
  font-size: 3rem;
  font-weight: bold;
  margin-bottom: 15px;
  color: #ffffff;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
  line-height: 1.2;
}

.movie-description {
  font-size: 1.1rem;
  line-height: 1.6;
  margin-bottom: 20px;
  color: #e0e0e0;
  max-width: 600px;
}

.movie-meta {
  display: flex;
  gap: 20px;
  margin-bottom: 30px;
  flex-wrap: wrap;
}

.movie-meta span {
  background: rgba(255, 165, 0, 0.9);
  color: white;
  padding: 8px 15px;
  border-radius: 20px;
  font-size: 0.9rem;
  font-weight: bold;
}

.movie-actions {
  display: flex;
  gap: 15px;
  flex-wrap: wrap;
}

.book-now-btn, .trailer-btn {
  padding: 15px 30px;
  border: none;
  border-radius: 25px;
  font-size: 1rem;
  font-weight: bold;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  gap: 8px;
}

.book-now-btn {
  background: linear-gradient(135deg, #ff6b35, #ffa500);
  color: white;
  box-shadow: 0 4px 15px rgba(255, 107, 53, 0.4);
}

.book-now-btn:hover {
  background: linear-gradient(135deg, #e55a2b, #ff8c00);
  transform: translateY(-2px);
  box-shadow: 0 6px 20px rgba(255, 107, 53, 0.6);
}

.trailer-btn {
  background: rgba(255, 255, 255, 0.1);
  color: white;
  border: 2px solid rgba(255, 255, 255, 0.3);
  backdrop-filter: blur(10px);
}

.trailer-btn:hover {
  background: rgba(255, 255, 255, 0.2);
  border-color: rgba(255, 255, 255, 0.5);
  transform: translateY(-2px);
}

.movie-poster {
  flex-shrink: 0;
}

.poster-image {
  width: 300px;
  height: 400px;
  object-fit: cover;
  border-radius: 15px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.5);
  transition: transform 0.3s ease;
}

.poster-image:hover {
  transform: scale(1.05);
}

/* Navigation Controls */
.slider-controls {
  position: absolute;
  top: 50%;
  left: 0;
  right: 0;
  transform: translateY(-50%);
  display: flex;
  justify-content: space-between;
  padding: 0 20px;
  pointer-events: none;
  z-index: 3;
}

.slider-btn {
  pointer-events: all;
  width: 50px;
  height: 50px;
  border: none;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.2);
  color: white;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: all 0.3s ease;
  backdrop-filter: blur(10px);
}

.slider-btn:hover:not(:disabled) {
  background: rgba(255, 165, 0, 0.8);
  transform: scale(1.1);
}

.slider-btn:disabled {
  opacity: 0.3;
  cursor: not-allowed;
}

/* Slide Indicators */
.slider-indicators {
  position: absolute;
  bottom: 20px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  gap: 12px;
  z-index: 3;
}

.indicator {
  background: none;
  border: none;
  cursor: pointer;
  padding: 8px;
  transition: all 0.3s ease;
}

.indicator-dot {
  display: block;
  width: 12px;
  height: 12px;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.5);
  transition: all 0.3s ease;
}

.indicator.active .indicator-dot,
.indicator:hover .indicator-dot {
  background: #ffa500;
  transform: scale(1.2);
}

/* Responsive Design */
@media (max-width: 768px) {
  .movie-slider {
    height: 400px;
  }
  
  .movie-details {
    flex-direction: column;
    text-align: center;
    padding: 20px;
    gap: 20px;
  }
  
  .movie-title {
    font-size: 2rem;
  }
  
  .movie-description {
    font-size: 1rem;
    max-width: 100%;
  }
  
  .poster-image {
    width: 200px;
    height: 280px;
  }
  
  .movie-actions {
    justify-content: center;
  }
  
  .slider-controls {
    padding: 0 10px;
  }
  
  .slider-btn {
    width: 40px;
    height: 40px;
  }
}

@media (max-width: 480px) {
  .movie-slider {
    height: 350px;
  }
  
  .movie-title {
    font-size: 1.5rem;
  }
  
  .movie-meta {
    justify-content: center;
  }
  
  .book-now-btn, .trailer-btn {
    padding: 12px 20px;
    font-size: 0.9rem;
  }
  
  .poster-image {
    width: 150px;
    height: 220px;
  }
}

/* Animation for slide transitions */
@keyframes slideIn {
  from {
    opacity: 0;
    transform: translateX(50px);
  }
  to {
    opacity: 1;
    transform: translateX(0);
  }
}

.slide.active .movie-info > * {
  animation: slideIn 0.8s ease-out forwards;
}

.slide.active .movie-info > *:nth-child(1) { animation-delay: 0.1s; }
.slide.active .movie-info > *:nth-child(2) { animation-delay: 0.2s; }
.slide.active .movie-info > *:nth-child(3) { animation-delay: 0.3s; }
.slide.active .movie-info > *:nth-child(4) { animation-delay: 0.4s; }
</style>