<template>
  <div id="petPage">
     <HeaderEl>
    </HeaderEl>

   <div class='container'>
     <div class='row'>
       
       <div class='col-lg-4 col-md-6'>
         <div class='petPage__photo-block'>
         <div class='petPage__photo'>
         </div>
        
         <button class='petPage__btn-choose'> Выбрать питомца</button>
         </div>
       </div>
       <div class='col-lg-6 col-md-12'>
         <div class='petPage__inf-block'>
          
         <div class='petPage__header'>{{pet.name}}</div>
         <div class='petPage__sex'></div>
       
         <br>
         <div class='petPage__block-header'>Возраст:</div>
         <div class='petPage__age'>{{pet.age}}</div>
         <br>
         <div class='petPage__block-header'>Уровень счастья:</div>
         <div class="progress progress-happiness ">
          <div class="progress-bar progress-bar-happiness" v-bind:style="{ 'width': width }" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
         </div>
         <br>
         <div class='petPage__block-header'>Описание:</div>
                  <div class='petPage__description'>{{pet.description}}  </div>
         
   
         <div class='petPage__block-header'>Как помочь:</div>
         <br>
         <div class='petPage__list'>
         <div class='petPage__help-list__header'>- Самое необходимое:</div> <div class='help-icon help-icon-food'></div>
         <div class='help-icon help-icon-health'></div>
         </div>
          <br>
          <div class='petPage__list'>
         <div class='petPage__help-list__header'>- Другие нужды:</div><div class='help-icon help-icon-toilet'></div>
         <div class='help-icon help-icon-play'></div>
         <div class='help-icon help-icon-walk'></div>
          </div>
         </div>
       </div>
       <div class='col-lg-2 col-md-6'></div>
     </div>

   </div>
  </div>
</template>

<script>
import HeaderEl from '../components/Header.vue';
export default {
  name: 'PetPage',
  data () {
    return {
      id:''
    }
  },
  created: function() {this.id= this.$route.params.id; },
  
  computed:{ pet () {
    return this.$store.getters.getPetById(this.id)
  },
  components: {
  'HeaderEl':HeaderEl
  },
   width: function() {
      let widthValue=this.$store.getters.getPetById(this.id).level
      widthValue += '%';
      
      return  widthValue ;
    }
}
}
</script>

<style lang="scss">
body {
  background-color: #ecf0f5;
}
.petPage__photo-block {
   height: 470px;
   width: 100%; 
   background: white;
   position: relative;
  
}
.petPage__photo {
  position: absolute;
  left: 50%;
  top: 30px;;
  transform: translateX(-50%);
  height: 300px;
  width: 250px;
  border-radius: 0 0 10px 10px;
  background-image: url('../images/Alma.jpg');
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
  box-shadow: 0 0 15px rgba(0,0,0,0.5);
}
.petPage__inf-block {
  background: white;
  width: 100%;
  padding-left: 30px;
  padding-right: 30px;
  padding-bottom: 30px;
}

.petPage__header {
  font-size: 44px;
  font-family: Arial;
  font-weight: 600;
  color: rgb(2, 15, 128);
  display: inline-block;
  margin-top:30px;
  
}
.petPage__sex {
  width: 48px;
  height: 41px;
  display: inline-block;
  margin-left: 7px;
  background-image: url('../images/female.png');
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
}
.row {
  padding-top:40px;
}

.petPage__block-header {
  font-size: 22px;
  font-family: Arial;
  font-weight: 500;
  color: rgb(2, 15, 128);
  display: inline-block;
  margin-top: 18px;
  margin-right: 10px;
}


.petPage__age {
  font-size: 22px;
  font-family: Arial;
  font-weight: 500;
  display: inline-block;
  margin-top: 26px;
}

.petPage__description {
  margin-top: 18px;
  color: rgb(116, 110, 110);
  font: italic 300 18px Arial;
}
.petPage__btn-choose {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  bottom: 30px;
  background: linear-gradient(to right, rgb(2, 15, 128) 8%,rgb(6, 27, 207) 60%,rgb(59, 73, 204)  80%);
  opacity: 0.8;
  color: white;
  font: italic 500 20px Verdana;
  padding-top: 15px;
  padding-bottom: 15px;
  padding-left: 34px;
  padding-right: 34px;
  text-align: center;
  border-radius: 10px;
  white-space: nowrap;
}
.petPage__btn-choose:hover {
  background:rgb(6, 27, 207) ;
}
.petPage__help-list__header {
  font: italic 500 18px Arial;
  color: rgb(6, 27, 207) ;
  margin-right: 20px;
}

.petPage__list {
  height: 80px;
  display: flex;
  align-items: center;
  margin-top: 20px;
}
.progress.progress-happiness {
  margin-top:20px;
 
  width: 120px;
  height: 22px;
  border:solid rgb(107, 105, 105) 1px;
}
.progress-bar.progress-bar-happiness{

  background: rgb(250, 135, 4);
}
</style>
