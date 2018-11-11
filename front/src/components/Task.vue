<template>
    <div class='taskCard'>
      <div class='taskCard__header'> <slot name='name'>
           
          </slot></div>
      <div class='taskCard__type' v-bind:class="{ 'taskCard__feet': type=='feet','taskCard__drive': type=='drive','taskCard__home': type=='home' }"></div>
      <div class='taskCard__description'><slot name='description'>
          
          </slot></div>
    <button class='taskCard__btn taskCard__btn-more'>Подробнее</button>
      <button class='taskCard__btn taskCard__btn-choose'>Выполнить</button>
    </div>
</template>
 <script>
export default {
    name:'taskCard',
      data () {
    return {
     
    }
  },
  props: ['type','id']
}
</script>
 <style lang="scss" scoped>
 .taskCard {
  box-shadow: 0 0 15px rgba(0,0,0,0.5);
  border-radius: 10px;
  width: 320px;
  height: 200px;
  padding: 20px;
  position: relative;
  margin:20px;
 }
 .taskCard__header {
  font-size: 24px;
  font-family: Arial;
  font-weight: 600;
  color: rgb(2, 15, 128);
  float: left;
  width: 240px;
 }
 .taskCard__type {
  height: 30px;
  width: 30px;
  margin-top: 0px;
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
  float: right;
}
.taskCard__home {
 background-image: url('../images/taskHome.png');
}
.taskCard__feet {
 height: 32px;
 width: 32px;
 background-image: url('../images/type_food.png');
}
.taskCard__drive {
 height: 34px;
 width: 34px;
 background-image: url('../images/type_drive.png');
}
 .taskCard__description {
  margin-top: 50px;
  color: rgb(102, 98, 98);
  font: italic 500 16px Arial;
}
 .taskCard__btn {
  position: absolute;
  bottom: 0;
  width: 160px;
  padding-top: 12px;
  padding-bottom: 12px;
}
.taskCard__btn-more {
  left:0;
  background: rgb(2, 15, 128);
  border-radius: 0 0 0 10px;
}
.taskCard__btn-more:hover {
  background: rgb(6, 27, 207);
}
.taskCard__btn-choose:hover {
  background: rgb(240, 170, 40);
}
.taskCard__btn-choose {
  right: 0;
  background:  rgb(250, 135, 4);
  border-radius: 0 0 10px 0;
}
</style>