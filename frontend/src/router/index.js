import Vue from 'vue'
import Router from 'vue-router'
import lotto from '../components/views/Lotto/lotto_sunni'
import test from '../components/views/Lotto/test'
import test2 from '../components/views/Lotto/test2'
import test3 from '../components/views/Lotto/test3'
import test4 from '../components/views/Lotto/test4'
import '@/assets/css/base.css'
import '@/assets/css/index.css'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'lotto_sunni',
      component: lotto
    },
    {
      path: '/test',
      name: 'test',
      component: test
    },
    {
      path: '/test2',
      name: 'test2',
      component: test2
    },
    {
      path: '/test3',
      name: 'test3',
      component: test3
    },
    {
      path: '/test4',
      name: 'test4',
      component: test4
    },
    {
      path: '/tree',
      name: 'tree',
      component: test4
    }
  ]
})
