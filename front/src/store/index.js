import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        jwt:''
    },
    getters:{
    },
    mutations:{
        setJwt(state,jwt){
            state.jwt=jwt
        }
    },
    actions:{
    },
    modules:{
    }
})