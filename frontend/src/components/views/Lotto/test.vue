<template>
  <section>
    <!-- <article>
      <h2> {{ message }} </h2>
    </article>

    <article>
      <span>추가 : </span>
      <input type="number" id="test1" v-on:keydown.enter="testCheckEvnt">
    </article> -->

    <!-- <article>
      <div class="ball-wrap">
        <button v-for="n in 45" v-bind:key="n" class="ball" @click="activeBtn">
          <span> {{ n }}</span>
        </button>
      </div>
    </article> -->

    <div class="btn-contain">
      <button class="btn" @click="activeBtn">Click Me!</button>
      <div class="btn-particles">
      </div>
    </div>

  </section>
</template>

<style scoped>
.shape {
position: absolute;
width: 50px;
height: 50px;
transform: scale(0.8);
}
.cir {
position: absolute;
border-radius: 50%;
z-index: 5;
}
.btn-contain {
width: 200px;
height: 100px;
position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%, -50%);
}

.btn {
position: absolute;
top: 50%;
left: 50%;
transform: translate(-50%, -50%);
border-radius: 4px;
background: #333;
text-align: center;
z-index: 10;
transition: 0.2s;
cursor: pointer;
color: #fff;
box-shadow: 0px 1px 5px 2px #BFCEEF;
}

.btn:active, .btn:hover, .btn:focus {
outline: none !important;
color: white;
}

.btn-particles {
width: 100px;
height: 100px;
position: absolute;
border-radius: 50%;
color: #eee;
font-family: monospace;
z-index: 5;
}

.btn:active {
transform: scale(0.9) translate(-55%, -55%);
}
</style>

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
    },
    randomClass () {
      const balls = document.getElementsByClassName('ball')
      setTimeout(() => {
        for (let i = 0; i < balls.length; i += 1) {
          const randomNm = `ball${Math.floor(Math.random() * 5) + 1}`
          balls[i].classList.add(randomNm)
        }
      }, 100)
    },
    activeBtn (e) {
      var colors = [
        '#ffb3f6',
        '#7aa0ff',
        '#333'
      ]
      var shapes = [
        '<polygon class="star" points="21,0,28.053423027509677,11.29179606750063,40.97218684219823,14.510643118126104,32.412678195541844,24.70820393249937,33.34349029814194,37.989356881873896,21,33,8.656509701858067,37.989356881873896,9.587321804458158,24.70820393249937,1.0278131578017735,14.510643118126108,13.94657697249032,11.291796067500632"></polygon>',
        '<polygon class="other-star" points="18,0,22.242640687119284,13.757359312880714,36,18,22.242640687119284,22.242640687119284,18.000000000000004,36,13.757359312880716,22.242640687119284,0,18.000000000000004,13.757359312880714,13.757359312880716"></polygon>',
        '<polygon class="diamond" points="18,0,27.192388155425117,8.80761184457488,36,18,27.19238815542512,27.192388155425117,18.000000000000004,36,8.807611844574883,27.19238815542512,0,18.000000000000004,8.80761184457488,8.807611844574884"></polygon>'
      ]

      var btn = e.target
      // 형제 찾기(btn-particles)
      // const btnChildren = btn.parentElement.children
      // const tempArr = []
      // for (var j = 0; j < btnChildren.length; j += 1) {
      //   tempArr.push(btnChildren[j])
      // }
      // const brnSilbling = tempArr.filter((e) => { return e !== btn })[0]
      const brnSilbling = document.getElementsByClassName('btn-particles')[0]

      var group = []

      var shape = document.createElement('svg')
      shape.classList.add('shape')

      var num = Math.floor(Math.random() * 50) + 30

      for (var i = 0; i < num; i += 1) {
        // 랜덤 이미지, 위치 지정
        var randBG = Math.floor(Math.random() * colors.length)
        var getShape = Math.floor(Math.random() * shapes.length)
        var scale = Math.floor(Math.random() * (8 - 4 + 1)) + 4
        var x = Math.floor(Math.random() * (150 + 100)) - 100
        var y = Math.floor(Math.random() * (150 + 100)) - 100
        var sec = Math.floor(Math.random() * 1700) + 1000

        shape.innerHTML = shapes[getShape] // 랜덤으로 shapes 추가

        shape.style.top = e.pageY - btn.offsetTop + 20
        shape.style.left = e.pageX - btn.offsetLeft + 40
        shape.style.transform = 'scale(0.' + scale + ')'
        shape.style.transition = sec + 'ms'
        shape.style.fill = colors[randBG]

        console.log(shape, 'shape')
        // brnSilbling.innerHTML = shape
        brnSilbling.appendChild(shape)
        console.log(brnSilbling)
        group.push({shape: shape, x: x, y: y})
      }

      for (var a = 0; a < group.length; a++) {
        var groupShape = group[a].shape
        var groupX = group[a].x
        var groupY = group[a].y
        groupShape.style.left = groupX + 50
        groupShape.style.top = groupY + 15
        groupShape.style.transform = 'scale(0)'
      }

      setTimeout(function () {
        for (var b = 0; b < group.length; b++) {
          var shape = group[b].shape
          shape.remove()
        }
        group = []
      }, 2000)
    }
  },
  /* 페이지가 뜰 때 실행 */
  async created () {
  },
  /* 페이지가 다 뜨고 난 후 실행 */
  mounted () {
    this.initSys()
    this.randomClass()
  }
}
</script>
