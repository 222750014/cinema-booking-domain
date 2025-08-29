import axios from 'axios'

// Axios instance
const api = axios.create({
  baseURL: process.env.VUE_APP_API_URL || 'http://localhost:3000/api',
  timeout: 10000,
  headers: { 'Content-Type': 'application/json' }
})

// Interceptors
api.interceptors.request.use(config => {
  const token = localStorage.getItem('authToken')
  if (token) config.headers.Authorization = `Bearer ${token}`
  console.log('API Request:', config.method.toUpperCase(), config.url)
  return config
}, error => Promise.reject(error))

api.interceptors.response.use(
  res => {
    console.log('API Response:', res.status, res.config.url)
    return res
  },
  error => {
    if (error.response?.status === 401) {
      localStorage.removeItem('authToken')
      window.location.href = '/login'
    }
    return Promise.reject(error)
  }
)

// --- APIs ---
export const movieAPI = {
  getMovies: (params = {}) => api.get('/movies', { params }),
  getMovie: (id) => api.get(`/movies/${id}`),
  getMoviesByTheater: (theaterId) => api.get(`/movies/theater/${theaterId}`),
  searchMovies: (query) => api.get('/movies/search', { params: { q: query } }),
  getShowtimes: (movieId, date) => api.get(`/movies/${movieId}/showtimes`, { params: { date } })
}

export const theaterAPI = {
  getTheaters: (city) => api.get('/theaters', { params: { city } }),
  getTheater: (id) => api.get(`/theaters/${id}`),
  getSeats: (theaterId, showtimeId) => api.get(`/theaters/${theaterId}/seats`, { params: { showtime: showtimeId } })
}

export const bookingAPI = {
  createBooking: (data) => api.post('/bookings', data),
  getUserBookings: (userId) => api.get(`/bookings/user/${userId}`),
  getBooking: (id) => api.get(`/bookings/${id}`),
  cancelBooking: (id) => api.delete(`/bookings/${id}`),
  confirmPayment: (id, data) => api.post(`/bookings/${id}/payment`, data)
}

export const userAPI = {
  login: (credentials) => api.post('/auth/login', credentials),
  register: (userData) => api.post('/auth/register', userData),
  getProfile: () => api.get('/auth/profile'),
  updateProfile: (data) => api.put('/auth/profile', data),
  logout: () => api.post('/auth/logout')
}

// Helpers
export const handleApiError = (error) => {
  const message = error.response?.data?.message || error.message || 'An error occurred'
  console.error('API Error:', message)
  return { success: false, message, status: error.response?.status }
}

export const formatApiResponse = (response) => ({
  success: true,
  data: response.data,
  status: response.status
})

// Mock data (fallback)
export const mockData = {
  movies: [
    { id: 1, title: 'Finding Nemo 3D', status: 'showing', language: 'english', poster: '/api/placeholder/200/300' },
    { id: 2, title: 'Rebel', status: 'showing', language: 'telugu', poster: '/api/placeholder/200/300' },
    { id: 3, title: 'Street Dance 3D', status: 'showing', language: 'english', poster: '/api/placeholder/200/300' },
    { id: 4, title: 'Avatar: The Way of Water', status: 'coming', language: 'english', poster: '/api/placeholder/200/300' }
  ]
}

export const useMockData =
  process.env.NODE_ENV === 'development' && !process.env.VUE_APP_API_URL

export default api
