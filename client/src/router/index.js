import Vue from "vue";
import Router from "vue-router";
import Addjob from "../components/Addjob";
import Home from "../components/Home";
import Registeruser from "../components/Registeruser";
import LoginUser from "../components/LoginUser";
import Userchoice from "../components/Userchoice";
import LoginCompany from "../components/LoginCompany";
import RegisterCompany from "../components/RegisterCompany";
import Companychoice from "../components/Companychoice";
import JobPost from "../components/JobPost";
import ShowInfo from "../components/ShowInfo";
import SearchUser from "../components/SearchUser";
import CompanyInformation from "../components/CompanyInformation";
import JobPostInformation from "../components/JobPostInformation";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    
    {
      path: "/home",
      component: Home
    },
    {
      path: "/addjob",
      component: Addjob
    },
    {
        path: '/loginuser',
        component: LoginUser
    },
    {
      path: "/registeruser",
      component: Registeruser
    },
    {
        path: "/userchoice",
        component: Userchoice
    },
    {
      path: "/logincompany",
      component: LoginCompany
    },
    {
      path: "/registercompany",
      component: RegisterCompany 
    },
    {
      path: "/companychoice",
      component: Companychoice 
    },
    {
      path: "/jobpost",
      component: JobPost 
    },
    {
      path: "/showinfo",
      component: ShowInfo 
    },
    {
      path: "/jobpostinformation",
      component: JobPostInformation
    },
    {
      path: "/SearchUser",
      component: SearchUser
    },
    {
      path: "/Companyinformation",
      component: CompanyInformation
    },
    
  ]
});
