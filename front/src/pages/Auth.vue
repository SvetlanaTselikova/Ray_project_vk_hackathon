<template>
  <div id="Register">
    <form-blank>
      <div slot='form__name'>Авторизация</div>
      <div slot='form__content'>
        <div class='input-block'>
       <label class='label-input'>
         Телефон
        <input v-model='phone' >
        </label>
        </div>

        <div class='input-block'>
       <label class='label-input'>
         Пароль
        <input  v-model='password'>
        </label>
        </div>
 
        <button class='button-reg' @click='auth' >  Войти 
        </button> 
        <router-link to='/Register'><div class='reg'>Регистрация</div> </router-link>            
      </div>
    </form-blank>
  </div>
</template>

<script>
import form__blank from '../components/Form.vue'
import {AUTH_REQUEST} from '..//store/actions/auth'
export default {
  name: 'register',
  data () {
    return {
      phone: '',
      password: '' 
    }
  },
  components: {
    'form-blank':form__blank
  },
  methods : {
    auth () {
      let user = {
        phone: this.phone,
        password: this.password
      }
     this.$store.dispatch(AUTH_REQUEST, user).then(() => {
     this.$router.push('/Account')
   })
    }
  }
}
</script>

<style lang="scss">
.reg {
  font: 500 17px Arial;
  color: rgb(122, 118, 118);
  text-decoration: underline;
  margin-bottom: 20px;
}
</style>