<template>
  <div id="demo">
    <svg width="200" height="200">
      <polygon :points="points"></polygon>
      <circle cx="100" cy="100" r="90"></circle>
    </svg>
    <label>Sides: {{ sides }}</label>
    <input
        type="range"
        min="3"
        max="500"
        v-model.number="sides"
    >
    <label>Minimum Radius: {{ minRadius }}%</label>
    <input
        type="range"
        min="0"
        max="90"
        v-model.number="minRadius"
    >
    <label>Update Interval: {{ updateInterval }} milliseconds</label>
    <input
        type="range"
        min="10"
        max="2000"
        v-model.number="updateInterval"
    >
  </div>
</template>

<style scoped>
  svg {
    display: block;
  }

  polygon {
    fill: #41B883;
  }

  circle {
    fill: transparent;
    stroke: #35495E;
  }

  input[type="range"] {
    display: block;
    width: 100%;
    margin-bottom: 15px;
  }
</style>

<script type="text/javascript">

import { gsap } from 'gsap'

let defaultSides = 10
let stats = Array.apply(null, {length: defaultSides})
  .map(function () {
    return 100
  })

export default {
  components: {
  },
  name: 'test3',
  data () {
    return {
      message: 'test3',
      stats: stats,
      points: generatePoints(stats),
      sides: defaultSides,
      minRadius: 50,
      interval: null,
      updateInterval: 500
    }
  },
  watch: {
    sides: function (newSides, oldSides) {
      var sidesDifference = newSides - oldSides
      if (sidesDifference > 0) {
        for (var i = 1; i <= sidesDifference; i++) {
          this.stats.push(this.newRandomValue())
        }
      } else {
        var absoluteSidesDifference = Math.abs(sidesDifference)
        for (let i = 1; i <= absoluteSidesDifference; i++) {
          this.stats.shift()
        }
      }
    },
    stats: function (newStats) {
      gsap.to(
        this.$data,
        {points: generatePoints(newStats)}
      )
    },
    updateInterval: function () {
      this.resetInterval()
    }
  },
  mounted: function () {
    this.resetInterval()
  },
  computed: {
  },
  methods: {
    randomizeStats: function () {
      const vm = this
      this.stats = this.stats.map(function () {
        return vm.newRandomValue()
      })
    },
    newRandomValue: function () {
      return Math.ceil(this.minRadius + Math.random() * (100 - this.minRadius))
    },
    resetInterval: function () {
      const vm = this
      clearInterval(this.interval)
      this.randomizeStats()
      this.interval = setInterval(function () {
        vm.randomizeStats()
      }, this.updateInterval)
    }
  },
  /* 페이지가 뜰 때 실행 */
  async created () {
    console.log(1)
  }
  /* 페이지가 다 뜨고 난 후 실행 */
  // mounted () {
  //   this.resetInterval()
  // }
}

function valueToPoint (value, index, total) {
  let x = 0
  let y = -value * 0.9
  let angle = Math.PI * 2 / total * index
  let cos = Math.cos(angle)
  let sin = Math.sin(angle)
  let tx = x * cos - y * sin + 100
  let ty = x * sin + y * cos + 100
  return {x: tx, y: ty}
}

function generatePoints (stats) {
  let total = stats.length
  return stats.map(function (stat, index) {
    let point = valueToPoint(stat, index, total)
    return point.x + ',' + point.y
  }).join(' ')
}

</script>
