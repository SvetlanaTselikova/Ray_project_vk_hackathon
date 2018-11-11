<template>
  <div id="taskList">
    <div class='container'>
      <div class='row'>
   <div class='col-sm-9'>
     <div class='taskList__inf'>
       <taskCard v-for="task in tasks" v-bind:key="task.id" v-bind:type='task.type' v-bind:id='task.id'>
         <div slot='name'>
           {{task.title}}
         </div>
         <div slot='description'>{{task.description}}</div>
       </taskCard>
     </div>
   </div>
   <div class='col-sm-3'>
     
   </div>
      </div>
    </div>
  </div>
</template>

<script>
import taskCard from '../components/Task.vue'
import { mapState } from 'vuex'
export default {
  name: 'taskList',
  data () {
    return {
      
    }
  },
  computed: mapState({tasks: state => state.tasks.tasks}),
  components: {
  'taskCard':taskCard
  },
  created: function () {
  this.$store.dispatch('listOftasks')
  }
}
</script>

<style lang="scss">
.taskList__inf {
  width: 100%;
  padding: 20px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
</style>
