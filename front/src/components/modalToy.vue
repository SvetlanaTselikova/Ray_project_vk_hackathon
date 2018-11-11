<template>
  	<div class='modaltoy'>
 			
		 <div class="modal fade" id="toysModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Поиграть</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="" style="">
						  	<div class="form-group">
										<label  for="">Купить игрушку</label>
										<select id="selectMedicalHelp" class="form-control" v-model="selected">
											<option value="seaweed">Водоросли</option>
											<option value="house">Домик</option>
											<option value="bones">Кость</option>
											<option value="laser">Лазер</option>
											<option value="car">Машинка</option>
											<option value="ball">Мячик</option>
										</select>	
										
						  	</div>
							  
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" @click="toy">Принять</button>
					</div>
				</div>
			</div>
		</div>
  	</div>
</template>
 <script>
 
export default {
		name:'modaltoy',
		data () {
    return {
			selected:''
    }
  },
  
  props: ['types'],
		methods : {
    toy () {
			let id
			if(selected==='Лазер')
			id=5
			if(selected==='Мячик')
			id=6
			if(selected==='Водоросли')
			id=7
			if(selected==='Домик')
			id=8
			if(selected==='Кость')
			id=9
      let act = {
			 id:id
			}
			console.log(vm.selected.id)
     this.$store.dispatch('toy',act)
    }
  }

}
</script>
 <style lang="scss" scoped>
 
</style>