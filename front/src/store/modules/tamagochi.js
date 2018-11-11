import axios from 'axios'

const state = {
  pet: {}
}

const mutations = {
  myPet (state,pet) {
    state.pet=pet;
  }
}

const actions = {
    myPet({commit}) {
      axios.get('http://172.20.38.37:8080/pets/profiles/1',{
          headers: {
              'Access-Control-Allow-Origin': '*',
              'Content-Type': 'application/json'
          }
      }).then((response) =>{
          commit('myPet',response.data)
          })
  },
    feet({commit},act) {
        let data=JSON.stringify (act)
        axios.post('http://172.20.38.37:8080/game/feet',data, {
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            }
        }).then((response) =>{
          
            commit('myPet',response.data)
            })
    },
    gigi({commit},act) {
      let data=JSON.stringify (act)
      axios.post('http://172.20.38.37:8080/game/filler',data, {
          headers: {
              'Access-Control-Allow-Origin': '*',
              'Content-Type': 'application/json'
          }
      }).then((response) =>{
        
          commit('myPet',response.data)
          })
  }    
      }

    

const getters = {
  getpet: state => state.pet,
}

export default {
    state,
    mutations,
    actions,
    getters
}