<template>
  <div class="booking-page">
    <h1>Movie Ticket Booking</h1>
    <BookingForm />
  </div>
</template>

<script>
import BookingForm from '@/components/BookingForm.vue'

export default {
  name: 'BookingPage',
  components: {
    BookingForm
  }
}
</script>

<style>
.booking-page {
  max-width: 600px;
  margin: 40px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  background: #f9f9f9;
  font-family: Arial, sans-serif;
}

.booking-page h1 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
