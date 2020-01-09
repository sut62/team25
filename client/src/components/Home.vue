<template>
  <v-card class="mx-auto" height="100%" width="100%">
    <v-navigation-drawer
      absolute
      src="https://images.unsplash.com/photo-1487528278747-ba99ed528ebc?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"
      width="100%"
      parmanent
    >
      <div>
        <v-row align="center">
          <v-col class="text-center">
              <br>
              <v-card class="mx-auto" max-width="350" color="#424242" :elevation="13" dark>
                <v-row justify="center">
                    <v-toolbar-title>
                        <font><p class="font-weight-black display-2 ">
                        Welcome
                        </p></font>
                    </v-toolbar-title>
                </v-row>
            </v-card>
            <p></p>
          </v-col>
        </v-row>

        <v-row align="center">
          <v-col class="text-center">
            <v-card
              max-width="600"
              height="450"
              class="mx-auto"
              color="#CFD8DC"
             
            >
              <v-row align="center">
                <v-col class="text-center">
                  <p></p>
                  <font
                    ><p class="text-center font-weight-black display-2 ">
                      APPLICANT	
                    </p></font
                  >
                  <p></p>
                  <br />
                  <img
                    src="..\assets\user.png"
                    style="width:200px;height:200px;"
                  />
                </v-col>
              </v-row>
              <v-row align="center">
                <v-col class="text-center" cols="30">
                  <v-btn x-large color="#000000" dark @click="userlogin"
                    >login</v-btn
                  >
                </v-col>
              </v-row>
            </v-card>
          </v-col>

          <v-col class="text-center">
            <v-card
              max-width="600"
              height="450"
              class="mx-auto"
              color="#CFD8DC"
              
            >
              <v-row align="center">
                <v-col class="text-center">
                  <p></p>
                  <font
                    ><p class="text-center font-weight-black display-2 ">
                      COMPANY
                    </p></font
                  >
                  <p></p>
                  <br />
                  <img
                    src="..\assets\company.png"
                    style="width:200px;height:200px;"
                  />
                </v-col>
              </v-row>

              <v-row align="center">
                <!-- <v-col class="text-center" cols="30"> 
                        <v-btn x-large color="green" dark @click="userlogin">ผู้สมัครงาน</v-btn>
                    </v-col>-->
                <v-col class="text-center" cols="30">
                  <v-btn x-large color="#000000" dark @click="companylogin"
                    >LOGIN</v-btn
                  >
                </v-col>
              </v-row>
            </v-card>
          </v-col>
        </v-row>
      </div>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
export default {
  methods: {
    userlogin() {
      this.$router.push("/loginuser");
    },
    companylogin() {
      this.$router.push("/LoginCompany");
    }
  }
};
</script>
