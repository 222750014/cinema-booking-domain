import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import SeatSelection from '../views/SeatSelection.vue'
import Movies from '../views/Movies.vue'
import Cinemas from '../views/Cinemas.vue'
import Tickets from '../views/Tickets.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/movies',
    name: 'Movies',
    component: Movies
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
  {
    path: '/seat-selection/:movieId',
    name: 'SeatSelection',
    component: SeatSelection,
    props: true
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router