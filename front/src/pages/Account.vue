<template>
<div>
    <HeaderEl></HeaderEl>

     <div class="container">
   		<div class="row">
            <div class="info-user col-md-12">   				
                <div class="user-parametres">
                    <div class="personal-info" style="width: 100%">
                        <div class="personal">
                                <label for="" style="margin-top: 60px;">Иван Иванов, 37, Magnitogorsk</label>
                        </div>
                        
                        <div class="volunteer-info">
                            <div class="levels" >
                                <div class="simple-level form-group">
                                    <label for="" style="padding-left: 67px;">Уровень:</label>
                                    <div class="progress text-center " style="width: 180px;">
                                        <div class="progress-bar" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">	</div>
                                    </div>
                                </div>
                                <div class="trust-level">
                                    <label for="">Уровень доверия:</label>
                                    <div class="progress" style="width: 180px;">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>

                            <div class="benefits">
                                <label for="" style="padding-left: 64px;">Награды:</label>
                            </div>
                                
                        </div>
                    </div>
                </div>
            </div>
   		</div>
   		
   		<div class="row">
   			<div class="user-data col-md-9">
   			    <h1>Мои животные</h1>
                    <div class="grid-lookup-outer">
                        <div id="divLookupData" style="width:100%;" class='show-on-grid'>
                            <table id="grid" class="table table-striped table-bordered table-hover">

                            </table>
                            <div id="pager"></div>
                        </div>
                    </div>
   			</div>
   			
            <div class="nav-menu col-md-3">
                <ul class="list-group">
                    <a v-on:click="getMyTasks" class="list-group-item list-group-item-action">Мои задания</a>
                   <router-link to='/Tamagochi'> <a v-on:click="getMyPets" class="list-group-item list-group-item-action enabled">Мои животные</a></router-link>
                </ul>
            </div>
            
   		</div>
    </div>

</div>
</template>  

<script>
    
</script>

<script>
import axios from 'axios';
import HeaderEl from '../components/Header.vue';

export default {
    name: 'user-page',
    components: {
        'HeaderEl': HeaderEl 
    },

    myPets: [{}],
    data () {
        return {
        }
    },
    methods: {
        getMyPets: function () {
            this.hello();
            console.log('getMyPets');
            axios.get('http://172.20.38.37:8080/pets/all', {
            headers: {
                'Content-Type': 'application/json'
            }
            }).then(response => {
                console.log(response.data);
            })
        },
        getMyTasks: function () {
            console.log('getMyTasks');
            this.hello();
            axios.get('http://172.20.38.37:8080/tasks/all', {
            headers: {
                'Content-Type': 'application/json'
            }
            }).then(response => {
                console.log(response.data);
            })
        },
            hello: function () {
                $('.list-group a').on('click', function () {
                $(this).addClass('enabled').siblings().removeClass('enabled');
                });
        }
    }
}

</script>


<style>
.info-user {
	margin-bottom: 25px;
}

.user-data h1 {
	margin-bottom: 20px;
}


.user-parametres {
	display: flex;
	border-bottom: 1px solid grey;
	padding-bottom: 20px;
	background-image: url(../images/user-photo-3.jpg);
	min-height: 200px;
	background-size: cover;
}

.personal-info {
	padding-left: 15px;	
	color: #ffffff;
	display: flex;
	justify-content: space-between;
	position:absolute;
	bottom:0;
}
.container {
	margin-top: 25px;	
}

.enabled {
	border-left: 3px solid	#ffa834;
}

.simple-level {
	margin-right: 15px;
	display: flex;
}

.levels .progress {
	margin-top: 5px;
	margin-left: 5px;
}


.trust-level {
	display: flex;
}

.volunteer-info {
	margin-right: 28px;
}
.trust-level {
	margin-top: -15px;
}

.user-data {
	border-right: 1px solid grey;
}

.main-pages {
	padding-top: 20px;
}

.main-pages p {
	margin-bottom: 40px;
}


</style>

