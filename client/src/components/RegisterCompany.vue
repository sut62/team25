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
      <v-toolbar-title>
      <h1 class="font-weight-CONDENSED" dark>Company Register</h1>
      </v-toolbar-title>
    </v-row>
    </v-card>
    <br>
    <v-card max-width="900" class="mx-auto" color="#EEEEEE" :elevation="7">
      <v-row>
        <v-col cols="15">
          <v-form v-model="valid" ref="form">
          
            <v-row style="height: 95px;" justify="center">
              <v-col cols="3" sm="4">
                <v-text-field
                  v-model="company.name"
                  :items="names"
                  color="#42A5F5"
                  label="Company Name"
                  class="font-weight-bold"
                  :rules="[(v) => !!v || 'Company Name is required']"
                  required
                  placeholder
                  filied
                  loading
                  dense
                  clearable
                  prepend-icon="mdi-domain"
                ></v-text-field>
              </v-col>
            </v-row>

            <v-row style="height: 80px;" justify="center">
              <v-col cols="3" sm="3">
                <v-select
                 class="font-weight-bold"
                  label="Company Size"
                  outlined
                  loading
                  color="#1E88E5"
                  v-model="company.companySizeId"
                  :items="sizes"
                  item-text="name"
                  item-value="id"
                  :rules="[(v) => !!v || 'Please select Size']"
                ></v-select>
              </v-col>
              
                <v-col cols="4">
                  <v-select
                    class="font-weight-bold"
                    label="Company Type"
                    outlined
                    loading
                    color="#1976D2"
                    v-model="company.companyTypeId"
                    :items="types"
                    item-text="name"
                    item-value="id"
                    :rules="[(v) => !!v || 'Please select Type']"
                  ></v-select>
                </v-col>


                <v-col cols="3">
                  <v-select
                    class="font-weight-bold"
                    label="Province"
                    outlined
                    loading
                    color="#1565C0"
                    v-model="company.provinceId"
                    :items="provinces"
                    item-text="name"
                    item-value="id"
                    :rules="[(v) => !!v || 'Please select Province']"
                  ></v-select>
                </v-col>
            </v-row>

            
          
            <v-row style="height: 95px;" justify="center">
              <v-col cols="3" sm="4">
                <v-text-field
                  v-model="company.email"
                  :items="emails"
                  :rules="emailRules"
                  color="#0D47A1"
                  label="E-mail"
                  class="font-weight-bold"
                  placeholder
                  filied
                  loading
                  dense
                  clearable
                  prepend-icon="mdi-at"
                ></v-text-field>
              </v-col>
            </v-row>

        

    
            <v-row style="height: 120px;" justify="center">
              <v-col cols="3" sm="5">
                <v-text-field
                  color="#000000"
                  solo
                  class="font-weight-bold"
                  label="Password"
                  v-model="password"
                  :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                  :rules="[rules.required, rules.min]"
                  :type="show1 ? 'text' : 'password'"
                  hint="At least 10 characters"
                  prepend-icon="mdi-textbox-password"
                  required
                  counter
                  clearable
                  rounded
                  outlined
                  @click:append="show1 = !show1"
                ></v-text-field>
              </v-col>

      
              <v-col cols="3" sm="5">
                <v-text-field
                  color="#000000"
                  solo
                  class="font-weight-bold"
                  label="Confirm Password"
                  v-model="repassword"
                  :type="show2 ? 'text' : 'password'"
                  :append-icon="show2 ?  'mdi-eye' : 'mdi-eye-off'"
                  :rules="[rules.required,rules.checkpass]"
                  hint="At least 10 characters"
                  prepend-icon="mdi-textbox-password"
                  required
                  counter
                  clearable
                  rounded
                  outlined
                  @click:append="show2 = !show2"
                ></v-text-field>
              </v-col>
            </v-row>  
        
        </v-form>
      </v-col>
    </v-row>
    </v-card>
    <br>
    <v-row justify="center">
              <v-col cols="5000" sm="1000">
                <div v-if="saveCompany">
                <v-btn rounded @click="saveCompany" :class="{ grey: !valid, black: valid }" :elevation="10" dark>
                <v-icon dark left>mdi-account-plus</v-icon>register</v-btn>
                <v-btn rounded style="margin-left: 15px;" @click="back" :elevation="10">
                <v-icon dark left>mdi-arrow-left-circle-outline</v-icon>Back</v-btn>
                </div>
              </v-col>
            </v-row>
  
     <br>
     <v-row justify="center">
      <div v-if="alert === 'null'"></div>
      <div v-else-if="alert === 'true'"><v-alert type ="success">บันทึกสำเร็จ</v-alert></div>
      <div v-else-if="alert === 'false'"><v-alert type ="error">บันทึกไม่สำเร็จ</v-alert></div>
    </v-row>

  </v-container>
  </v-navigation-drawer>
  </v-card>
</template>


<script>
import http from "../http-common";

export default {
  name: "company",
  data(){
    return{
      company: {
        name: "",
        email: "",
        password: "",
        companyTypeId: "",
        provinceId: "",
        companySizeId: ""
      },

      show1 : false,
      show2 : false,
      items: [],
      valid : false,
      names : [],
      emails : [],
      types : [],
      provinces : [],
      sizes : [],
      passwords : [],
      alert: "null",
      alert1: "null",

       rules: {
          required: value => !!value || 'This field is required',
          min: v => v.length >= 10 || 'Min 10 characters',
          checkpass: () => this.repassword == this.password || 'Passwords do not match',
          nphone: v => v.length <= 20 || 'Max 20 characters',
      },

      emailRules: [
      v => !!v || 'E-mail is required',
      v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],

    };
  },
  methods: {
    
    getTypes() {
      http
        .get("/companyType")
        .then(response => {
          this.types = response.data;
          console.log(response.data);

        })
        .catch(e => {
          console.log(e);
        });
    },
    getProvinces() {
      http
        .get("/province")
        .then(response => {
          this.provinces = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
     getSizes() {
      http
        .get("/companySize")
        .then(response => {
          this.sizes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
     saveCompany() {

       if (
        !this.company.name ||
        !this.company.email ||
        !this.password ||
        !this.repassword ||
        !this.company.companySizeId ||
        !this.company.provinceId ||
        !this.company.companyTypeId
        ){
        this.alert = 'false';
        }

       else if((this.password == this.repassword) && (this.password.length>=10 || this.repassword.length>=10)
      ){
      http
        .post(
          "/company/" +
            this.company.name +
            "/"+
            this.company.email +
            "/"+
            this.password +
            "/"+
            this.company.companySizeId +
            "/"+
            this.company.provinceId +
            "/" +
            this.company.companyTypeId,
          this.company
        )
        .then(response => {
        console.log(response);
        this.alert = 'true';
        })
        .catch(e => {
        console.log(e);
        });
        this.submitted = true;
      }else{
      this.alert = 'false'; 
      }
        },

    getCompanys() {
      http
        .get("/company")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
      ViewRegisterData(){
      this.$router.push("/registerdata");
    },
    back() {
      this.$router.push("/logincompany");
    },
    refreshList() {
      this.getCompanyTypes();
      this.getProvinces();
      this.getCompanySizes();
      this.getCompanys();
    }
  
  },
  mounted() {
    this.getTypes();
    this.getProvinces();
    this.getSizes();
    this.getCompanys();
  }
};

</script>