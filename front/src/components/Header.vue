<template>
  
        <div class='header' >
            <div class='header__logo-block'>
                <div class='header__logo'></div> <div class='header__logo-block__header'>Рэй </div>
                <br> фонд помощи бездомным животным
            </div>
            <div class='header__menu'><slot name='header__menu'></slot>
            </div>
      </div>
   
</template>
 <script>
export default {
    name:'HeaderEl',
}
</script>
 <style lang="scss" scoped>
 .header {
    position: relative;
 }
</style>