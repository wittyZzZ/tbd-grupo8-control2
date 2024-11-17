<template>
  <v-app>
    <v-app-bar v-if="mostrarNavbar" app>
      <v-app-bar-nav-icon @click="toggleMenuDrawer" />
      <v-toolbar-title>Mis Tareas</v-toolbar-title>
      <v-spacer></v-spacer>

      <v-btn text to="/">Inicio</v-btn>
      <v-btn text to="/homeworks">Tareas</v-btn>

      <v-btn color="primary" @click="logout">Cerrar Sesión</v-btn>
    </v-app-bar>
    <v-content>
      <router-view/>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: 'App',

  data() {
    return {
      menuDrawer: false,
      mostrarNavbar: true,
    };
  },

  methods: {
    toggleMenuDrawer() {
      this.menuDrawer = !this.menuDrawer;
    },
  },




};
</script>
