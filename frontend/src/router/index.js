import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";

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
            path: "/login",
            name: "login",
            component: Login
        },
        {
            path: "/registration",
            name: "register",
            component: Register
        },
        {
            path: "/profile",
            name: "profile",
            component: () => import('../views/Profile.vue')
        },
        {
            path: "/requests",
            name: "requests",
            component: () => import('../views/Request.vue')
        }
    ]
});