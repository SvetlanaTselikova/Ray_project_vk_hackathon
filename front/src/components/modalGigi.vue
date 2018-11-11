<template>
    <div class='modalGigi'>
      			
 			
		 <div class="modal fade" id="gigiModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Купить средства гигиены</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body text-center">
						<form class="text-center" style="">
							<button type="button" class="btn btn-outline-warning" @click="minus">-</button>
							<label for="" style="margin: 0 10px;">{{count}}</label>
							<button type="button" class="btn btn-outline-warning" @click="plus">+</button>
							<label for="">наполнитель (шт)</label>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
						<button type="button" class="btn btn-primary" @click="gigi">Принять</button>
					</div>
				</div>
			</div>
		</div>
    
       
    </div>
</template>
 <script>
 
export default {
		name:'modalGigi',
		data () {
    return {
		 count:1
    }
  },
		methods : {
		plus () {
			this.count+=1
		},
		minus () {
			if (this.count>1)
			this.count-=1
		},
    gigi () {
      let act = {
				count:this.count  
      }
     this.$store.dispatch('gigi',act)
    }
  }

}
</script>
 <style lang="scss" scoped>
 
</style>