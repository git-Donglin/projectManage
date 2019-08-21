import Vue from 'vue'
import Router from 'vue-router'
import User from '@/components/User.vue'
import putUser from '@/components/putUser.vue'
import home from '@/components/home.vue'
import dept from '@/components/Dept.vue'
import saveUser from '@/components/saveUser.vue'
import Function from '@/components/Function.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: home
    },
    {
      path: '/user',
      name: 'User',
      component: User
    },
    {
      path: '/putUser',
      name: 'putUser',
      component: putUser
    },
    {
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/saveUser',
      name: 'saveUser',
      component: saveUser
    },
    {
      path: '/dept',
      name: 'dept',
      component: dept
    },
    {
      path: '/Function',
      name: 'Function',
      component: Function
    }
  ]
})
