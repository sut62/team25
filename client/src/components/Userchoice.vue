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
   <br>
      </v-row> 

        <v-row justify="center">
          <v-col >
            <v-row justify="center">
              <v-btn style="width:180px;height:60px " :elevation="7" class="font-weight-bold" dark
                color="#000000"
                @click="Application"><font text="regular-60sp" dark>Apply for a job</font>   
              </v-btn>
            </v-row> 
          </v-col>
        </v-row>   

        <v-row justify="center">
          <v-col >
            <v-row justify="center">
              <v-btn style="width:200px;height:60px " :elevation="7" class="font-weight-bold" dark
                color="#000000"
                @click="Search"><font text="regular-60sp" dark>Search RegisterUser</font>   
              </v-btn>
            </v-row> 
          </v-col>
        </v-row> 

        <v-row justify="center">
          <v-col >
            <v-row justify="center">
              <v-btn style="width:200px;height:60px " :elevation="7" class="font-weight-bold" dark
                color="#000000"
                @click="showInfo"><font text="regular-60sp" dark>show info</font>   
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
    
    Application(){
      this.$router.push("/Addjob");
    },

    Search(){
      this.$router.push("/SearchUser");
    },
    
    showInfo(){
      this.$router.push("/ShowInfo");
    },

  },

}

</script>
