import Vue from 'vue'
import Router from 'vue-router';

import RegisterCompany from '../components/RegisterCompany';
import LoginCompany from '../components/LoginCompany';
import Companychoice from '../components/Companychoice';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: LoginCompany
        },
        {
            path: '/RegisterCompany',
            component: RegisterCompany
        },
        {
            path: '/Companychoice',
            component: Companychoice
        },
    ]
});