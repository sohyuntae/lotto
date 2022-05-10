<template>
  <div>
    <label>test</label>
    <input type="text" disabled>
    <input type="text" disabled>
    <input type="text" disabled>
  </div>
</template>

<script type="javascript">

import {createHelpers} from 'vuex-map-fields'

const {mapFields} = createHelpers({
  getterType: 'test4/getField',
  mutationType: 'test4/updateField'
})

export default {
  components: {},
  data () {
  },
  computed: {
    ...mapFields([
      'defaultInfo'
    ])
  },
  methods: {
    initDate () {
      console.log(this.defaultInfo)
    }
  },
  /* 페이지가 뜰 때 실행 */
  created () {
  },
  /* 페이지가 다 뜨고 난 후 실행 */
  mounted () {
    this.initDate()
  }
}
</script>
