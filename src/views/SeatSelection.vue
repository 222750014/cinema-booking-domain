<template>
  <div class="seat-selection-page">
    <SeatLayout :movieId="movieId" />
  </div>
</template>

<script>
import SeatLayout from '../components/SeatLayout.vue'

export default {
  name: 'SeatSelection',
  components: {
    SeatLayout
  },
  props: {
    movieId: {
      type: String,
      required: true
    }
  }
}
</script>

<style scoped>
.seat-selection-page {
  background: #1a1a1a;
  min-height: 100vh;
}
</style>