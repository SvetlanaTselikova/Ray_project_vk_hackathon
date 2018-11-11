<template>
    <div class='petCard'>
          <div class='petCard__image'> </div>
          <div class='petCard__header'>
          <slot name='name'>
           
          </slot>
          </div>
          <div  class='petCard__sex' v-bind:class="{ 'petCard__sex-woman': sex=='w', 'petCard__sex-man': sex=='m' }" ></div>
                       
            <div class="progress progress-happiness ">
          <div class="progress-bar progress-bar-happiness" v-bind:style="{ 'width': width }" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
       
        </div>
          <div class='petCard__description'>
          <slot name='description'>
          {{this.width}}
          </slot>
          </div>
        <router-link :to="{ name: 'PetPage', params: { id: id }}"><button class='petCard__btn petCard__btn-more'>Подробнее</button></router-link>
        <button class='petCard__btn petCard__btn-choose'>Выбрать питомца</button>
    </div>
</template>
 <script>
export default {
    name:'petCard',
      data () {
    return {
      a:'1'
    }
  },
  computed: {
    width: function() {
      let widthValue=this.level
      
      widthValue += '%';
      return  widthValue ;
    }
},
  props: ['sex','id','level']
}
</script>
 <style lang="scss" scoped>
  .petCard {
  width: 300px;
  height: 410px;
  box-shadow: 0 0 5px rgba(0,0,0,0.5);
  border-radius: 10px;
  margin:20px;
  margin-bottom: 30px;
  padding-top: 10px;
  padding-left: 15px;
  padding-right: 15px;
  position: relative;
  background: rgb(247, 242, 242);
}
.petCard__image {
  display: block; 
  height: 180px;
  width: 180px;
  margin-right: auto;
  margin-left: auto;
  border-radius: 0 0 10px 10px;
  background-image: url('../images/Alma.jpg');
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
}

.petCard__header {
  font-size: 24px;
  font-family: Arial;
  font-weight: 600;
  color: rgb(2, 15, 128);
  margin-top: 20px;
  margin-right: 5px;
  float: left;
}
.petCard__sex {
  width: 35px;
  height: 30px;
  float: left;
  margin-top: 18px;
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
}
.petCard__sex-woman {
  background-image: url('../images/female.png');
}
.petCard__sex-man {
  background-image: url('../images/male.png');
}

.petCard__description {
  margin-top: 70px;
  color: rgb(102, 98, 98);
  font: italic 500 16px Arial;
}
.progress.progress-happiness {
   float: right;
  margin-top: 26px;
  width: 100px;
  height: 20px;
  border:solid rgb(107, 105, 105) 1px;
}
.progress-bar.progress-bar-happiness{

  background: rgb(250, 135, 4);
}
.petCard__btn {
  position: absolute;
  bottom: 0;
  width: 150px;
  padding-top: 10px;
  padding-bottom: 10px;
}
.petCard__btn-more {
  left:0;
  background: rgb(2, 15, 128);
  border-radius: 0 0 0 10px;
}
.petCard__btn-more:hover {
  background: rgb(6, 27, 207);
}
.petCard__btn-choose:hover {
  background: rgb(240, 170, 40);
}
.petCard__btn-choose {
  right: 0;
  background:  rgb(250, 135, 4);
  border-radius: 0 0 10px 0;
  font-size: 17px;
  padding: 11px 6px;
}
</style>