<template>
  <div>
    <p> {{ message }} </p>
  </div>
</template>

<script type="text/javascript">
import { createHelpers } from 'vuex-map-fields'

const { mapFields } = createHelpers({
  getterType: 'lotto_sunni/getField',
  mutationType: 'lotto_sunni/updateField'
})

export default {
  components: {
  },
  name: 'lotto_sunni',
  data () {
    return {
      message: 'test'
    }
  },
  computed: {
    ...mapFields([
      'lottoNumberList'
    ])
  },
  methods: {
    initSys () {
      console.log(1)
      console.log(this.lottoNumberList)
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
