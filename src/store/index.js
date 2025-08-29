import { createStore } from 'vuex'
import movies from './modules/movies'
import bookings from './modules/bookings'
import theaters from './modules/theaters'

export default createStore({
  modules: {
    movies,
    bookings,
    theaters
  }
})