import axios from 'axios'
import Vue from 'vue'
import App from './App'
import router from './router'

const globalMethod = {
  graphqlRequest: async (param) => {
    console.log(1)
    const result = await axios({
      url: `http://localhost:11040/graphql`,
      method: 'post',
      headers: {
        'Content-Type': 'application/json'
      },
      data: {
        query: param
      }
    })
    if (result.status === 203) {
      console.log(1)
    }
    return result
  }
}

Vue.config.productionTip = false
Vue.prototype.$graphqlRequest = globalMethod.graphqlRequest

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
