export default {
  namespaced: true,
  state: {
    movies: [
      {
        id: 1,
        title: 'Finding Nemo 3D',
        poster: 'https://via.placeholder.com/200x300/0066cc/fff?text=Finding+Nemo+3D',
        backdrop: 'https://via.placeholder.com/600x300/0066cc/fff?text=Finding+Nemo+3D',
        rating: 'U',
        certificate: 'Movie Certificate',
        genre: ['animation', 'family'],
        language: 'english',
        status: 'showing',
        theater: 'IMAX',
        showtimes: ['10:00 AM', '1:00 PM', '4:00 PM', '7:00 PM'],
        price: 100,
        duration: '100 mins',
        description: 'A clown fish named Marlin lives in the Great Barrier Reef and loses his son, Nemo, after he ventures into the open sea, despite his father\'s constant warnings about many of the ocean\'s dangers.'
      },
      {
        id: 2,
        title: 'Rebel',
        poster: 'https://via.placeholder.com/200x300/cc3300/fff?text=Rebel',
        backdrop: 'https://via.placeholder.com/600x300/cc3300/fff?text=Rebel',
        rating: 'A',
        certificate: 'Movie Certificate',
        genre: ['action', 'thriller'],
        language: 'telugu',
        status: 'showing',
        theater: 'PVR',
        showtimes: ['11:00 AM', '2:00 PM', '5:00 PM', '8:00 PM'],
        price: 120,
        duration: '150 mins',
        description: 'An action-packed thriller about a young rebel fighting against corruption in society.'
      },
      {
        id: 3,
        title: 'Street Dance 3D',
        poster: 'https://via.placeholder.com/200x300/ff6600/fff?text=Street+Dance+3D',
        backdrop: 'https://via.placeholder.com/600x300/ff6600/fff?text=Street+Dance+3D',
        rating: 'U',
        certificate: 'Movie Certificate',
        genre: ['drama', 'dance'],
        language: 'english',
        status: 'showing',
        theater: 'Inox',
        showtimes: ['12:00 PM', '3:00 PM', '6:00 PM', '9:00 PM'],
        price: 150,
        duration: '98 mins',
        description: 'A street dance crew prepares for the biggest battle of their lives in this high-energy 3D experience.'
      },
      {
        id: 4,
        title: 'Avatar: The Way of Water',
        poster: 'https://via.placeholder.com/200x300/006699/fff?text=Avatar+2',
        backdrop: 'https://via.placeholder.com/600x300/006699/fff?text=Avatar+2',
        rating: 'PG-13',
        certificate: 'Movie Certificate',
        genre: ['action', 'adventure', 'sci-fi'],
        language: 'english',
        status: 'coming',
        theater: 'IMAX',
        showtimes: ['10:00 AM', '2:00 PM', '6:00 PM', '10:00 PM'],
        price: 200,
        duration: '192 mins',
        description: 'Jake Sully lives with his newfound family formed on the planet of Pandora.'
      }
    ]
  },
  mutations: {
    SET_MOVIES(state, movies) {
      state.movies = movies
    }
  },
  actions: {
    fetchMovies({ commit }) {
      // Simulate API call
      commit('SET_MOVIES', state.movies)
    }
  },
  getters: {
    getMovieById: (state) => (id) => {
      return state.movies.find(movie => movie.id === parseInt(id))
    }
  }
}