<template>
  <v-card class="mx-auto" height="100%" width="100%">
    <v-navigation-drawer
      absolute
      dark
      src="https://images.unsplash.com/photo-1496902526517-c0f2cb8fdb6a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80&fbclid=IwAR1-eUROQcdh14MVvwIBS_gxUrlH5w140NIhIFpJL0QOmh9zlHdksOKrq0Y"
      width="100%"
      permanent
    >
      <br />
      <v-card class="mx-auto" max-width="1000" color="#757575">
        <v-system-bar color="#E0E0E0"></v-system-bar>
        <v-system-bar color="#E0E0E0"></v-system-bar>
        <v-container>
        <v-card class="mx-auto" max-width="400" color="#424242" :elevation="13" dark>
          <v-layout text-center wrap>
            <v-flex mb-4>
              <br />
              <v-toolbar-title>
              <h1 class="display-1 font-weight-bold">JobPost Information</h1>

              </v-toolbar-title>
            </v-flex>
          </v-layout>
          </v-card>

          <v-row justify="center">
            <v-col cols="15" >
              <v-data-table
              loading
                :headers="headers"
                :items="items"
                :items-per-page="5"
                class="elevation-1"
                color="#FFFFFF"
              ></v-data-table>
              <v-col cols="3">
                <br/>
                <v-btn x-medium color="#212121" style="margin-left: 400%;" dark @click="back"><v-icon left>mdi-arrow-left-circle-outline</v-icon>Back</v-btn>
              </v-col>
            </v-col>
          </v-row>
        </v-container>

        <br />
        <v-system-bar color="#E0E0E0"></v-system-bar>
        <v-system-bar color="#E0E0E0"></v-system-bar>
      </v-card>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
import http from "../http-common";
export default {
  data() {
    return {
      headers: [
        {
          align: "left",
          sortable: false,
          value: "JobPost_id"
        },
        { text: "Company", value: "company.name" },
        { text: "Position", value: "position.name" },
        { text: "Educationlevel", value: "educationlevel" },
        { text: "Salary", value: "salary" },
        { text: "Benefit", value: "benefit.name" },
        { text: "Other_details", value: "other_details" },
      ],
      items: []
    };
  },
  methods: {
    getJobPost() {
      http
        .get("/jobPost")
        .then(response => {
          this.items = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    back() {
      this.$router.push("/companychoice");
    }
  },
  mounted() {
    this.getJobPost();
  }
};
</script>