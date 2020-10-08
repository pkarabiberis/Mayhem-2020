<template>
  <v-container>
    <v-row>
      <v-col cols="12">
        <router-link tag="span" :to="{ name: 'Home' }">
          <v-btn color="white" x-small>home</v-btn>
        </router-link>
        <p class="display-3 text-center">Ylläs</p>
        <hr />
      </v-col>
    </v-row>

    <div class="mt-10" />
    <v-row>
      <v-col v-for="sport in sports" :key="sport.id" cols="4">
        <v-card v-if="sports.length">
          <div class="text-center">
            <v-card-title class="justify-center">
              <p class="font-weight-black my-5">{{ sport.name }}</p>
            </v-card-title>
            <v-img :src="sport.img"></v-img>
            <v-card-text>
              <router-link
                tag="span"
                :to="{
                  name: 'resultsyllas',
                  params: {
                    name: sport.name
                      .split(' ')
                      .join('-')
                      .toLowerCase()
                  }
                }"
              >
                <v-btn color="white" small>Go to results</v-btn>
              </router-link>
            </v-card-text>
          </div>
        </v-card>
      </v-col>
      <v-col cols="4">
        <v-card>
          <div>
            <v-card-title class="justify-center">
              <p class="font-weight-black my-5">Timetables</p>
            </v-card-title>
            <hr width="90%" style="margin: auto;" />
            <v-list class="transparent">
              <v-list-item v-for="time in timetables" :key="time.id">
                <v-list-item-title class="ml-4">
                  {{ time.content }} -
                  <p>{{ time.day }}</p>
                </v-list-item-title>
                <v-list-item-subtitle class="text-right mx-10">
                  {{ time.startTime }} - {{ time.endTime }}
                  <v-icon @click="getContent(time.id)" class="mx-2">mdi-pencil</v-icon>
                  <v-icon color="red" @click="deleteFromList(time.id)" class="mx-2">mdi-delete</v-icon>
                </v-list-item-subtitle>
              </v-list-item>
            </v-list>
            <v-card-text>
              <v-row justify="center">
                <v-dialog v-model="dialog" max-width="500px">
                  <template v-slot:activator="{ on }">
                    <v-btn v-on="on">Add</v-btn>
                  </template>
                  <v-card>
                    <v-card-text>
                      <v-container>
                        <v-row justify="center">
                          <v-col cols="6">
                            <v-text-field label="Content" v-model="content" required></v-text-field>
                            <v-text-field label="Starting time" v-model="start" required></v-text-field>
                            <v-text-field label="Ending time" v-model="end"></v-text-field>
                            <v-text-field label="Day (thur, fri, sat)" v-model="contentDay"></v-text-field>
                          </v-col>
                        </v-row>
                      </v-container>
                    </v-card-text>
                    <v-card-actions>
                      <v-btn text @click="addContent(content, start, end, contentDay)">Save</v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
                <v-dialog v-model="editDialog" max-width="500px">
                  <v-card>
                    <v-card-text>
                      <v-container>
                        <v-row justify="center">
                          <v-col cols="6">
                            <v-text-field label="Content" v-model="newContent" required></v-text-field>
                            <v-text-field label="Starting time" v-model="newStartTime" required></v-text-field>
                            <v-text-field label="Ending time" v-model="newEndTime"></v-text-field>
                            <v-text-field label="Day (thur, fri, sat)" v-model="newContentDay"></v-text-field>
                          </v-col>
                        </v-row>
                      </v-container>
                    </v-card-text>
                    <v-card-actions>
                      <v-btn
                        text
                        @click="editContent(newContent, newStartTime, newEndTime, newContentDay, testeriId)"
                      >Save</v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
              </v-row>
            </v-card-text>
          </div>
        </v-card>
        <p v-if="info" class="mt-10" style="color:red; font-size:40px;">{{ info }}</p>
        <v-icon color="black" @click="infoDialog = !infoDialog" class="mx-2 mt-2">mdi-pencil</v-icon>
        <v-dialog v-model="infoDialog" max-width="500px">
          <v-card>
            <v-card-text>
              <v-container>
                <v-row justify="center">
                  <v-col cols="12">
                    <v-text-field outlined v-model="info"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>
            <v-card-actions>
              <v-btn text @click="editInfo(info)">Save</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { firebase } from '../firebase';

export default {
  data: () => ({
    sports: [
      {
        name: 'Fatbike Challenge',
        img: require('../../public/images/fatbike-challenge.jpeg')
      },
      {
        name: 'Scott Hillclimb Series',
        img: require('../../public/images/scott_hillclimb_mayhem.jpeg')
      },
      {
        name: 'Hillcross Series',
        img: require('../../public/images/hillcross_series_mayhem.jpeg')
      },
      {
        name: 'X Country Ski Hillclimb',
        img: require('../../public/images/xcountry_hc.jpeg')
      },
      {
        name: 'Banked Slalom XL',
        img: require('../../public/images/banked-slalom.jpeg')
      },
      {
        name: 'Motul Snowcross',
        img: require('../../public/images/motul_snowcross.jpeg')
      },
      {
        name: 'Motul Vintage Snowcross',
        img: require('../../public/images/snowcross_vintage.jpeg')
      },
      {
        name: 'Ski Slopestyle',
        img: require('../../public/images/ski_slopestyle_mayhem.jpeg')
      },
      {
        name: 'Snowboard Slopestyle',
        img: require('../../public/images/snowboard_slopestyle_mayhem.jpeg')
      },
      {
        name: 'Snake Rail',
        img: require('../../public/images/snake_rail.jpeg')
      },
      {
        name: 'Pimp My Pulkka',
        img: require('../../public/images/pimp.jpeg')
      },
      {
        name: 'Pool Crossing',
        img: require('../../public/images/pool.jpeg')
      }
    ],
    timetables: [],
    content: null,
    start: null,
    end: null,
    contentDay: null,
    dialog: false,
    editDialog: false,
    newContent: null,
    newStartTime: null,
    newEndTime: null,
    newContentDay: null,
    testeriId: null,
    infoDialog: false,
    info: ''
  }),
  mounted() {
    firebase
      .firestore()
      .collection('Locations')
      .doc('Ylläs')
      .collection('Timetables')
      .orderBy('startTime', 'asc')
      .onSnapshot(res => {
        const changes = res.docChanges();

        changes.forEach(change => {
          if (change.type === 'added') {
            this.timetables.push({
              ...change.doc.data(),
              id: change.doc.id
            });
          }
        });
      });

    firebase
      .firestore()
      .collection('Locations')
      .doc('Ylläs')
      .collection('Timetables')
      .doc('info')
      .get()
      .then(doc => {
        if (doc.exists) {
          this.info = doc.data().infoText;
        } else {
          this.info = 'No info found';
        }
      });
  },
  methods: {
    addContent(content, start, end, day) {
      let contentFormatted = content
        .split(' ')
        .join('-')
        .toLowerCase();

      firebase
        .firestore()
        .collection('Locations')
        .doc('Ylläs')
        .collection('Timetables')
        .doc(contentFormatted)
        .set({
          content,
          startTime: start,
          endTime: end,
          day
        })
        .then(() => {
          console.log('ok');
          this.content = null;
          this.start = null;
          this.end = null;
        });
    },
    deleteFromList(id) {
      firebase
        .firestore()
        .collection('Locations')
        .doc('Ylläs')
        .collection('Timetables')
        .doc(id)
        .delete()
        .then(() => {
          this.timetables = this.timetables.filter(
            content => content.id !== id
          );
        });
    },
    getContent(id) {
      this.editDialog = !this.editDialog;

      firebase
        .firestore()
        .collection('Locations')
        .doc('Ylläs')
        .collection('Timetables')
        .doc(id)
        .get()
        .then(doc => {
          if (doc.exists) {
            const { content, startTime, endTime, day } = doc.data();
            this.newContent = content;
            this.newStartTime = startTime;
            this.newEndTime = endTime;
            this.newContentDay = day;
            this.testeriId = doc.id;
          } else {
            console.log('Nope');
          }
        });
    },
    editContent(content, startTime, endTime, day, id) {
      firebase
        .firestore()
        .collection('Locations')
        .doc('Ylläs')
        .collection('Timetables')
        .doc(id)
        .update({
          content,
          startTime,
          endTime,
          day
        })
        .then(() => console.log('ok'));
    },
    editInfo(info) {
      info === '' ? (info = null) : (info = info);
      firebase
        .firestore()
        .collection('Locations')
        .doc('Ylläs')
        .collection('Timetables')
        .doc('info')
        .set({
          infoText: info
        })
        .then(() => console.log('ok'));
    }
  }
};
</script>

<style scoped>
p {
  font-size: 24px;
}
</style>

