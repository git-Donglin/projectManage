import Vue from 'vue'
import Router from 'vue-router'
import User from '@/components/User.vue'
import putUser from '@/components/putUser.vue'
import home from '@/components/home.vue'
import dept from '@/components/Dept.vue'
import saveUser from '@/components/saveUser.vue'
import Function from '@/components/Function.vue'
import login from '@/components/login/login.vue'
Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    // {
    //   path: '/',
    //   name: 'home',
    //   component: home
    // },
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

// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆 localStorage.getItem('Authorization') == undefined
router.beforeEach((to, from, next) => {
  if (to.path === '/login') {
    next()
  } else {
    let token = localStorage.getItem('Authorization')
    if (token === 'null' || token === '') {
      next('/login')
    } else {
      next()
    }
  }
})
export default router
