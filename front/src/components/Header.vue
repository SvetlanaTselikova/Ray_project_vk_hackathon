<template> 
    <header>
        <div class="header-container">
            <div class="logo-box">
                <a href="#">
                    <img src="../images/logo.png" alt="pic">
                </a>
            </div>
            
            <div class="user-header" style="display:flex;">
                <div class="menu">
                    <router-link to='/TasksList'><strong>Задания</strong></router-link>
                    <router-link to='/PetsList'><strong>Животные</strong></router-link>
                </div>
                <a class="user-label"><span class="glyphicon glyphicon-user"></span>Иван Иванов </a>
            </div>
        </div>
    </header>
</template>
 <script>
export default {
    name:'HeaderEl',
}
</script>
 <style lang="scss" scoped>
 header .header-container {
	display: flex;
	justify-content:space-between;
	background: #f0f8ff;
}

.logo-box img {
	height: 80px;
	margin: 20px 0 10px 35px;
}

.header-container .user-label {
	color: blue;
	margin-top: 40px;
	margin-right: 125px;
}

.menu {
    margin-top: 40px;
}

.menu a {
    font-size: 17px;
    color: grey;
    text-decoration: none;
    margin-right: 40px;
}

a:hover {
    border-bottom: 3px solid #ffa834;
}
</style>