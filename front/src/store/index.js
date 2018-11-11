import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user.js'
import auth from './modules/auth.js'
import register from './modules/register'
import pets from './modules/pets'
import tasks from './modules/tasks'
import tamagochi from './modules/tamagochi'

Vue.use(Vuex)

const store = new Vuex.Store ({
    modules: {
        user,
        auth,
        register,
        tasks,
        pets,
        tamagochi
    }
})
export default store