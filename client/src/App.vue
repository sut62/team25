<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span class="font-weight-light">ระบบสมัครงาน</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn depressed color="primary" @click="home">home</v-btn>
    </v-app-bar>

    <v-content>
      <!-- <VideoRental/> -->
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  data: () => ({
    
  }),
  methods: {
    home(){
      this.$router.push("/");
    }
  }
};
</script>
