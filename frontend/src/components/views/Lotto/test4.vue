<template>
  <div id="test111">
    <label>test</label>
    <br>
    <table>
      <tbody>
      <tr>
        <td v-for = 'systemKey in systemKeyList' v-bind:key="systemKey"> {{ systemKey }}</td>
        <td v-for = 'systemName in systemNameList' v-bind:key="systemName"> {{ systemName }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script type="javascript">

// import {createHelpers} from 'vuex-map-fields'

// const {mapFields} = createHelpers({
//   getterType: 'test4/getField',
//   mutationType: 'test4/updateField'
// })

export default {
  components: {},
  data () {
    return {
      testData: [],
      systemKeyList: [],
      systemNameList: []
    }
  },
  computed: {
    // ...mapFields([
    //   'defaultInfo'
    // ])
  },
  methods: {
    async initDate () {
      // 스토어 사용이 안됨.
      // const systemInfo = this.$store.dispatch('test4/getSystemInfo')
      // console.log(systemInfo)
      const query = `{
        query: system
        {
          groupKey
          groupUserKey
          systemKey
          systemName
        }
      }`
      try {
        const result = await window.$_app.$graphqlRequest(query)
        this.testData = result.data.data.query
        this.systemKeyList = []
        this.systemNameList = []
        this.testData.forEach(item => {
          this.systemKeyList.push(item.systemKey)
          this.systemNameList.push(item.systemName)
        })
      } catch (e) {
        console.log(e)
      }
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
