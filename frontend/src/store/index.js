import Vue from 'vue'
import Vuex from 'vuex'
import test4 from './test4'

Vue.use(Vuex)

const store = new Vuex.Store({
  plugins: [],
  modules: {
    test4
  },
  strict: false
})

export default store
