<template>
  	<div class='modalHealth'>
 			
		 <div class="modal fade" id="hillModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Вылечить</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="" style="">
						  	<div class="form-group">
										<label  for="">Выбрать медицинскую помощь</label>
										<select id="selectMedicalHelp" class="form-control" v-model="selected">
											
											<option>Стерилизовать</option>
											<option>Купить лекарства</option>
											<option >Провести обследование</option>
											<option >Сдать анализы</option>
										</select>	
										
						  	</div>
							  
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" @click="health">Принять</button>
					</div>
				</div>
			</div>
		</div>
  	</div>
</template>
 <script>
 
export default {
		name:'modalhealth',
		data () {
    return {
			selected:''
    }
  },
  
  props: ['types'],
		methods : {
    health () {
			let id
			if(selected==='Стерилизовать')
			id=1
			if(selected==='Купить лекарства')
			id=2
			if(selected==='Провести обследование')
			id=3
			if(selected==='Сдать анализы')
			id=4
		
      let act = {
			 id:id
			}
			console.log(vm.selected.id)
     this.$store.dispatch('health',act)
    }
  }

}
</script>
 <style lang="scss" scoped>
 
</style>