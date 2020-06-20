<template>
  <div>
    <v-app-bar
        dense
        height="66"
        class="flex-grow-0"
    >

      <v-app-bar-nav-icon
          class="hidden-md-and-up"
          @click="drawer = true"
      ></v-app-bar-nav-icon>

      <v-toolbar-title>
        <router-link to="/">
          OH MY BLOG
        </router-link>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <div class="hidden-sm-and-down" v-if="showMenu">
        <v-btn
            v-for="(item, index) in mainMenuList"
            :key="index"
            :to="{path: item.path}"
            text
            >
          {{ item.title }}
        </v-btn>
      </div>

      <v-btn icon color="black">
        <v-icon>mdi-message-processing</v-icon>
      </v-btn>

      <v-btn v-if="!currentUser" icon color="black"
             :to="{name: 'login'}"
      >
        <v-icon>mdi-login-variant</v-icon>
      </v-btn>

      <div v-if="currentUser">
        <router-link :to="{name: 'profile'}">Профиль</router-link>
        <v-btn icon color="black" @click="logOut">
          <v-icon>mdi-logout-variant</v-icon>
        </v-btn>
      </div>

    </v-app-bar>

    <v-navigation-drawer
        v-model="drawer"
        fixed
        temporary
    >

      <v-list
          nav
          dense
          v-if="showMenu"
      >
        <v-list-item v-for="(item, index) in mainMenuList" :key="index" :to="item.path" link>
          <v-list-item-content>
            <v-list-item-title
            >
              {{ item.title }}
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>

    </v-navigation-drawer>
  </div>
</template>

<script>
export default {
  name: 'Toolbar',
  data: () => ({
    drawer: false,
    mainMenuList: [
      new menuItem('Лента', '/news'),
      new menuItem('Статьи', '/articles'),
      new menuItem('Запросы', '/requests'),
      new menuItem('Достижения', '/achievements'),
    ],
  }),
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }

      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_MODERATOR');
      }

      return false;
    },
    showMenu() {
      return (this.currentUser || this.showAdminBoard || this.showModeratorBoard);
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
}
class menuItem {
  constructor(title, path) {
    this.title = title;
    this.path = path;
  }
}
</script>