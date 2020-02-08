<template>
  <v-card class="mx-auto" height="100%" width="100%">
    <v-navigation-drawer
      absolute
      dark
      src="https://images.unsplash.com/photo-1579388642426-fa20f2f6f967?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1189&q=80"
      width="100%"
      permanent
    >
      <br />
      <v-card class="mx-auto" max-width="1000" color="#757575">
        <v-system-bar color="#E0E0E0"></v-system-bar>
        <v-system-bar color="#E0E0E0"></v-system-bar>
        <v-container>
        <v-card class="mx-auto" max-width="420" color="#424242" :elevation="7" dark>
          <v-row justify="center">
              <br><br>
              <v-toolbar-title>
                <h1 class="display-1 font-weight-bold" font-weight-regular >Company Information</h1>
              </v-toolbar-title>
          </v-row>
        </v-card>

          <v-row justify="center">
            <v-col cols="15" >
              <v-data-table
                :headers="headers"
                :items="items"
                :items-per-page="5"
                loading
                class="elevation-1"
                color=""
              ></v-data-table>
              <v-col cols="3">
                <br/>
                <v-btn x-medium color="#212121" style="margin-left: 380%;" dark @click="back"><v-icon left>mdi-arrow-left-circle-outline</v-icon>Back</v-btn>
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
          value: "Company_id"
        },
        { text: "Company Name", value: "name" },
        { text: "Company Size", value: "size.name" },
        { text: "Company Type", value: "type.name" },
        { text: "Province", value: "province.name" },
        { text: "Email", value: "email" },
      ],
      items: []
    };
  },
  methods: {
    getCompany() {
      http
        .get("/company")
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
    this.getCompany();
  }
};
</script>