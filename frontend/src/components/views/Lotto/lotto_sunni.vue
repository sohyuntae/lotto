<template>
  <div>
    <p> {{ message }} </p>
    <span v-for="n in 45" v-bind:key="n" > {{ n }}</span>
    추가 : <input id="test1" v-on:keydown.enter="testCheckEvnt">
  </div>
</template>

<script type="text/javascript">
// import { createHelpers } from 'vuex-map-fields'

// const { mapFields } = createHelpers({
//   getterType: 'lotto_sunni/getField',
//   mutationType: 'lotto_sunni/updateField'
// })

export default {
  components: {
  },
  name: 'lotto_sunni',
  data () {
    return {
      message: 'test',
      maxNum: 45,
      lotteList: []
    }
  },
  computed: {
    // ...mapFields([
    //   'lottoNumberList'
    // ])
  },
  methods: {
    initSys () {
      console.log(1)
    },
    testCheckEvnt () {
      console.log(2)
    }
  },
  /* 페이지가 뜰 때 실행 */
  async created () {
  },
  /* 페이지가 다 뜨고 난 후 실행 */
  mounted () {
    this.initSys()
  }
}
</script>
