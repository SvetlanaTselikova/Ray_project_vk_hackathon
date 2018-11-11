import axios from 'axios'
import { AUTH_REQUEST, AUTH_ERROR, AUTH_SUCCESS, AUTH_LOGOUT } from '../actions/auth'
import { USER_REQUEST } from '../actions/user'

const state = {
    token: localStorage.getItem('user-token') || '',
    status: ''
}

const mutations = {
    [AUTH_REQUEST]: (state) => {
        state.status = 'loading'
      },
    [AUTH_SUCCESS]: (state, token) => {
        state.status = 'success'
        state.token = token
    },
    [AUTH_ERROR]: (state) => {
        state.status = 'error'
    },
    [AUTH_LOGOUT]: (state) => {
        state.token = ''
      }
}

const actions = {
    [AUTH_REQUEST]: ({commit, dispatch}, user)=>  {
        return new Promise((resolve, reject) => { 
          commit(AUTH_REQUEST)
          let data=JSON.stringify(user)
          axios.post('http://172.20.38.37:8080/users/auth',data, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(resp => {
              const token = resp.data
              localStorage.setItem('user-token', token)
              axios.defaults.headers.common['Authorization'] = token
              commit(AUTH_SUCCESS, token)
              console.log(token)
              //dispatch(USER_REQUEST)
              resolve(resp)
            })
          .catch(err => {
              
            commit(AUTH_ERROR, err)
            localStorage.removeItem('user-token') 
            reject(err)
          })
        })
      },

      [AUTH_LOGOUT]: ({commit, dispatch}, user) => {
        return new Promise((resolve, reject) => {
            commit(AUTH_LOGOUT)
            localStorage.removeItem('user-token')
            delete axios.defaults.headers.common['Authorization']
            resolve()
          })
        }
      }

    

const getters = {
    isAuthenticated: state => !!state.token,
    authStatus: state => state.status
}

export default {
    state,
    mutations,
    actions,
    getters
}