<template>
  <div id="Account">
    <layout>
      <div slot='content'>
    
       <taskCard></taskCard>
      

    </div>
  </layout>
  </div>
</template>

<script>
import layout from '../components/Layout.vue'
import petCard from '../components/petCard.vue'
import taskCard from '../components/Task.vue'
import headerEl from '../components/Header.vue'
export default {
  name: 'account',
  data () {
    return {
     
    }
  },
  components: {
    'layout':layout,
    'petCard':petCard,
    'taskCard':taskCard,
    'headerEl':headerEl
  }
}
</script>

<style lang="scss" scoped>

</style>
