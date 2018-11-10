<template>
  <div id="auth">
    <form-blank>
      <div slot='form__name'>Авторизация</div>
      <div slot='form__content'>
        <div class='input-block'>
       <label class='label-input'>
         Телефон
        <input v-model='phone' >
        </label>
        <div v-if='!$v.phone.required&&tryAuth' class='err-block'>Введите телефон</div>
        <div v-if='!$v.phone.numeric&&tryAuth' class='err-block'>Только цифры</div>
        </div>

        <div class='input-block'>
       <label class='label-input'>
         Пароль
        <input  v-model='password'>
        </label>
        <div v-if='!$v.password.required&&tryAuth&&!$v.phone.$invalid' class='err-block'>Введите пароль</div>
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
import { validationMixin } from 'vuelidate'
import { required,numeric } from 'vuelidate/lib/validators'

export default {
  name: 'auth',
  data () {
    return {
      phone: '',
      password: '',
      tryAuth: false
    }
  },
  components: {
    'form-blank':form__blank
  },
   validations: {
      phone:{
          required,
          numeric     
      },
      password: {
        required
      }
  },
  mixins: [validationMixin],
  methods : {
    auth () {
      this.tryAuth=true;
      if(!this.$v.$invalid) {
      let user = {
        phoneNumber: this.phone,
        password: this.password
      }
     this.$store.dispatch(AUTH_REQUEST, user).then(() => {
     this.$router.push('/Account')
   })
    }
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
.error {
  border-bottom:solid 2px red;
}
.err-block {
  font:  500 18px Arial;
  position: absolute;
  height: 50px;
  width: 240px;
  top:-5px;
  right: -240px;
  text-align: center;
  line-height: 50px;
  background-image: url(../images/tip-icon.png);
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
  color:red;

}
</style>