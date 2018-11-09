<template>
    <div class='petCard'>
          <div class='petCard__image'> </div>
          <slot name='name'>
          <div class='petCard__header'>Альма</div>
          </slot>
          <div  class='petCard__sex'></div>
          <div class='petCard__footPrintBlock'>
            <div class='petCard__footPrintBlock__item petCard__footPrintBlock__item-first'> </div>
            <div class='petCard__footPrintBlock__item petCard__footPrintBlock__item-second'> </div>
            <div class='petCard__footPrintBlock__item petCard__footPrintBlock__item-third'> </div>
          </div>
          <slot name='description'>
          <div class='petCard__description'>Альма — это не просто собака, а грациозная, красивая и скромная натура. Молода, стерилизована и привита, имеет ветеринарный паспорт. Рост в холке 55 см.  </div>
          </slot>
        <button class='petCard__btn petCard__btn-more'>Подробнее</button>
        <button class='petCard__btn petCard__btn-choose'>Выбрать питомца</button>
    </div>
</template>
 <script>
export default {
    name:'petCard',
      data () {
    return {
     
    }
  }
}
</script>
 <style lang="scss" scoped>
  .petCard {
  width: 300px;
  height: 410px;
  box-shadow: 0 0 15px rgba(0,0,0,0.5);
  border-radius: 10px;
  margin:20px;
  padding-top: 10px;
  padding-left: 15px;
  padding-right: 15px;
  position: relative;
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
  font-size: 28px;
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
  background-image: url('../images/female.png');
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
}
.petCard__footPrintBlock {
  float: right;
  margin-top: 20px;
}
.petCard__footPrintBlock__item {
  width: 28px;
  height: 25px;
  margin-left: 3px;
  background-image: url('../images/footPrint.png');
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 100% 100%;
  display: inline-block;
}
.petCard__footPrintBlock__item-first {
  background-image: url('../images/footPrintFull.png');
}
.petCard__description {
  margin-top: 70px;
  color: rgb(102, 98, 98);
  font: italic 500 16px Arial;
}
.petCard__btn {
  position: absolute;
  bottom: 0;
  width: 165px;
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
}
</style>