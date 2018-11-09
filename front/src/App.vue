<template>
  <div id="app">
   <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
  data () {
    return {
    }
  },
  created: function () {
  localStorage.removeItem('user-token')
  if (this.$store.getters.isAuthenticated) {
    this.$store.dispatch('USER_REQUEST')
    }
  }
}
</script>

<style lang="scss">
@import './assets/_index.scss';
</style>
