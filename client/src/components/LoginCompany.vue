<template>
<v-card class = "mx-auto" height="100%" width="100%">
    <v-navigation-drawer 
    absolute
    src="https://images.unsplash.com/photo-1516321165247-4aa89a48be28?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1094&q=80"
    width="100%"
    parmanent>
       <v-container>
   <br>
   <br>
   <br>
<v-card 
  max-width="800"
  class="mx-auto"
  color=#EEEEEE
  :elevation="20"
>
<v-system-bar color="#393939"></v-system-bar>
<v-system-bar color="#424242"></v-system-bar><br>
<v-card class="mx-auto" max-width="180" color="#424242" :elevation="15" dark>
<v-row justify="center">
   <v-toolbar-title><h1>Login</h1></v-toolbar-title>
</v-row>
</v-card><br>
    <v-row justify="center">
            <v-col cols="6">
              <v-text-field
                color="#000000"
                solo
                label="E-mail"
                v-model= "email"
                :rules="[(v) => !!v || 'Email is required']"
                required
                class="font-weight-bold"
                clearable
                rounded
                outlined
                prepend-icon="mdi-at"
              ></v-text-field>
            </v-col>
          </v-row>
 
       <v-row justify="center">
            <v-col cols="6">
              <v-text-field
                solo
                color="#000000"
                label="PASSWORD"
                v-model= "password"
                :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
                :type="show ? 'text' : 'password'"
                prepend-icon="mdi-textbox-password"
                :rules="[(v) => !!v || 'Password is required']"
                required
                class="font-weight-bold"
                counter
                clearable
                outlined
                rounded
                @click:append="show = !show"
              ></v-text-field>
            </v-col>
          </v-row>

           <v-row justify="center">
            <v-col >
              <v-btn rounded loaders color="#000000" :elevation="5" dark
                style="margin-left:25%;"
                @click="BLogin" class="font-weight-black"><v-icon dark left>mdi-login</v-icon>Login
              </v-btn>
    
              <v-btn rounded loaders color="#000000" :elevation="5" dark
                style="margin-left:25%;"
                @click="Register" class="font-weight-black"><v-icon dark left>mdi-account-plus</v-icon>Register
              </v-btn>
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
import http from "../http-common";
export default {
  name: "Loing",
  data() {
    return {
      email:"",
      password: "",
      show:false,
      
    };
  },
  methods: {
    BLogin(){ 
      http
        .get("/checkcompany/" + this.email + "/" + this.password)
        .then(response => {
          console.log(response);
          if (response.data[0] != null ) {
            localStorage.setItem('id', response.data[0].id);
          
            localStorage.setItem('name', response.data[0].name);

            this.$router.push("/Companychoice");

          } else {
            alert('รหัสผ่านไม่ถูกต้อง')
          }          
        }).catch(e => {
          console.log(e);
        });
    },
    Register(){
      this.$router.push("/registercompany");
    }

  },
  mounted() {
    this.getCompanys();
    this.BLogin();
  }
}

</script>
