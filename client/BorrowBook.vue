<template>
  <v-app id="inspire">
    <v-app-bar app clipped-right color="#00838F" dark>
      <v-toolbar-title>
        <h1>Borrow Books</h1>
      </v-toolbar-title>
      <v-spacer></v-spacer>
    </v-app-bar>
    <v-content>
      <v-card max-width="600" class="mx-auto" color="ffffff">
        <v-container fluid>
          <v-row>
            <v-col cols="12">
              <v-select
                label="Member"
                prepend-icon="person"
                v-model="borrow.member"
                :items="members"
                item-text="name"
                item-value="id"
                outlined
                dense
              ></v-select>
            </v-col>
            <v-col cols="12">
              <v-select
                label="Book"
                prepend-icon="book"
                v-model="borrow.book"
                :items="books"
                item-text="book_name"
                item-value="id"
                outlined
                dense
              ></v-select>
            </v-col>
            <v-col cols="12">
              <v-select
                label="Borrow Type"
                prepend-icon="message"
                v-model="borrow.borrow_type"
                :items="borrowtypes"
                item-text="borrow_type"
                item-value="id"
                outlined
                dense
              ></v-select>
            </v-col>
            <v-col cols="12">
              <v-select
                v-model="borrow.employee"
                outlined
                :counter="max"
                :items="employees"
                item-text="emp_name"
                item-value="id"
                label="Employee"
                color="blue"
                prepend-icon="person"
              ></v-select>
            </v-col>
          </v-row>
        </v-container>

        <v-card-actions color="#00838F">
          <v-btn @click="saveBorrow" block color="#00838F" dark>save</v-btn>
        </v-card-actions>

        <v-card-actions color="#00838F">
          <v-btn @click="clear" block color="#CD0000" dark>clear</v-btn>
        </v-card-actions>
<v-layout text-center wrap>
      <v-flex mb-5>
        <br />
        <h1 class="display-2 font-weight-bold mb-3">Borrow Information</h1>
      </v-flex>
    </v-layout>

    <v-row justify="center">
      <v-col cols="15">
        <v-data-table :headers="headers" :items="items" :items-per-page="5" class="elevation-1"></v-data-table>
      </v-col>
    </v-row>
      </v-card>
    </v-content>

    <v-navigation-drawer v-model="right" fixed right temporary></v-navigation-drawer>

    <v-footer app color="#00838F" class="white--text">
      <span></span>
      <v-spacer></v-spacer>
      <span>&copy;</span>
    </v-footer>
  </v-app>
</template>

<script>
import http from "../http-common";

export default {
  name: "borrow",
  data() {
    return {
      borrow: {
        employee: undefined,
        member: undefined,
        book: undefined,
        borrow_type: undefined
      },
      employees: [],
      members: [],
      books: [],
      borrowtypes: [],

      length: undefined,
      right: undefined,
      max: undefined,
      valid: false,
      memberCheck: false,
      memberName: undefined,
      headers: [
        {
          text: "Member Name",
          align: "center",
          sortable: false,
          value: "member.name"
        },
        {
          text: "Member ID",
          align: "lelft",
          sortable: false,
          value: "member.id"
        },
        { text: "Book", align: "center", sortable: false, value: "book.book_name" },
        {
          text: "Employee",
          align: "center",
          sortable: false,
          value: "employee.emp_name"
        },
        {
          text: "Borrow Type",
          align: "center",
          sortable: false,
          value: "borrowType.borrow_type"
        },
         { text: "Date", align: "center", sortable: false, value: "borrowdate" }
      ],
      items: []
      
    };
  },
  methods: {
    getBorrows() {
      http
        .get("/borrow")
        .then(response => {
          this.items = response.data;
          console.log(this.items);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.getBorrows();
    },
    getEmployees() {
      http
        .get("/employee")
        .then(response => {
          this.employees = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getMembers() {
      http
        .get("/member")
        .then(response => {
          this.members = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    getBooks() {
      http
        .get("/book")
        .then(response => {
          this.books = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    getBorrowTypes() {
      http
        .get("/borrowtype")
        .then(response => {
          this.borrowtypes = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    saveBorrow() {
      if (
        !this.borrow.member ||
        !this.borrow.book ||
        !this.borrow.borrow_type ||
        !this.borrow.employee
      ) {
        alert("ใส่ข้อมูลไม่ครบถ้วน");
      } else {
        alert("บันทึกเรียบร้อย");

        http
          .post(
            "/borrow/" +
              this.borrow.member +
              "/" +
              this.borrow.book +
              "/" +
              this.borrow.borrow_type +
              "/" +
              this.borrow.employee
          )
          .then(response => {
            console.log(response);
          })
          .catch(e => {
            console.log(e);
          });
        this.submitted = true;
      }
    },
    clear() {
      this.borrow.member = null;
      this.borrow.book = null;
      this.borrow.borrow_type = null;
      this.borrow.employee = null;
    },
    refreshList() {
      this.getMembers();
      this.getBooks();
      this.getBorrowTypes();
      this.getEmployees();
    }
  },
  mounted() {
    this.getMembers();
    this.getBooks();
    this.getBorrowTypes();
    this.getEmployees();
    this.getBorrows();
  }
};
</script>