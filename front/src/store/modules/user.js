import { USER_REQUEST, USER_ERROR, USER_SUCCESS } from '../actions/user'
import axios from 'axios'
import Vue from 'vue'
import { AUTH_LOGOUT } from '../actions/auth'

const state = {
   status: '',
   profile: {} }

const getters = {
  getProfile: state => state.profile,
  isProfileLoaded: state => !!state.profile.name,
}

const mutations = {
  [USER_REQUEST]: (state) => {
    state.status = 'loading'
  },
  [USER_SUCCESS]: (state, resp) => {
    state.status = 'success'
    Vue.set(state, 'profile', resp)
    console.log(state.profile)
  },
  [USER_ERROR]: (state) => {
    state.status = 'error'
  },
  [AUTH_LOGOUT]: (state) => {
    state.profile = {}
  }
}
const actions = {
  [USER_REQUEST]: ({commit, dispatch}) => {
    commit(USER_REQUEST)
    axios.get('http://localhost:3000/api/users/me',  {
      headers: {
          'Content-Type': 'application/json'
      }
  }).then(resp => {
        console.log('dfs')
        commit(USER_SUCCESS, resp.data)
      })
      .catch(resp => {
        commit(USER_ERROR)
        dispatch(AUTH_LOGOUT)
      })
  },
}



export default {
  state,
  getters,
  actions,
  mutations,
}