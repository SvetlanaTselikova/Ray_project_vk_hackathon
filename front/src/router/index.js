import Vue from 'vue'
import Router from 'vue-router'
import store from '../store'
import Home from '../pages/Home.vue'
import Account from '../pages/Account.vue'
import Register from '../pages/Register.vue'
import Auth from '../pages/Auth.vue'
import PetPage from '../pages/PetPage.vue'

Vue.use(Router);

const ifNotAuthenticated = (to, from, next) => {
  if (!store.getters.isAuthenticated) {
    next()
    return
  }
  next('/')
}

const ifAuthenticated = (to, from, next) => {
  if (store.getters.isAuthenticated) {
    next()
    return
  }
  next('/Auth')
}

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
      },
    {
      path: '/Register',
      name: 'register',
      component: Register,
      beforeEnter: ifNotAuthenticated
    },
    {
      path: '/Auth',
      name: 'auth',
      component: Auth,
      beforeEnter: ifNotAuthenticated
    },
    {
    path: '/Account',
    name: 'Account',
    component: Account,
    beforeEnter: ifAuthenticated,
  },  
  {
    path: '/PetPage',
    name: 'PetPage',
    component: PetPage
  }, 
  ]
});

export default router;