<template>
  <div id="Register">
    <form-blank>
      <div slot='form__name'><div v-if='!success'>Регистрация</div></div>
      <div slot='form__content'>
        <div v-if='!success'>
        <div class='input-block'>
        <label class='label-input'>
          Имя
        <input v-bind:class="{'error':($v.name.$invalid&&tryReg)}" v-model='name'>
        </label>
        <div v-if='!$v.name.required&&tryReg' class='err-block'>Введите имя</div>
        </div>
        <div class='input-block'>
        <label class='label-input'>
          Фамилия
        <input v-bind:class="{'error':$v.surname.$invalid&&tryReg}" v-model='surname'>
        </label>
        <div v-if='!$v.surname.required&&tryReg&&!$v.name.$invalid' class='err-block'>Введите фамилию</div>
        
        </div>
        <div class='input-block'>
        <label class='label-input'>
          Город
        <input v-bind:class="{'error':$v.city.$invalid&&tryReg}" v-model='city'>
        </label>
        <div v-if='!$v.city.required&&tryReg&&!$v.name.$invalid&&!$v.surname.$invalid' class='err-block'>Введите город</div>
        </div>
        <div class='input-block'>
       <label class='label-input'>
         Телефон
        <input v-bind:class="{'error':$v.phone.$invalid&&tryReg}" v-model='phone' >
        </label>
         <div v-if='!$v.phone.required&&tryReg&&!$v.name.$invalid&&!$v.surname.$invalid&&!$v.city.$invalid' class='err-block'>Введите телефон</div>
        <div v-if='!$v.phone.numeric&&tryReg&&!$v.name.$invalid&&!$v.surname.$invalid&&!$v.city.$invalid' class='err-block'>Только буквы</div>
      
        </div>

        <div class='input-block'>
       <label class='label-input'>
         Пароль
        <input v-bind:class="{'error':$v.password.$invalid&&tryReg}" v-model='password'>
        </label>
          <div v-if='!$v.password.required&&tryReg&&!$v.name.$invalid&&!$v.surname.$invalid&&!$v.city.$invalid&&!$v.phone.$invalid' class='err-block'>Введите пароль</div>
        </div>

        <div class='input-block'>
       <label class='label-input'>
         Повторите пароль
        <input v-bind:class="{'error':$v.passConfirm.$invalid&&tryReg}" v-model='passConfirm'>
        </label>
        <div v-if='!$v.passConfirm.required&&tryReg&&!$v.name.$invalid&&!$v.surname.$invalid&&!$v.city.$invalid&&!$v.phone.$invalid&&!$v.password.$invalid' class='err-block'>Повторите пароль</div>
        <div v-if='!$v.passConfirm.sameAsPass&&tryReg&&!$v.name.$invalid&&!$v.surname.$invalid&&!$v.city.$invalid&&!$v.phone.$invalid&&!$v.password.$invalid' class='err-block'>Пароли не совпадают</div>
        </div>  
        <button class='button-reg' @click='register' > Зарегистрироваться  
        </button> 
        <router-link to='/Auth'><div class='enter'>Войти</div> </router-link>            
      </div>
      <div v-if='success' ><div class='success'>Вы успешно зарегиcтрированы!</div>
         <router-link to='/Auth'><div class='enter'>Войти</div> </router-link>    
      </div>
      </div>
      
    </form-blank>
  </div>
</template>

<script>
import form__blank from '../components/Form.vue'
import { validationMixin } from 'vuelidate'
import { required,alpha,numeric, sameAs } from 'vuelidate/lib/validators'

export default {
  name: 'register',
  data () {
    return {
      name: '',
      surname:'',
      city:'',
      phone: '',
      password: '',
      passConfirm: '' ,
      tryReg: false,
      success: true 
    }
  },
  created: function () {
  this.success=false;
  },
  components: {
    'form-blank':form__blank
  },
    validations: {
      name: {
        required
      },
      surname:{
          required
      },
      city:{
          required
      },
      phone:{
          required,
          numeric
          
      },
      password: {
        required
      },
      passConfirm:{
          required,
          sameAsPass:sameAs('password')
      }
  },
  mixins: [validationMixin],
  methods : {
    register () {
      this.tryReg=true;
      if(!this.$v.$invalid) {
      let user = {
        name: this.name,
        surname: this.surname,
        city: this.city,
        phoneNumber: this.phone,
        password: this.password
      }
     this.success=true;
     this.$store.dispatch('register',user)
    }
  }
  }
}
</script>

<style lang="scss" >

.enter {
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

.success {
  font-family: Arial, Helvetica, sans-serif;
  font-weight: 500;
  text-align: center;
  font-size: 24px;
  margin: 16px;
  margin-bottom: 40px;
  color: rgb(58, 57, 57);
}
</style>
