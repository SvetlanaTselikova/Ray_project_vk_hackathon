<template>
    <div class='layout'>
        <div class='inf'>
            <div class='inf__container'>
                <div class='inf__location'>Москва, ул.Коцюбинского, д.4</div>
                <div class='inf__phone'>+7-985-066-7749</div>
                <div class='inf__email'>info@rayfund.ru</div>
 
            </div>

            <div class='inf__socialNetworks'>
                <a href='https://ok.ru/fondray'><div class='inf__classmates'></div> </a>
                <a href='https://www.instagram.com/fundray/'> <div class='inf__inst'></div> </a>     
                <a href='https://www.facebook.com/fundray'><div class='inf__facebook'></div> </a>
                 <a href='https://www.youtube.com/channel/UCPP_Fd9mWVK1xuv4GiSEqeQ'><div class='inf__youtube'></div> </a>
                <a href='https://vk.com/fondray'><div class='inf__vk'></div> </a>
            </div>  
        </div> 
        

        <div class='content' >
            <slot name='content'></slot>
        </div>
     
    </div>
</template>
 <script>
export default {
    name:'Layout',
}
</script>
 <style lang="scss" scoped>
 
</style>