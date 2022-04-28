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
      <button class="btn" @click="boom">Click Me!</button>
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

import svgComponent from './svgComponent';

export default {
  components: {
    svgComponent
  },
  name: 'test2',
  data () {
    return {
      message: 'test2',
      maxNum: 45,
      lotteList: [],
      colors: ['#ffb3f6', '#ffb3f6', '#333'],
      shapes: [{
        class: 'star',
        points:
            '21,0,28.053423027509677,11.29179606750063,40.97218684219823,14.510643118126104,32.412678195541844,24.70820393249937,33.34349029814194,37.989356881873896,21,33,8.656509701858067,37.989356881873896,9.587321804458158,24.70820393249937,1.0278131578017735,14.510643118126108,13.94657697249032,11.291796067500632'
      },
      {
        class: 'other-star',
        points:
              '18,0,22.242640687119284,13.757359312880714,36,18,22.242640687119284,22.242640687119284,18.000000000000004,36,13.757359312880716,22.242640687119284,0,18.000000000000004,13.757359312880714,13.757359312880716'
      },
      {
        class: 'diamond',
        points:
              '18,0,27.192388155425117,8.80761184457488,36,18,27.19238815542512,27.192388155425117,18.000000000000004,36,8.807611844574883,27.19238815542512,0,18.000000000000004,8.80761184457488,8.807611844574884'
      }]
    }
  },
  computed: {
  },
  methods: {
    boom (event) {
      const num = Math.floor(Math.random() * 50) + 30
      let group = []

      let randBG = 0
      let getShape = 0
      let c = 0
      let scale = 0
      let x = 0
      let y = 0
      let sec = 0

      let cir = ''
      let shape = ''
      let shapeBox = document.createElementNS('http://www.w3.org/2000/svg', 'polygon')

      for (let i = 0; i < num; i++) {
        randBG = Math.floor(Math.random() * this.colors.length)
        getShape = Math.floor(Math.random() * this.shapes.length)
        c = Math.floor(Math.random() * 10) + 5
        scale = Math.floor(Math.random() * (8 - 4 + 1)) + 4
        x = Math.floor(Math.random() * (150 + 100)) - 100
        y = Math.floor(Math.random() * (150 + 100)) - 100
        sec = Math.floor(Math.random() * 1700) + 1000

        cir = document.createElement('div')
        cir.classList.add('cir')

        shape = document.createElement('svg')
        shape.classList.add('shape')
        shape.style.top = `${event.pageY - event.y + 20}px`
        shape.style.left = `${event.pageX - event.x + 40}px`
        shape.style.transform = 'scale(0.' + scale + ')'
        shape.style.transition = sec + 'ms'
        shape.style.fill = this.colors[randBG]
        shape.style.background = this.colors[randBG]

        shape.appendChild(shapeBox)
        shapeBox.classList.add(this.shapes[getShape].class)
        shapeBox.setAttribute('points', this.shapes[getShape].points)

        event.target.parentNode.appendChild(shape)
        group.push({ shape, x, y })
      }

      // console.log(cir)
      // console.log(shape)
      console.log(shapeBox)
      // console.log(group)

      for (let a = 0; a < group.length; a++) {
        let {shape, x, y} = group[a]
        requestAnimationFrame(() => {
          shape.style.top = `${x + 50}px`
          shape.style.left = `${y + 15}px`
          shape.style.transform = 'scale(0)'
        })
      }

      // setTimeout(function () {
      //   for (var b = 0; b < group.length; b++) {
      //     var shape = group[b].shape
      //     shape.remove()
      //   }
      //   group = []
      // }, 2000)

      console.log(shape)
    }
  },
  /* 페이지가 뜰 때 실행 */
  async created () {
  },
  /* 페이지가 다 뜨고 난 후 실행 */
  mounted () {
  }
}
</script>
