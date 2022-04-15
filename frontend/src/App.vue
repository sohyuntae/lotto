<template>
  <div id="app">
    <Lotto></Lotto>
  </div>
</template>

<script>

import Lotto from './components/views/Lotto/lotto_sunni'
export default {
  name: 'App',
  components: {
    Lotto
  },
  data () {
  },
  methods: {
  },
  created () {
    window.$_app = this
  },
  mounted () {
  }
}
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
