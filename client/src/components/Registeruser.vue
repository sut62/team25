<template>
  <v-card class = "mx-auto" height="100%" width="100%">
    <v-navigation-drawer 
    absolute
    src="https://images.unsplash.com/photo-1484807352052-23338990c6c6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
    width="100%"
    parmanent>

  <v-container>
    <v-card class="mx-auto" max-width="350" color="#424242" :elevation="13" dark>
      <v-row justify="center">
        <v-toolbar-title><br>
        <h1 class="font-weight-CONDENSED" dark>Applicant Register</h1><br>
        </v-toolbar-title>
      </v-row>
      </v-card>

      <v-card max-width="900" class="mx-auto" color="#EEEEEE" :elevation="7"><br>
      <v-row>
      <v-col cols="15">
      <v-form>
      <v-row style="height: 75px;" justify="center">
      <br>
      <v-col cols="3">
      <v-select
          v-model="user.nameTypeId"
                  :items="nameTypes"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Please select NameType']"
                  label="NameType"
                  color="#42A5F5"
                  class="font-weight-bold"
                  required
                  placeholder
                  filied
                  loading
                  dense
                  clearable
          prepend-icon="mdi-account"
        ></v-select>
      </v-col>

      <v-col cols="3">
       <v-text-field
            class="font-weight-bold"
            outlined
             loading
              color="#1E88E5"
            v-model="user.name"
            :items="names"  
            label="Name"            
          ></v-text-field>
      </v-col>

      <v-col cols="3">
      <v-select
          label="Gender"
                  color="#42A5F5"
                  class="font-weight-bold"
                  required
                  placeholder
                  filied
                  loading
                  dense
                  clearable
                  v-model="user.genderId"
                  :items="genders"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Please select Gender']"
        ></v-select>
      </v-col>
      </v-row><br>

 <v-row style="height: 75px;" justify="center">
 <v-col cols="3" sm="5">
       <v-text-field
            class="font-weight-bold"
            outlined
             loading
              color="#1E88E5"
            v-model="user.email"
            :items="emails"
            :rules="emailRules"
            label="Email"
            prepend-icon="mdi-email"
          ></v-text-field>
      </v-col>
  </v-row><br>

  <v-row style="height: 75px;" justify="center">
 <v-col cols="3" sm="5">
       <v-text-field
                class="font-weight-bold"
            outlined
             loading
              color="#1E88E5"
                label="PASSWORD"
                v-model= "password"
                :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                :rules="[rules.required, rules.min]"
                :type="show1 ? 'text' : 'password'"
                hint="At least 8 characters"
                prepend-icon="mdi-lock"
                required
                counter
                clearable
                @click:append="show1 = !show1"
          ></v-text-field>
      </v-col>

      <v-col cols="3" sm="5">
       <v-text-field
                class="font-weight-bold"
            outlined
             loading
              color="#1E88E5"
                label="Confirm PASSWORD"
                v-model= "repassword"
                :type="show2 ? 'text' : 'password'"
                :append-icon="show2 ?  'mdi-eye' : 'mdi-eye-off'"
                :rules="[rules.required,rules.checkpass]"
                hint="At least 8 characters"
                prepend-icon="mdi-lock"
                required
                counter
                clearable
                @click:append="show2 = !show2"
          ></v-text-field>
      </v-col>
  </v-row><br>

    <v-row style="height: 75px;" justify="center">

     <v-col cols="3" sm="4">
       <v-select
          label="PhoneType"
                  color="#42A5F5"
                  class="font-weight-bold"
                  required
                  placeholder
                  filied
                  loading
                  dense
                  clearable
                  v-model="user.phoneTypeId"
                  :items="phoneTypes"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Please select PhoneType']"
        ></v-select>
      </v-col>

 <v-col cols="3" sm="4">
       <v-text-field
       class="font-weight-bold"
            outlined
             loading
              color="#1E88E5"
            v-model="user.phone"
            :items="phones"
            :rules="[rules.nphone]"
            label="Phone"
            prepend-icon="mdi-phone"
          ></v-text-field>
      </v-col>
  </v-row><br>

  </v-form>
      </v-col>
      </v-row>
    </v-card>
    <br>

            <v-row justify="center">
            <v-col cols="5000" sm="1000">
                <div v-if="saveUser">
                <v-btn rounded @click="saveUser" :class="{ grey: !valid, black: valid }" :elevation="10" dark>
                <v-icon dark left>mdi-account-plus</v-icon>register</v-btn>

                <v-btn rounded style="margin-left: 15px;" @click="back" :elevation="10">
                <v-icon dark left>mdi-arrow-left-circle-outline</v-icon>Back</v-btn>
                </div>
              </v-col>
            </v-row>

            <div v-if="alert === 'null'"></div>
      <div v-else-if="alert === 'true'"><v-alert type ="succes">บันทึกสำเร็จ¨</v-alert></div>
      <div v-else-if="alert === 'false'"><v-alert type ="error">บันทึกไม่สำเร็จ¨</v-alert></div>

  </v-container>
    </v-navigation-drawer>
  </v-card>
</template>


<script>
import http from "../http-common";

export default {
  name: "user",
  data(){
    return{
      user: {
        name: "",
        email: "",
        password: "",
        phone: "",
        genderId: "",
        phoneTypeId: "",
        nameTypeId: ""
      },

      show1: false,
      show2: false,
      items: [],
      valid : false,
      names : [],
      emails : [],
      passwords : [],
      phones : [],
      nameTypes : [],
      genders : [],
      phoneTypes : [],
      alert: "null",
      alert1: "null",

      rules: {
          required: value => !!value || 'This field is required',
          min: v => v.length >= 8 || 'Min 8 characters',
          checkpass: () => this.repassword == this.password || 'Passwords do not match',
          nphone: v => v.length <= 10 || 'Max 10 characters',
      },

      emailRules: [
      v => !!v || 'E-mail is required',
      v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],

    };
  },
  methods: {
    /* eslint-disable no-console */
    getNameTypes() {
      http
        .get("/nameType")
        .then(response => {
          this.nameTypes = response.data;
          console.log(response.data);

        })
        .catch(e => {
          console.log(e);
        });
    },
    getPhoneTypes() {
      http
        .get("/phoneType")
        .then(response => {
          this.phoneTypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
     getGenders() {
      http
        .get("/gender")
        .then(response => {
          this.genders = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
     saveUser() {

     if (
        !this.user.name ||
        !this.user.email ||
        !this.password ||
        !this.repassword ||
        !this.user.phone ||
        !this.user.nameTypeId ||
        !this.user.phoneTypeId ||
        !this.user.genderId
        ){
        this.alert = 'false';
        }

      else if ((this.password == this.repassword) && (this.password.length>=8 || this.repassword.length>=8) && (this.user.phone.length>=9)){
      http
        .post(
          "/user/" +
            this.user.name +
            "/"+
            this.user.email +
            "/"+
            this.password +
            "/"+
            this.user.phone +
            "/"+
            this.user.nameTypeId +
            "/"+
            this.user.phoneTypeId +
            "/" +
            this.user.genderId,
          this.user
        )
        .then(response => {
        console.log(response);
        
         this.alert = 'true';
         })
        .catch(e => {
        console.log(e);
        });
        this.submitted = true;
      }
        else{
      this.alert = 'false'; 
    }
        },

    getUsers() {
      http
        .get("/user")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
      back(){
      this.$router.push("/LoginUser");
    },
    refreshList() {
      this.getNameTypes();
      this.getPhoneTypes();
      this.getGenders();
      this.getUsers();
    }
    /* eslint-enable no-console */
  },
  mounted() {
    this.getNameTypes();
    this.getPhoneTypes();
    this.getGenders();
    this.getUsers();
  }
};

</script>
