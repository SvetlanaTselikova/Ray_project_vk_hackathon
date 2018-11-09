<template>
  <div class='form__blank'>
    <div class='form__container'>
    <div class='form__content'>
      <div class='title-form'>
        <slot name='form__name'></slot>
      </div>
      <slot name='form__content'></slot>
    </div> 
    </div> 
    </div>  
</template>
 <script>
export default {
    name:'form__blank',
    data () {
      return {
     
      }
    }
}
</script>
 <style lang="scss" scoped>
.form__container {
  width: 450px;
  margin-left: auto;
  margin-right: auto;
  text-align: center;
}
.form__logo {
  width: 270px;
  height: 70px;
  margin-top: 24px;
  margin-bottom: 20px;
}
.form__content {
  width: 450px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 16px;
  box-shadow: 0 0 15px rgba(32, 32, 32, 0.5);
  border-radius: 10px;
}

</style>