<template>
  <v-container>
    <router-link tag="span" :to="{ name: 'luosto' }">
      <v-btn x-small>back to sports</v-btn>
    </router-link>
    <p class="display-3 text-center">
      {{
      this.$route.params.name
      .split('-')
      .join(' ')
      .toUpperCase()
      }}
    </p>
    <v-row justify="center">
      <p class="display-2 text-center">{{startTime}} - {{endTime}}</p>
      <v-dialog v-model="timeEditDialog" max-width="500px">
        <template v-slot:activator="{ on }">
          <v-icon v-on="on" class="pa-2" color="black">mdi-pencil</v-icon>
        </template>
        <v-card>
          <v-card-text>
            <v-container>
              <v-row justify="center">
                <v-col cols="6">
                  <v-text-field label="Starting time" v-model="startTime" required></v-text-field>
                  <v-text-field label="Ending time" v-model="endTime" required></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="blue darken-1" text @click="editTime(startTime, endTime)">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
    <hr />
    <div class="mt-10" />

    <v-row justify="center">
      <v-col cols="6">
        <v-simple-table v-if="results.length">
          <template v-slot:default>
            <thead>
              <tr>
                <th class="text-left">Position</th>
                <th class="text-left">Name</th>
                <th class="text-left">Best time</th>
                <th class="text-left">Sponsor</th>
                <th class="text-left">Club</th>
                <th class="text-left">Athlete Number</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(result, i) in results" :key="result.id">
                <td>{{ i+1 + "."}}</td>
                <td>{{ result.name }}</td>
                <td>{{ result.time }}</td>
                <td>{{ result.sponsor }}</td>
                <td>{{ result.club }}</td>
                <td>{{ result.number }}</td>
                <v-icon class="mt-2 mr-2" @click="getContent(result.id)">mdi-pencil</v-icon>
                <v-icon class="mt-2 mx-2" @click="deleteResult(result.id)" color="red">mdi-delete</v-icon>
              </tr>
            </tbody>
          </template>
        </v-simple-table>
        <div v-else>
          <p class="text-center">No results</p>
        </div>
      </v-col>
    </v-row>

    <v-row justify="center">
      <v-dialog v-model="dialog" max-width="500px">
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on">Add results</v-btn>
        </template>
        <v-card>
          <v-card-text>
            <v-container>
              <v-row justify="center">
                <v-col cols="6">
                  <v-text-field label="Name" v-model="name" required></v-text-field>
                  <v-text-field label="Time (00:00)" v-model="time" required></v-text-field>
                  <v-text-field label="Sponsor" v-model="sponsor" required></v-text-field>
                  <v-text-field label="Club" v-model="club" required></v-text-field>
                  <v-text-field label="Athlete number" v-model="number" required></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
              color="blue darken-1"
              text
              @click="addResult(name, time, sponsor, club, number, testeriId)"
            >Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
      <v-dialog v-model="editDialog" max-width="500px">
        <v-card>
          <v-card-text>
            <v-container>
              <v-row justify="center">
                <v-col cols="6">
                  <v-text-field label="Name" v-model="newName" required></v-text-field>
                  <v-text-field label="Time" v-model="newTime" required></v-text-field>
                  <v-text-field label="Sponsor" v-model="newSponsor"></v-text-field>
                  <v-text-field label="Club" v-model="newClub"></v-text-field>
                  <v-text-field label="Athlete number" v-model="newNumber"></v-text-field>
                </v-col>
              </v-row>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-btn
              text
              @click="editContent(newName, newTime, newSponsor, newClub, newNumber, testeriId)"
            >Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </v-container>
</template>

<script>
import { firebase } from '../firebase';
export default {
  data: () => ({
    results: [],
    dialog: false,
    editDialog: false,
    timeEditDialog: false,
    name: null,
    time: null,
    sponsor: null,
    club: null,
    number: null,
    newName: null,
    newTime: null,
    newSponsor: null,
    newClub: null,
    newNumber: null,
    startTime: null,
    endTime: null,
    testeriId: null
  }),
  mounted() {
    let sportName = this.$route.params.name;

    let ref = firebase
      .firestore()
      .collection('Locations')
      .doc('Luosto')
      .collection('Sports')
      .doc(sportName)
      .collection('results')
      .orderBy('time', 'asc');

    ref.onSnapshot(res => {
      const changes = res.docChanges();

      changes.forEach(change => {
        if (change.type === 'added') {
          this.results.push({
            ...change.doc.data(),
            id: change.doc.id
          });
        }
        if (change.type === 'modified') {
          this.results = this.results.filter(
            result => result.id !== change.doc.id
          );
          this.results.push({
            ...change.doc.data(),
            id: change.doc.id
          });
        }
        this.results = this.results.sort((a, b) =>
          a.time > b.time ? 1 : b.time > a.time ? -1 : 0
        );
      });
    });

    firebase
      .firestore()
      .collection('Locations')
      .doc('Luosto')
      .collection('Timetables')
      .doc(sportName)
      .onSnapshot(doc => {
        this.startTime = doc.data().startTime;
        this.endTime = doc.data().endTime;
      });
  },
  methods: {
    addResult(name, time, sponsor, club, number) {
      let sportName = this.$route.params.name;

      firebase
        .firestore()
        .collection('Locations')
        .doc('Luosto')
        .collection('Sports')
        .doc(sportName)
        .collection('results')
        .add({
          name,
          time,
          sponsor,
          club,
          number
        })
        .then(() => {
          this.name = null;
          this.time = null;
          this.sponsor = null;
          this.club = null;
          this.number = null;
        })
        .catch(err => console.log(err));
    },
    deleteResult(id) {
      let sportName = this.$route.params.name;

      firebase
        .firestore()
        .collection('Locations')
        .doc('Luosto')
        .collection('Sports')
        .doc(sportName)
        .collection('results')
        .doc(id)
        .delete()
        .then(() => {
          console.log('deleted');
          this.results = this.results.filter(result => result.id !== id);
        });
    },
    editTime(startTime, endTime) {
      let sportName = this.$route.params.name;
      let sportNameFixed = sportName
        .split('-')
        .join(' ')
        .toUpperCase();

      const toTitleCase = phrase => {
        return phrase
          .toLowerCase()
          .split(' ')
          .map(word => word.charAt(0).toUpperCase() + word.slice(1))
          .join(' ');
      };

      let properSportName = toTitleCase(sportNameFixed);

      firebase
        .firestore()
        .collection('Locations')
        .doc('Luosto')
        .collection('Timetables')
        .doc(sportName)
        .set({
          content: properSportName,
          startTime,
          endTime
        })
        .then(() => {
          console.log('success');
        });
    },
    getContent(id) {
      let sportName = this.$route.params.name;
      this.editDialog = !this.editDialog;

      firebase
        .firestore()
        .collection('Locations')
        .doc('Luosto')
        .collection('Sports')
        .doc(sportName)
        .collection('results')
        .doc(id)
        .get()
        .then(doc => {
          if (doc.exists) {
            const { name, time, sponsor, club, number } = doc.data();
            this.newName = name;
            this.newTime = time;
            this.newSponsor = sponsor;
            this.newClub = club;
            this.newNumber = number;
            this.testeriId = doc.id;
          } else {
            console.log('Nope');
          }
        });
    },
    editContent(name, time, sponsor, club, number, id) {
      let sportName = this.$route.params.name;

      firebase
        .firestore()
        .collection('Locations')
        .doc('Luosto')
        .collection('Sports')
        .doc(sportName)
        .collection('results')
        .doc(id)
        .update({
          name,
          time,
          sponsor,
          club,
          number
        })
        .then(() => console.log('ok'));
    }
  }
};
</script>

<style></style>
