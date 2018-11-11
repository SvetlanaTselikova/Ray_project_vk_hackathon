<template>
  <div id="tamagochi">
   <div class='container'>
     <div class='row'>
       
       <div class='col-lg-4 col-md-6'>
         <div class='tamagochi__photo-block'>
         <div class='tamagochi__photo'>
         </div>
         
    <div class='tamagochi__state-block'>
      <div class='tamagochi__state-item'>
      <label for="">Питание:</label>
            <div class="progress progress-state progress-state-food">
          <div class="progress-bar progress-bar-state progress-bar-state-food" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
            </div>
        </div>
        <div class='tamagochi__state-item'>
      <label for="">Здоровье:</label>
            <div class="progress progress-state progress-state-health">
          <div class="progress-bar progress-bar-state progress-bar-state-health" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
       
        </div> 
        </div>  
        <div class='tamagochi__state-item'>
      <label for="">Гигиена:</label>
            <div class="progress progress-state progress-state-gigi">
          <div class="progress-bar progress-bar-state progress-bar-state-gigi" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
       
        </div> 
        </div> 
        <div class='tamagochi__state-item'>
      <label for="">Игрушки:</label>
            <div class="progress progress-state progress-state-toys">
          <div class="progress-bar progress-bar-state progress-bar-state-toys" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
       
        </div> 
        </div> 
        <div class='tamagochi__state-item'>
      <label for="">Общение:</label>
            <div class="progress progress-state progress-state-chat">
          <div class="progress-bar progress-bar-state progress-bar-state-chat" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
       
        </div>                               
         </div>
         </div> 
        
           <button class='tamagochi__btn-choose'> Приютить питомца</button>
         </div>
       </div>
       <div class='col-lg-6 col-md-12'>
         <div class='tamagochi__inf-block'>
          
         <div class='tamagochi__header'>Альма</div>
         <div class='tamagochi__sex'></div>
         
       
         <br>
               
            <div class="progress progress-main text-center">
          <div class="progress-bar progress-bar-main" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="10"></div>
       
        </div>
        
         <br>
    
         
   
         <br>
         <div class='tamagochi__list'>
         <div class='tamagochi__help-list__header'>- Самое необходимое:</div> <div class='help-icon help-icon-food' data-toggle="modal" data-target="#eatingModal"></div>
         <div class='help-icon help-icon-health' data-toggle="modal" data-target="#hillModal"  ></div>
         </div>
          <br>
          <div class='tamagochi__list'>
         <div class='tamagochi__help-list__header'>- Прочие нужды:</div><div class='help-icon help-icon-toilet' data-toggle="modal" data-target="#gigiModal"></div>
         <div class='help-icon help-icon-play' data-toggle="modal" data-target="#toysModal"></div>
         <div class='help-icon help-icon-walk'></div>
          </div>
         </div>
       </div>
       <div class='col-lg-2 col-md-6'></div>
     </div>

   </div>
   <modalFeet></modalFeet>
   <modalGigi></modalGigi>
   <modalToy></modalToy>
   <modalHealth></modalHealth>
   
       
    
  </div>
</template>

<script>
import modalFeet from '../components/modalFeet.vue'
import modalGigi from '../components/modalGigi.vue'
import modalToy from '../components/modalToy.vue'
import modalHealth from '../components/modalHealth.vue'

import { mapState } from 'vuex'
export default {
  name: 'tamagochi',
  data () {
    return {
    }
  },
  components: {
    'modalFeet':modalFeet,
    'modalGigi':modalGigi,
    'modalToy':modalToy,
    'modalHealth':modalHealth,
    'modalToy':modalToy
  },
  created: function () {
   //this.$store.dispatch('myPet')

  
  },
   
 

}
</script>

<style lang="scss">
body {
  background-color: #ecf0f5;
}
.tamagochi__photo-block {
   height: 600px;
   width: 100%; 
   background: white;
   position: relative;
  
}
label {
  margin-top: 15px;
}
.progress.progress-main {
  margin-top: 20px;
  width: 200px;
  height: 25px;
  border:solid rgb(107, 105, 105) 1px;
  font:  500 18px Arial; 
  line-height: 30px;
}
.progress-bar.progress-bar-main{
  width: 80%;
  background: rgb(250, 135, 4);
}
.progress.progress-state {
  margin-top: 5px;
  width: 100px;
  height: 13px;
  border:solid rgb(107, 105, 105) 1px;
  font:  500 18px Arial; 
  line-height: 30px;
  margin-right: 10px;
 
  
}
.progress-bar.progress-bar-state-food {
  width: 60%;
}
.progress-bar.progress-bar-state-health {
  width: 70%;
}
.progress-bar.progress-bar-state-gigi {
  width: 65%;
}
.progress-bar.progress-bar-state-toys {
  width: 60%;
}
.progress-bar.progress-bar-state-chat {
  width: 50%;
}
.tamagochi__state-block {
  position: absolute;
  bottom: 110px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  left: 50%;
  transform: translateX(-50%);
  width: 250px;
}
.progress-bar.progress-bar-state{
  background: rgb(250, 135, 4);;
}
.tamagochi__photo {
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
.tamagochi__inf-block {
  background: white;
  width: 100%;
  padding-left: 30px;
  padding-right: 30px;
  padding-bottom: 30px;
}

.tamagochi__header {
  font-size: 44px;
  font-family: Arial;
  font-weight: 600;
  color: rgb(2, 15, 128);
  display: inline-block;
  margin-top:30px;
  
}
.tamagochi__sex {
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

.tamagochi__block-header {
  font-size: 22px;
  font-family: Arial;
  font-weight: 500;
  color: rgb(2, 15, 128);
  display: inline-block;
  margin-top: 16px;
  margin-right: 10px;
}



.tamagochi__btn-choose {
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
  padding-left: 32px;
  padding-right: 32px;
  text-align: center;
  border-radius: 10px;
  white-space: nowrap;
}
.tamagochi__btn-choose:hover {
  background:rgb(6, 27, 207) ;
}
.tamagochi__help-list__header {
  font: italic 500 18px Arial;
  color: rgb(6, 27, 207) ;
  margin-right: 20px;
}

.tamagochi__list {
  height: 80px;
  display: flex;
  align-items: center;
  margin-top: 20px;
}

</style>
