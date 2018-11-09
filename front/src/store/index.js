import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user.js'
import auth from './modules/auth.js'
import register from './modules/register'

Vue.use(Vuex)

const store = new Vuex.Store ({
    modules: {
        user,
        auth,
        register
    }
})
export default store