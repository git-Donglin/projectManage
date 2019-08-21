export default {  
    install(Vue,options)  
    {  
      Vue.prototype.baseUrl = "http://192.168.1.5:8081";
      Vue.prototype.getTitle = {  
        title:'',  
        isBack: true,  
        isAdd:  false,  
      };  
      Vue.prototype.showFootTab = {  
        isShow:false,  
        active:0,  
      }  
    }  
  }