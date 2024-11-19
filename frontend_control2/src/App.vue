<template>
  <v-app>
    <v-app-bar v-if="mostrarNavbar" app>
      <v-toolbar-title>Mis Tareas</v-toolbar-title>
      <v-spacer></v-spacer>

      <v-btn text to="/">Inicio</v-btn>
      <v-btn text to="/homeworks">Tareas</v-btn>
      
       <!-- Icono de notificaciones con contador -->
       <v-badge
        :content="notificationsCount"
        :color="notificationsCount > 0 ? 'red' : ''"
        overlap
        >
          <v-icon @click="toggleNotificationDrawer">mdi-bell</v-icon>
        </v-badge>
      <v-btn color="primary" @click="logout">Cerrar Sesión</v-btn>
    </v-app-bar>

    <v-navigation-drawer v-model="notificationDrawer" right>
      <v-toolbar>
        <v-toolbar-title style="flex-grow: 4;">Notificaciones</v-toolbar-title>
        <v-spacer></v-spacer>
        <v-btn icon @click="toggleNotificationDrawer">
          <v-icon>mdi-close</v-icon>
        </v-btn>
      </v-toolbar>
      <v-banner-text style="align">Tareas Caducadas!!</v-banner-text>
      <v-divider></v-divider>

      <v-list>
        <v-list-item
          v-for="(tarea, index) in tareasCaducadas"
          :key="index"
        >

            <v-list-item-title>{{ tarea.titulo }}</v-list-item-title>
            <v-list-item-subtitle>{{ tarea.descripcion }}</v-list-item-subtitle>

        </v-list-item>
      </v-list>
    </v-navigation-drawer>

  
    <router-view/>

  </v-app>
</template>

<script>
import taskService from "@/services/task.service";
import { jwtDecode } from "jwt-decode";

export default {
  name: 'App',

  data() {
    return {
      notificationDrawer: false,
      mostrarNavbar: true,
      tareasCaducadas: [],
      interval: null,
    };
  },

  computed: {
    notificationsCount() {
      return this.tareasCaducadas.length;
    },
  },
  watch: {
    $route(to) {
      this.mostrarNavbar = !["Login", "Register"].includes(to.name);
    },
  },
  mounted() {
    this.mostrarNavbar = !["Login", "Register"].includes(this.$route.name);

    const token = localStorage.getItem("token");
    if (token) {
      const decodedToken = jwtDecode(token);
      this.user = decodedToken;
      this.obtenerTareasCaducadas();

      this.interval = setInterval(() => {
      this.obtenerTareasCaducadas();
    }, 6000); // Cada 6 segundos
    }
  },


  methods: {
    toggleNotificationDrawer() {
      this.notificationDrawer = !this.notificationDrawer;
    },

    logout() {
      localStorage.removeItem("token");
      this.tareasCaducadas = [],
      this.$router.push({ name: "Login" });
    },

    obtenerTareasCaducadas() {
      taskService
        .getTasksExpiredUser(this.user.id_usuario)
        .then((response) => {
          this.tareasCaducadas = response.data;
        })
        .catch((error) => {
          console.error("Error al obtener las tareas expiradas del usuario:", error);
        });
    },
  },
  beforeDestroy() {
    if (this.interval) {
      clearInterval(this.interval);
    }
  },
};
</script>
