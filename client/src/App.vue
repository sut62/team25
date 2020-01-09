<template>
  <v-app>
    <v-app-bar app color = "#BDBDBD">
      <v-toolbar-title class="headline text-uppercase">
        <span>Recruitment </span>
        <span class="font-weight-light" > System</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>

      <div class="text">
             <v-btn large outlined rounded class="ma-2" loaders color="#000000" @click="back" dark>Back To HOME</v-btn>
             </div>
             <span class="mr-2"></span>
    </v-app-bar>



    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',
  data: () => ({
    username: '',
  }),

  methods: {


    back(){
     this.$router.push("/");
    }


  },

};


</script>
