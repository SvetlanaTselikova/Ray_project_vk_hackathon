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
          <a href='#about'><div class='header__menu__item '>О нас</div></a>
          <router-link to='/Auth'><div class='header__menu__item '>Вход</div></router-link>
          <a href='#play'><div class='header__menu__item'>Рэй-тамагочи</div></a>
          <a href='#help'><div class='header__menu__item '>Как помочь</div></a>
        </div>
        </div>
          <div class='content__inf__block'>
          <div class='content__inf__item content__inf__work'>Выполняй задания</div>
          <div class='content__inf__item content__inf__receive'>Получай "рейчики"</div>
          <div class='content__inf__item  content__inf__pet'>Заведи собственного питомца</div>
          <div class='content__inf__item content__inf__better'>Сделай мир добрее</div>
          <router-link to='/Auth'><button class='content__inf__btn'>Стать помощником</button></router-link>
        </div>
        <img src='../images/main_photo.jpg' class='content__image'>
  
      </div>
      <a name='about'><div class='h1'>О фонде</div>
      <div class='content-about'>Благотворительный фонд помощи бездомным животным "РЭЙ" помогает 30 приютам для бездомных животных Москвы и Подмосковья, в которых содержится более 15000 собак и кошек. Мы закупаем корма и лекарства, лечим и стерилизуем животных с улиц и из приютов и, конечно же, помогаем найти им любящие семьи.
Этим приложением мы попытались максимизировать удобство коммуникации волонтеров с приютами и упростить задачу помощи животным.</div>
      </a>
      <a name='play'><div class='h1'>Рэй-тамагочи</div>
       <div class='content-about'></div></a>
       <div class='content-about'>Давно хотели завести котенка или собачку, но родители не разрешают? Или в детстве скорее бежали домой, чтобы покормить питомца в любимой тамагочи? Но даже если вы не узнали себя, а просто не имеете возможности обзавестись домашним любимцем, то наше приложение «Тамагочи Рэй» поможет вам в исполнении давней мечты, а животным почувствовать заботу.
Вам достаточно выбрать питомца, который вам приглянулся и нажать на кнопку «Взять опеку». Теперь вы будете получать больше очков доверия за выполнение действий с животным! Но будьте ответственны, если вы не будете несколько дней заботиться о своем питомце, то мы будем вынуждены снять вашу опеку и отнять очки доверия!</div>
      <a name='help'><div class='h1'>Как помочь</div></a>
       <div class='content-about'>Десятки приютов по всей стране ежедневно нуждаются в разной помощи. Сотни бездомных животных хотят почувствовать, что они кому-то нужны в этом мире!
На этой странице вы можете найти задания от разных благотворительных организаций, от простой прогулки с животным, до помощи в переезде.
Выполняя задания вы получаете баллы, которые повышают ваш «Уровень помощника». Чем выше это значение, тем больше к вам доверия со стороны приютов и организаторов. А самое главное, тем более ощутимый вклад в жизни питомцев вы внесли.
Для удобства использования, вы можете выбрать приюты своего города, тип помощи, а также другие параметры задания!
Сделаем мир лучше вместе!
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
  border:none;
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
.content-about {
  text-align: center;
  color: rgb(41, 36, 36);
  font:  italic 300 24px Arial;
  margin-left: 15%;
  margin-right: 15%;
  line-height: 1.7;
  margin-bottom:30px;
}

</style>
