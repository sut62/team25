<template>
<v-card   color="#F0FFFF" :elevation="13" >
  <v-container>

    <v-layout text-center wrap>
      <v-flex mb-4>
        <br />
        <h1 class="display-2 font-weight-bold mb-3 color=#000000 ">Company Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <div v-if="alert === 'null'"></div>
      <div v-else-if="alert === 'true'"><v-alert type ="success">พบข้อมูล</v-alert></div>
      <div v-else-if="alert === 'false'"><v-alert type ="error">ไม่พบข้อมูล</v-alert></div>
    </v-row>
      
    <v-row justify="center">
        <v-form v-model="valid" ref="form">
          <v-row justify="center">
            
              <v-text-field
                outlined
                class="font-weight-bold"
                color="#1E88E5"
                label="Company ID"
                v-model="company.companyId"
                :rules="[(v) => !!v || 'Item is required']"
                required
              ></v-text-field>

              &nbsp;&nbsp;&nbsp;&nbsp;

              <v-btn @click="findCompany" depressed large rounded color="primary"><v-icon dark left>mdi-file-document-box-search-outline</v-icon>Search</v-btn>

          </v-row>
        </v-form>
    </v-row>

              
       <v-row justify="center">
          <p v-if="companyCheck != ''"><v-text-field
            class="font-weight-bold"
            outlined    
            color="#1E88E5"
            v-model="companyName"
            label="Name"
            readonly
            prepend-icon="mdi-domain"       
          ></v-text-field></p>
        </v-row>

        <v-row justify="center">
            <p v-if="companyCheck != ''"><v-text-field
                class="font-weight-bold "
                outlined
                color="#1E88E5"
                v-model="companySize"
                label="CompanySize"
                readonly            
            ></v-text-field></p>

            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <p v-if="companyCheck != ''"><v-text-field
                class="font-weight-bold "
                outlined
                color="#1E88E5"
                v-model="companyType"
                label="CompanyType"
                readonly            
            ></v-text-field></p>
              
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <p v-if="companyCheck != ''"><v-text-field
                class="font-weight-bold "
                outlined
                color="#1E88E5"
                v-model="companyProvince"
                label="Province"
                readonly            
            ></v-text-field></p>
           

        </v-row>

        <v-row justify="center">
            <p v-if="companyCheck != ''"><v-text-field
                class="font-weight-bold"
                outlined
                prepend-icon="mdi-email"
                color="#1E88E5"
                v-model="companyEmail"
                label="Email"
                readonly            
          ></v-text-field></p>
        </v-row>


         <v-row justify="center">
            <v-btn rounded style="margin-left: 15px;" @click="clear" :elevation="10">
              <v-icon dark left>mdi-cached</v-icon>
            Clear</v-btn>
            <v-btn rounded style="margin-left: 15px;" @click="back" :elevation="10">
              <v-icon dark left>mdi-arrow-left-circle-outline</v-icon>Back</v-btn><br /><br /><br />
        </v-row>

          <div v-if="companyCheck">
            <br />
          </div>
  </v-container>
 </v-card>
</template>

<script>
import http from "../http-common";
export default {
  name: "company",
  data() {
    return {
      company: {
        companyId: ""
        
      },
      valid: false,
      companyCheck: false,
      companyName: "",
      companyEmail: "",
      companyType: "",
      companySize: "",
      companyProvince: "",
      alert: "null",
      alert1: "null"
    };
  },
  methods: {
    findCompany() {
      http
        .get("/company/" + this.company.companyId)
        .then(response => {
          console.log(response);
          if (response.data != null) {
            this.alert = 'true';
            this.companyName = response.data.name;
            this.companyEmail = response.data.email;
            this.companySize = response.data.size.name;
            this.companyType = response.data.type.name;
            this.companyProvince = response.data.province.name;
            this.companyCheck = response.status;
          } else {
            this.alert = 'false';
            this.companyCheck = false;
          }          
        })
        .catch(e => {
          console.log(e);
        });
      this.submitted = true;
    },

    clear() {
      this.$refs.form.reset();
      this.companyCheck = false;
      this.alert = 'clear';
    },

    back(){
      this.$router.push("/Companychoice");
    },

  }
    
  
};
</script>