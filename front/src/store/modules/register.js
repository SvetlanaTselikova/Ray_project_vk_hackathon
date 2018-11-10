import axios from 'axios'

const state = {
}

const mutations = {
    newUser (name) {
    }
}

const actions = {
    register ({commit},user) {
        var data=JSON.stringify (user
        )
        axios.post('http://172.20.38.37:8080/users/register', data, {
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() =>{
            commit('newUser',user.name)
            
            })
    }
      }

    

const getters = {
    
}

export default {
    state,
    mutations,
    actions,
    getters
}