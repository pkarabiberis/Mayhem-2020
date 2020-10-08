<template>
  <v-app>
    <v-content>
      <v-container>
        <router-view />
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import Home from './components/Home';
import Luosto from './components/Luosto';
import Olos from './components/Olos';
import Yllas from './components/Yllas';
import ResultsOlos from './components/ResultsOlos';
import ResultsLuosto from './components/ResultsLuosto';
import ResultsYllas from './components/ResultsYllas';

export default {
  name: 'App',

  components: {
    Home,
    Luosto,
    Olos,
    Yllas,
    ResultsOlos,
    ResultsLuosto,
    ResultsYllas
  },

  data: () => ({
    //
  })
};
</script>
