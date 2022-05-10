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

const actions = {}

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
