<template>
       <v-container>
   <br>
   <br>
   <br>


<v-card 
  max-width="700"
  class="mx-auto"
>

<v-system-bar color="green"></v-system-bar>
<v-system-bar color="green"></v-system-bar>
 <v-row justify="center">
   <v-toolbar-title ><h1>ยินดีต้อนรับ</h1></v-toolbar-title>
   </v-row> 
 <v-row justify="center">
            <v-col >
                <v-row justify="center">
            <v-btn style="width:180px;height:60px "
                color="green"
                @click="Application"><font color="#FFFFFF">สมัครงาน</font>
                 
              </v-btn>
              </v-row> 
               </v-col>
               =
          
         
          
        </v-row> 
         
<br>
<br>
<v-system-bar color="green"></v-system-bar>
<v-system-bar color="green"></v-system-bar>
  </v-card>
   </v-container>
   
</template>



<script>

export default {
  methods: {
    
    Application(){
      this.$router.push("/registeruser/login/Application");
    },
    

  },

}

</script>
