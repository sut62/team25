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
          <v-layout text-center wrap>
            <v-flex mb-4>
              <br />
              <h1 class="display-2 font-weight-bold mb-3">Show Info</h1>
            </v-flex>
          </v-layout>

          <v-row justify="center">
            <v-col cols="15" color="#FFFFFF">
              <v-data-table
                :headers="headers"
                :items="items"
                :items-per-page="5"
                class="elevation-1"
                
              ></v-data-table>
              <v-col cols="3">
                <br/>
                <v-btn x-medium color="#212121" style="margin-left: 400%;" dark @click="back">Back</v-btn>
              </v-col>
            </v-col>
          </v-row>
          <div v-if="alret1">
            <v-alret type="success">พบข้อมูลที่บันทึก</v-alret>
          </div>
          <div v-else-if="!alret1">
            <v-alret type="error">ไม่พบข้อมูลที่บันทึก</v-alret>
          </div>
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
          value: "Addjob_id"
        },
        { text: "Name", value: "name" },
        { text: "Gender", value: "gender.name" },
        { text: "Phone", value: "phone" },
        { text: "Education", value: "education" },
        { text: "Position", value: "position.name" },
        { text: "Source of Information", value: "information.information_type" },
        { text: "Introduction", value: "introduction" },
      ],
      items: []
    };
  },
  methods: {
    getAddjob() {
      http
        .get("/addjob")
        .then(response => {
          this.items = response.data;
          console.log(response.data);
          if (response.data != "") {
            this.items = response.data;
            this.alret1 = true;
            console.log(response.data);
            console.log("++++++++++++++");
            console.log("true");
          }else{
            this.alrat1 = false;
            console.log("false");
          }
        })
        .catch(e => {
          console.log(e);
          this.alert1 = "false";
        });
    },
    back() {
      this.$router.push("/userchoice");
    }
  },
  mounted() {
    this.getAddjob();
  }
};
</script>