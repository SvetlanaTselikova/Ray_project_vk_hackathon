import Vue from 'vue'
import Router from 'vue-router'
import store from '../store'
import Home from '../pages/Home.vue'
import Account from '../pages/Account.vue'
import Register from '../pages/Register.vue'
import Auth from '../pages/Auth.vue'
import PetPage from '../pages/PetPage.vue'
import PetsList from '../pages/PetsList.vue'
import Tamagochi from '../pages/Tamagochi.vue'
import TasksList from '../pages/TasksList.vue'


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
      
    },
    {
      path: '/Auth',
      name: 'auth',
      component: Auth,
      
    },
    {
    path: '/Account',
    name: 'Account',
    component: Account
  },  
  {
    path: '/PetPage/:id',
    name: 'PetPage',
    component: PetPage
  }, 
  {
    path: '/PetsList',
    name: 'PetsList',
    component: PetsList
  }, 
  {
    path: '/Tamagochi',
    name: 'Tamagochi',
    component: Tamagochi
  }, 
  {
    path: '/TasksList',
    name: 'TasksList',
    component: TasksList
  },  
   
  ]
});

export default router;