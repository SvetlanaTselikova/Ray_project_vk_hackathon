import axios from 'axios'

const state = {
  tasks:[]
}

const mutations = {
    listOftasks (state,tasks) {
      state.tasks=tasks;
    }
}

const actions = {
    listOftasks ({commit},task) {
    
     
        axios.get('http://172.20.38.37:8080/tasks/all', {
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            }
        }).then((response) =>{
          
            commit('listOftasks',response.data)
            })
    }
      }

    

const getters = {
  gettasks: state => state.tasks,
  gettaskById: state => id => {
    return state.tasks.find(task => task.id === id);
  }
}

export default {
    state,
    mutations,
    actions,
    getters
}