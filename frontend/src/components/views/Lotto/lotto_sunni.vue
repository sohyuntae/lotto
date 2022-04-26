<template>
  <section>
    <article>
      <h2> {{ message }} </h2>
    </article>

    <article>
      <span>추가 : </span>
      <input type="number" id="test1" v-on:keydown.enter="testCheckEvnt">
    </article>

    <article>
      <div class="ball-wrap">
        <button v-for="n in 45" v-bind:key="n" class="ball">
          <span> {{ n }}</span>
        </button>
      </div>
    </article>

  </section>
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
      this.randomClass()
    },
    testCheckEvnt () {
      this.randomClass()
    },
    randomClass () {
      const balls = document.getElementsByClassName('ball')
      setTimeout(() => {
        for (let i = 0; i < balls.length; i += 1) {
          const randomNm = `ball${Math.floor(Math.random() * 5) + 1}`
          balls[i].classList.add(randomNm)
        }
      }, 100)
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
