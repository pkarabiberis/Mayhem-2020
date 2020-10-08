import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../components/Home';
import Luosto from '../components/Luosto';
import Olos from '../components/Olos';
import Yllas from '../components/Yllas';
import ResultsOlos from '../components/ResultsOlos';
import ResultsLuosto from '../components/ResultsLuosto';
import ResultsYllas from '../components/ResultsYllas';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/luosto',
    name: 'luosto',
    component: Luosto,
  },
  {
    path: '/olos',
    name: 'olos',
    component: Olos,
  },
  {
    path: '/yllas',
    name: 'ylläs',
    component: Yllas,
  },
  {
    path: '/olos/results/:name',
    name: 'resultsolos',
    component: ResultsOlos,
  },
  {
    path: '/luosto/results/:name',
    name: 'resultsluosto',
    component: ResultsLuosto,
  },
  {
    path: '/yllas/results/:name',
    name: 'resultsyllas',
    component: ResultsYllas,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
