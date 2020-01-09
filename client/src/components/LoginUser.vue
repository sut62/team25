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
                label="Email"
                v-model= "email"
                :rules="[(v) => !!v || 'This field is required']"
                required
                class="font-weight-bold"
                clearable
                rounded
                outlined
                prepend-icon="mdi-email"
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
                prepend-icon="mdi-lock"
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
  getUsers() {
      http
        .get("/user")
        .then(response => {
          this.users = response.data;
          
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    BLogin() { 
      http
        .get("/checkuser/" + this.email + "/" + this.password)
        .then(response => {
          console.log(response);
          if (response.data[0] != null ) {
            localStorage.setItem('email', response.data[0].email); 
            localStorage.setItem('name', response.data[0].name);
            localStorage.setItem('id', response.data[0].id);
            localStorage.setItem('phone', response.data[0].phone);
             localStorage.setItem('nametype', response.data[0].nametype);
             localStorage.setItem('gender', response.data[0].gender);
             localStorage.setItem('phonetype', response.data[0].phonetype);

            this.$router.push("/Userchoice");

          } else {
            alert('รหัสผ่านไม่ถูกต้อง')
          }          
        }).catch(e => {
          console.log(e);
        });
    },
    Register(){
      this.$router.push("/registeruser");
    }

  },
  mounted() {
  this.getUsers();
    this.BLogin();
    
    
  }
}

</script>
