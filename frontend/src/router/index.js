import Vue from 'vue'
import Router from 'vue-router'
import lotto from '../components/views/Lotto/lotto_sunni'
import '@/assets/css/base.css'
import '@/assets/css/index.css'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'lotto_sunni',
      component: lotto
    }
  ]
})
