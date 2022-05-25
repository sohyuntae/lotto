import {getField, updateField} from 'vuex-map-fields'

const getDefaultInfo = () => ({
  test: 'test1',
  test2: 'test2',
  test3: 'test3'
})

const getDefaultState = () => ({
  defaultInfo: getDefaultInfo()
})

const state = getDefaultState()

const getters = {
  getField
}

const actions = {
  getSystemInfo: async () => {
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
      console.log(result)
      return result.data.data.query
    } catch (e) {
      console.log(e)
    }
  }
}

const mutations = {
  updateField
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
