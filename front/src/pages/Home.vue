<template>
  <div id="home">
    <layout>
      <div slot='content'>
      <div class='content__img-block'>
        <div class='header'>
        <div class='header__logo-block'>
          <div class='header__logo'></div> <div class='header__logo-block__header'>Рэй </div>
          <br> фонд помощи бездомным животным
        </div>
        <div class='header__menu'>
          <div class='header__menu__item '>О нас</div>
          <router-link to='/Auth'><div class='header__menu__item '>Вход</div></router-link>
          <div class='header__menu__item'>Рэй-тамагочи</div>
          <div class='header__menu__item '>Как помочь</div>
        </div>
        </div>
          <div class='content__inf__block'>
          <div class='content__inf__item content__inf__work'>Выполняй задания</div>
          <div class='content__inf__item content__inf__receive'>Получай "рейчики"</div>
          <div class='content__inf__item  content__inf__pet'>Заведи собственного питомца</div>
          <div class='content__inf__item content__inf__better'>Сделай мир добрее</div>
          <div class='content__inf__btn'>Стать помощником</div>
        </div>
        <img src='../images/main_photo.jpg' class='content__image'>
  
      </div>
    </div>
  </layout>
  </div>
</template>

<script>
import layout from '../components/Layout.vue'
export default {
  name: 'home',
  data () {
    return {
     
    }
  },
  components: {
    'layout':layout
  }
}
</script>

<style lang="scss" scoped>
.content__img-block {
  position: relative;
}
.content__image {
  width: 100%;
}
.header {
  position: absolute;
}
.header__menu__item {
  color:white;
}
.header__menu__item:hover {
  color:rgb(250, 135, 4);
}
.content__inf__block {
  position: absolute;
  top: 210px;
  left: 7%;
  color: white;
}
.content__inf__item {
  height: 40px;
  font: italic 300 24px Verdana;
  padding-left: 47px;
  line-height: 40px;
  background-repeat: no-repeat;
  background-position: 0 0;
  background-size: 38px 38px;
  margin-bottom: 10px;
}
.content__inf__btn {
  margin-top: 30px;
  background: linear-gradient(to right, rgb(2, 15, 128) 8%,rgb(6, 27, 207) 60%,rgb(59, 73, 204)  80%);
  opacity: 0.8;
  color: white;
  display: inline-block;
  font: italic 500 1.6em Verdana;
  padding-top: 15px;
  padding-bottom: 15px;
  padding-left: 24px;
  padding-right: 24px;
  text-align: center;
  border-radius: 40px 40px 40px 40px;
}
.content__inf__work {
  background-image: url(../images/check.png);
}
.content__inf__receive {
  background-image: url(../images/prize.png);
  background-size: 35px 38px;
}
.content__inf__pet {
  background-image: url(../images/pet.png);
}
.content__inf__better {
  background-image: url(../images/smile.png);
}

</style>
