export default {
  namespaced: true,
  state: {
    theaters: [
      {
        id: 1,
        name: 'IMAX',
        location: 'Visakhapatnam',
        facilities: ['3D', 'Dolby Atmos', 'Recliner Seats']
      },
      {
        id: 2,
        name: 'PVR Cinemas',
        location: 'Hyderabad',
        facilities: ['3D', '4DX', 'IMAX']
      }
    ]
  },
  mutations: {
    SET_THEATERS(state, theaters) {
      state.theaters = theaters
    }
  },
  actions: {
    fetchTheaters({ commit }) {
      commit('SET_THEATERS', state.theaters)
    }
  }
}