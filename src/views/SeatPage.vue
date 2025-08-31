<template>
  <div class="seat-page">
    <h1>Select Your Seat</h1>
    <SeatForm />
  </div>
</template>

<script>
import SeatForm from '../components/SeatForm.vue'

export default {
  name: 'SeatPage',
  components: {
    SeatForm
  }
}
</script>

<style>
.seat-page {
  max-width: 600px;
  margin: 40px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background-color: #f9f9f9;
  font-family: Arial, sans-serif;
}

.seat-page h1 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
