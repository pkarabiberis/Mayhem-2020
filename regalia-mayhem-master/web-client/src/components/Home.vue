<template>
  <v-container>
    <p class="display-3 text-center">Select location</p>
    <hr />
    <div class="mt-10" />
    <v-row justify="center">
      <v-progress-circular v-if="loading" indeterminate color="primary"></v-progress-circular>
    </v-row>
    <v-row v-for="loc in locations" :key="loc.id" justify="center">
      <v-col cols="2">
        <v-card>
          <v-card-title>
            {{ loc }}
            <v-spacer></v-spacer>
            <router-link tag="span" :to="{ name: loc.toLowerCase() }">
              <v-icon>mdi-arrow-right-bold</v-icon>
            </router-link>
          </v-card-title>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { firebase } from '../firebase';
export default {
  name: 'Home',

  data: () => ({
    locations: [],
    loading: false
  }),
  mounted() {
    this.loading = true;
    firebase
      .firestore()
      .collection('Locations')
      .get()
      .then(snapshot => snapshot.docs.map(loc => this.locations.push(loc.id)))
      .then(() => (this.loading = false));

    firebase
      .auth()
      .signInWithEmailAndPassword('admin@regalia.com', 'regalia')
      .then(() => {
        console.log('success');
      })
      .catch(err => console.log(err));
  }
};
</script>
