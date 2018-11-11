import axios from 'axios'

const state = {
  pets:[]
}

const mutations = {
    listOfPets (state,pets) {
      state.pets=pets;
    }
}

const actions = {
    listOfPets ({commit},pet) {
      commit('listOfPets',[{name:'pupa',description:'dfd',sex:'w',id:'1',age:'2 года',level:'80'}])
      /*
        
       
        axios.get('http://172.20.38.37:8080/pets/all', {
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            }
        }).then((response) =>{
         
            commit('listOfPets',response.data)
            })*/
    }
      }

    

const getters = {
  getPets: state => state.pets,
  getPetById: state => id => {
    return state.pets.find(pet => pet.id === id);
  }
}

export default {
    state,
    mutations,
    actions,
    getters
}