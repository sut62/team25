<template>
<v-card   color="#F0FFFF" :elevation="13" >
  <v-container>

    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3 color=#000000 ">Welcome to Search User</h1>
      </v-flex>
    </v-layout></br></br>

   <v-row justify="center">
      
        <v-form v-model="valid" ref="form">
          <v-row justify="center">
            
              <v-text-field
                outlined
                class="font-weight-bold"
                color="#1E88E5"
                label="User ID"
                v-model="user.userId"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-text-field>

              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                <v-btn @click="findUser" depressed large color="primary">Search</v-btn>

              </v-row>
            </v-form>
    </v-row></br></br>

              
      <v-row justify="center">
          <p v-if="userCheck != ''"><v-text-field 
            class="font-weight-bold"
            outlined
            color="#1E88E5"
            v-model="userNameType"
            label="NameType "  
            prepend-icon="mdi-account"          
          ></v-text-field></p>

           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

          
              <p v-if="userCheck != ''"><v-text-field
            class="font-weight-bold"
            outlined    
            color="#1E88E5"
            v-model="userName"
            label="Name"            
          ></v-text-field></p>
          
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
              <p v-if="userCheck != ''"><v-text-field
            class="font-weight-bold"
            outlined
            color="#1E88E5"
            v-model="userGender"
            label="Gender"            
          ></v-text-field></p>
        </v-row>

        <v-row justify="center">
              <p v-if="userCheck != ''"><v-text-field
            class="font-weight-bold"
            outlined
            prepend-icon="mdi-email"
            color="#1E88E5"
            v-model="userEmail"
            label="Email"            
          ></v-text-field></p>
        </v-row>

        <v-row justify="center">
              <p v-if="userCheck != ''"><v-text-field
            class="font-weight-bold"
            outlined
            prepend-icon="mdi-phone"
            color="#1E88E5"
            v-model="userPhone"
            label="Phone"            
          ></v-text-field></p>
              
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

              <p v-if="userCheck != ''"><v-text-field
            class="font-weight-bold "
            outlined
            color="#1E88E5"
            v-model="userPhoneType"
            label="PhoneType"            
          ></v-text-field></p>
            </v-col>

        </v-row>

         <v-row justify="center">
        <v-btn rounded style="margin-left: 15px;" @click="clear" :elevation="10">
                <v-icon dark left>mdi-cached</v-icon>
                Clear</v-btn>
                <v-btn rounded style="margin-left: 15px;" @click="back" :elevation="10">
                <v-icon dark left>mdi-arrow-left-circle-outline</v-icon>Back</v-btn><br /><br /><br />
          </v-row>

          <div v-if="userCheck">
            

            <br />
          </div>
        
  </v-container>
 </v-card>
</template>

<script>
import http from "../http-common";
export default {
  name: "user",
  data() {
    return {
      user: {
        userId: ""
        
      },
      valid: false,
      userCheck: false,
      userName: "",
      userPhone: "",
      userEmail: "",
      userNameType: "",
      userGender: "",
      userPhoneType: ""
    };
  },
  methods: {
    
    // function ค้นหาลูกค้าด้วย ID
    findUser() {
      http
        .get("/user/" + this.user.userId)
        .then(response => {
          console.log(response);
          if (response.data != null) {
            this.userName = response.data.name;
            this.userPhone = response.data.phone;
            this.userEmail = response.data.email;
            this.userPhoneType = response.data.phoneType.name;
            this.userNameType = response.data.nameType.name;
            this.userGender = response.data.gender.name;
            this.userCheck = response.status;
          } else {
            this.clear()
          }          
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },

    clear() {
      this.$refs.form.reset();
      this.userCheck = false;
    },

    back(){
      this.$router.push("/Userchoice");
    },

    }
    
  
};
</script>