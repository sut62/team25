<template>
<v-card class = "mx-auto" height="100%" width="100%">
    <v-navigation-drawer
    absolute
    src="https://images.unsplash.com/photo-1529400971008-f566de0e6dfc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    width="100%"
    parmanent>

  <v-container>
  <br>
  <br>
  <br>
  <br>
  <v-card
    max-width="700"
    class="mx-auto"
  >
  <v-system-bar color="#393939"></v-system-bar>
<v-system-bar color="#424242"></v-system-bar><br>
  <v-row justify="center">
   <v-toolbar-title ><h1>Welcome</h1></v-toolbar-title>
   <br>
   <br>
      </v-row>
        <v-row justify="center">
          <v-col >
            <v-row justify="center">
              <v-btn style="width:180px;height:60px " :elevation="12" class="font-weight-bold" dark
                color="#000000"
                @click="jobpost"><font text="regular-60sp" dark>Job Post</font>
              </v-btn>
            </v-row>
            <br>
            <v-row justify="center">
              <v-btn style="width:230px;height:60px " :elevation="12" class="font-weight-bold" dark
                color="#000000"
                @click="jobpostinformation"><font text="regular-60sp" dark>JobPost Information</font>
              </v-btn>
            </v-row>
            <br>
            <v-row justify="center">
              <v-btn style="width:230px;height:60px " :elevation="12" class="font-weight-bold" dark
                color="#000000"
                @click="companyinformation"><font text="regular-60sp" dark>Company Information</font>
              </v-btn>
            </v-row>
          </v-col>
        </v-row>
      <br>
      <br>
      <v-system-bar color="#424242"></v-system-bar>
      <v-system-bar color="#393939"></v-system-bar>
    </v-card>
   </v-container>
    </v-navigation-drawer>
  </v-card>
</template>



<script>
export default {
 methods: {
    jobpost(){
      this.$router.push("/jobpost");
    },
    jobpostinformation(){
      this.$router.push("/jobpostinformation");
    },
    companyinformation(){
      this.$router.push("/Companyinformation");
    },
  }
}
</script>
