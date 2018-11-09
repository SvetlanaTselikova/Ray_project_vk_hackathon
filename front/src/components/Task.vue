<template>
    <div class='taskCard'>
      <div class='taskCard__header'>Передержка для кошки</div>
      <div class='taskCard__type'></div>
      <div class='taskCard__description'>Кошке мусе нужна временная передержка сроком на две недели</div>
      <button class='taskCard__btn taskCard__btn-more'>Подробнее</button>
      <button class='taskCard__btn taskCard__btn-choose'>Выбрать задание</button>
    </div>
</template>
 <script>
export default {
    name:'taskCard',
      data () {
    return {
     
    }
  }
}
</script>
 <style lang="scss" scoped>
 .taskCard {
  box-shadow: 0 0 15px rgba(0,0,0,0.5);
  border-radius: 10px;
  width: 280px;
  height: 160px;
  padding: 20px;
  position: relative;
 }
 .taskCard__header {
  font-size: 28px;
  font-family: Arial;
  font-weight: 600;
  color: rgb(2, 15, 128);
  float: left;
  width: 240px;
 }
 .taskCard__type {
  height: 30px;
  width: 30px;
  background-image: url('../images/taskHome.png');
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
  float: right;
  
}
 .taskCard__description {
  margin-top: 70px;
  color: rgb(102, 98, 98);
  font: italic 500 16px Arial;
}
 .taskCard__btn {
  position: absolute;
  bottom: 0;
  width: 160px;
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