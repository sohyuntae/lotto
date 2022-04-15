<template>
  <div id="app">
    <router-view/>
    <confirmationDialog ref="globalAlertDialog" popupTitle="알림" :buttonType="0">  <!-- 0:닫기, 1:적용닫기, 2:예아니오 -->
      <p class="main"> {{ this.messageContent }}</p>
    </confirmationDialog>
  </div>
</template>

<script>
import confirmationDialog from './components/common/Dialog/confirmationDialog';

export default {
  name: 'App',
  components: {
    confirmationDialog,
  },
  data() {
    return {
      messageContent: '',
    };
  },
  methods: {
  },
  created() {
    window.$_app = this;
  },
  mounted() {
  },
};
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
