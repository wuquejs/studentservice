import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from '../views/Login.vue'
import logs from '../views/logs.vue'
import Edit from '../views/Edit.vue'
import Detali from '../views/Detali.vue'
import Index from '../views/Index.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
        name: 'Index',
        redirect: { name: "Login" }
    },
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/Detali',
        name: 'Detali',
        component: Detali
    },
    {
        path: '/logs/:logsID',
        name: 'Edit',
        component: Edit
    },
    {
        path: '/logs/:logsId/logsid',
        name: 'logs',
        component: logs
    },
    
   
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
