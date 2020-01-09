<template>
  <v-card class="mx-auto" height="100%" width="100%">
    <v-navigation-drawer
      absolute
      src="https://images.unsplash.com/photo-1484807352052-23338990c6c6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80"
      width="100%"
      parmanent
    >
      >
      <v-container>
        <v-card max-width="350" class="mx-auto" color="#424242" :elevation="13" dark >
              <v-row justify="center">
                <v-toolbar-title>
                  <h1 class="font-weight" dark>ใบสมัครงาน</h1>
                </v-toolbar-title>
              </v-row>
            </v-card>
            <br>
            <v-card max-width="900" class="mx-auto" color="#EEEEEE" :elevation="7">

          <v-row>
            <v-col cols="15">
              <v-form>
                <v-row style="height: 75px;" justify="center">
                  <v-col cols="3" sm="5">
                    <v-text-field
                      label="Name"
                      v-model="addjob.name"
                      prepend-icon="mdi-account"
                      color="#42A5F5"
                      class="font-weight-bold"
                      :rules="[(v) => !!v || 'Name is required']"
                      placeholder
                      filied
                      loading
                      clearable
                      outlined
                    ></v-text-field>
                  </v-col>

                  <v-col cols="3" sm="5">
                    <v-select
                      :items="genders"
                      v-model="addjob.gender"
                      item-text="name"
                      item-value="id"
                      label="Gender"
                      prepend-icon="mdi-account"
                      class="font-weight-bold"
                      :rules="[(v) => !!v || 'Gender is required']"
                      outlined
                      loading
                      color="#1E88E5"
                    ></v-select>
                  </v-col> </v-row
                ><br />

                <v-row style="height: 75px;" justify="center">
                  <v-col cols="3" sm="5">
                    <v-text-field
                      label="Phone"
                      v-model="addjob.phone"
                      prepend-icon="mdi-phone"
                      color="#42A5F5"
                      class="font-weight-bold"
                      :rules="[(v) => !!v || 'Phone is required']"
                      placeholder
                      filied
                      loading
                      clearable
                      outlined
                    ></v-text-field>
                  </v-col>

                  <v-col cols="3" sm="5">
                    <v-text-field
                      label="Education"
                      v-model="addjob.education"
                      prepend-icon="mdi-domain"
                      color="#42A5F5"
                      class="font-weight-bold"
                      :rules="[(v) => !!v || 'Education is required']"
                      placeholder
                      filied
                      loading
                      clearable
                      outlined
                    ></v-text-field>
                  </v-col> </v-row
                ><br />

                <v-row style="height: 75px;" justify="center">
                  <v-col cols="3" sm="5">
                    <v-select
                      :items="positions"
                      v-model="addjob.position"
                      item-text="name"
                      item-value="id"
                      label="Position"
                      prepend-icon="mdi-worker"
                      class="font-weight-bold"
                      :rules="[(v) => !!v || 'Position is required']"
                      outlined
                      loading
                      color="#1E88E5"
                    ></v-select>
                  </v-col>

                  <v-col cols="3" sm="5">
                    <v-select
                      :items="informations"
                      v-model="addjob.information"
                      item-text="information_type"
                      item-value="id"
                      label="Source of Information"
                      :rules="[(v) => !!v || 'Source is required']"
                      prepend-icon="mdi-email"
                      class="font-weight-bold"
                      outlined
                      loading
                      color="#1E88E5"
                    ></v-select>
                  </v-col> </v-row
                ><br />

                <v-row style="height: 150px;" justify="center">
                  <v-col cols="3" md="8">
                    <v-textarea
                      label="Introduce yourself"
                      v-model="addjob.introduction"
                      color="#42A5F5"
                      class="font-weight-bold"
                      :rules="[(v) => !!v || 'Introduce is required']"
                      placeholder
                      filied
                      loading
                      clearable
                      outlined
                    ></v-textarea>
                  </v-col>
                </v-row>

                <v-row style="height: 75px;" justify="center">
                  <v-col cols="12">
                    <v-btn
                      style="margin-left: 350px;"
                      color="red"
                      @click="saveAddjob"
                      :elevation="7"
                      >save</v-btn
                    >
                    <v-btn
                      style="margin-left: 100px;"
                      :class="{gray: !valid, black: valid}"
                      @click="back"
                      :elevation="7"
                      >BACK</v-btn
                    >
                  </v-col>
                </v-row>
              </v-form>
            </v-col>
          </v-row>
        </v-card>
      </v-container>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
import http from "../http-common";
export default {
  name: "addjob",
  data() {
    return {
      addjob: {
        information: undefined,
        position: undefined,
        gender: undefined,
        name: undefined,
        phone: undefined,
        education: undefined,
        introduction: undefined
      },
      addjobs: undefined,
      informations: [],
      positions: [],
      genders: []
    };
  },
  methods: {
    getInformations() {
      http
        .get("/information")
        .then(response => {
          this.informations = response.data;
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

    getPositions() {
      http
        .get("/position")
        .then(response => {
          this.positions = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    saveAddjob() {
      if (
        !this.addjob.gender ||
        !this.addjob.information ||
        !this.addjob.position ||
        !this.addjob.name ||
        !this.addjob.phone ||
        !this.addjob.education ||
        !this.addjob.introduction
      ) {
        alert("ใส่ข้อมูลไม่ครบถ้วน");
      } else {
        http
          .post(
            "/addjob/" +
              this.addjob.name +
              "/" +
              this.addjob.gender +
              "/" +
              this.addjob.phone +
              "/" +
              this.addjob.education +
              "/" +
              this.addjob.position +
              "/" +
              this.addjob.information +
              "/" +
              this.addjob.introduction,
            this.addjob
          )
          .then(response => {
            console.log(response);
            this.$router.push("/addjob");
          })
          .catch(e => {
            console.log(e);
          });
        this.submitted = true;
        alert("บันทึกเรียบร้อย");
      }
    },
    back() {
      this.$router.push("/loginuser");
    },
    refreshList() {
      this.getInformations();
      this.getGenders();
      this.getPositions();
    }
  },
  mounted() {
    this.getInformations();
    this.getGenders();
    this.getPositions();
  }
};
</script>
