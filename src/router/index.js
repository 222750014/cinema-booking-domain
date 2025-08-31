import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import MoviesPage from '../views/MoviesPage.vue'
import Cinemas from '../views/Cinemas.vue'
import Tickets from '../views/Tickets.vue'
import BookingPage from "@/views/BookingPage.vue";
import SeatPage from "@/views/SeatPage.vue";

const routes = [
  {
    path: '/seat',
    name: 'seat',
    component: SeatPage
  },
  {
    path: 'booking',
    name: 'Booking',
    component: BookingPage
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/movies',
    name: 'Movies',
    component: MoviesPage
  },
  {
    path: '/cinemas',
    name: 'Cinemas',
    component: Cinemas
  },
  {
    path: '/tickets',
    name: 'Tickets',
    component: Tickets
  },

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router