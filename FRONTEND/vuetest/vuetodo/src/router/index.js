import { createRouter, createWebHistory } from 'vue-router'
import HelloWorld from '@/components/HelloWorld.vue'
import TestPage from '@/views/TestPage.vue'
import TodoPage from '@/views/TodoPage.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HelloWorld
  },
  {
    path: '/test',
    name: 'test',
    component: TestPage
  },
  {
    path: '/todos',
    name: 'Todos',
    component: TodoPage
    
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
