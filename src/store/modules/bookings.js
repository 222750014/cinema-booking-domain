export default {
  namespaced: true,
  state: {
    bookings: []
  },
  mutations: {
    ADD_BOOKING(state, booking) {
      state.bookings.push({
        ...booking,
        id: Date.now().toString(),
        bookingDate: new Date()
      })
    }
  },
  actions: {
    createBooking({ commit }, booking) {
      commit('ADD_BOOKING', booking)
    }
  }
}

