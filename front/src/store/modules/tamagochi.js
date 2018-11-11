import axios from 'axios'

const state = {
  pet: {},
  health: [{id:'1', title:'dsd'},{id:'1', title:'dsd'}]
}

const mutations = {
  myPet (state,pet) {
    state.pet=pet;
  },
  healthTypes(state,types){
      state.health=types
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
  }   ,
  health({commit},act) {
    let data=JSON.stringify (act)
    axios.post('http://172.20.38.37:8080/game/health',data, {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json'
        }
    }).then((response) =>{
      
        commit('myPet',response.data)
        })
}   ,
toy({commit},act) {
    let data=JSON.stringify (act)
    axios.post('http://172.20.38.37:8080/game/toy',data, {
        headers: {
            'Access-Control-Allow-Origin': '*',
            'Content-Type': 'application/json'
        }
    }).then((response) =>{
      
        commit('myPet',response.data)
        })
}   ,

      }

    

const getters = {
  getpet: state => state.pet
}

export default {
    state,
    mutations,
    actions,
    getters
}