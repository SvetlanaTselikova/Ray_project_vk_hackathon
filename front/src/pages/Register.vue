<template>
  <div id="Register">
    <form-blank>
      <div slot='form__name'>Регистрация</div>
      <div slot='form__content'>
        <div class='input-block'>
        <label class='label-input'>
          Имя
        <input  v-model='name'>
        </label>
        </div>


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

        <div class='input-block'>
       <label class='label-input'>
         Повторите пароль
        <input  v-model='passConfirm'>
        </label>
        </div>  
        <button class='button-reg' @click='register' > Зарегистрироваться  
        </button> 
        <router-link to='/Auth'><div class='enter'>Войти</div> </router-link>            
      </div>
    </form-blank>
  </div>
</template>

<script>
import form__blank from '../components/Form.vue'
export default {
  name: 'register',
  data () {
    return {
      name: '',
      phone: '',
      password: '',
      passConfirm: ''    
    }
  },
  components: {
    'form-blank':form__blank
  },
  methods : {
    register () {
      let user = {
        name: this.name,
        phone: this.phone,
        password: this.password
      }
     this.$store.dispatch('register',user)
    }
  }
}
</script>

<style lang="scss">
.enter {
  font: 500 17px Arial;
  color: rgb(122, 118, 118);
  text-decoration: underline;
  margin-bottom: 20px;
}
</style>
