<template>
<div>
    <HeaderEl>
    </HeaderEl>

    <div id="petList">
    <div class='container'>
      <div class='row'>
   <div class='col-sm-9'>
     <div class='petList__inf'>
       <petCard v-for="pet in pets" v-bind:key="pet.name" v-bind:sex='pet.sex' v-bind:id='pet.id' v-bind:level='pet.level'>
         <div slot='name'>
           {{pet.name}}
         </div>
         <div slot='description'>{{pet.description}}</div>
       </petCard>
     </div>
   </div>
   <div class='col-sm-3'>
     
   </div>
      </div>
    </div>
  </div>

</div>
  
</template>

<script>
import petCard from '../components/petCard.vue'
import HeaderEl from '../components/Header.vue';
import { mapState } from 'vuex'
export default {
  name: 'petList',
  data () {
    return {
      
    }
  },
  computed: mapState({pets: state => state.pets.pets}),
  components: {
  'petCard':petCard,
  'HeaderEl': HeaderEl 
  },
  created: function () {
  this.$store.dispatch('listOfPets')
  }
}
</script>

<style lang="scss">
.petList__inf {
  width: 100%;
  padding: 20px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
</style>
