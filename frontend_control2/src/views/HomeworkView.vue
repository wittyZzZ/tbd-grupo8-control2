<template>
  <v-container class="homework-container" fluid style="padding-top: 80px;">
    <v-col justify="space-between" align="center" class="mb-12">

    <v-row justify="center" class="mb-4">
      <v-col cols="12" sm="6" md="4">
        <v-btn color="primary" @click="addTask" block>Agregar</v-btn>
      </v-col>
    </v-row>

    <v-row justify="center" class="mb-4">
      <v-col cols="12" sm="6" md="4">
        <v-text-field
          v-model="search"
          label="Buscar tareas"
          outlined
          dense
          block
        ></v-text-field>
      </v-col>
    </v-row>

    <v-row justify="center" class="mb-4">
    <v-col cols="12" sm="6" md="4" class="mb-3">
        <v-select
          v-model="filterStatus"
          :items="statusOptions"
          item-text="text"
          item-value="value"
          label="Filtrar por estado"
          outlined
          dense
          
        ></v-select>
    </v-col>
  </v-row>
  </v-col>

  <!-- Tabla -->
  <v-row justify="center">
    <v-data-table
      :headers="headers"
      :items="filteredTasks"
      class="elevation-1"
      item-value="id_tarea"
      dense
    >
      <template v-slot:[`item.actions`]="{ item }">
        <v-chip
          :color="item.estado ? 'green' : 'orange'"
          text-color="white"
        >
          {{ item.estado ? "Completada" : "Pendiente" }}
        </v-chip>
        <v-btn icon @click="editTask(item)">
          <v-icon>mdi-pencil</v-icon>
        </v-btn>
      </template>
    </v-data-table>
  </v-row>
  </v-container>
</template>

<script>
import taskService from "@/services/task.service";
import { jwtDecode } from "jwt-decode";
export default {
  name: "HomeworkView",

  data() {
    return {
      user: "",
      tasks: [], // Lista de tareas obtenidas del servicio
      search: "", // Palabra clave para buscar
      filterStatus: null, // Filtro de estado: 'pendiente' o 'completada'
      statusOptions: [
        { text: "Pendiente", value: false },
        { text: "Completada", value: true },
      ],
      headers: [
        { text: "Título", value: "titulo" },
        { text: "Descripción", value: "descripcion" },
        { text: "Fecha Creación", value: "fecha_creacion" },
        { text: "Fecha Término", value: "fecha_termino" },
        { text: "Estado", value: "estado" },
        //esto es para mostrar los botones
        { text: "Acciones", value: "actions", sortable: false },
      ],
    };
  },

  computed: {
    filteredTasks() {
      return this.tasks
        .filter((task) => {
          // Filtrar por estado si está seleccionado
          if (this.filterStatus !== null) {
            return task.estado === this.filterStatus;
          }
          return true;
        })
        .filter((task) => {
          // Filtrar por palabra clave en título o descripción
          const keyword = this.search.toLowerCase();
          return (
            task.titulo.toLowerCase().includes(keyword) ||
            task.descripcion.toLowerCase().includes(keyword)
          );
        });
    },
  },

  mounted() {
    const token = localStorage.getItem("token");
    if (token) {
      const decodedToken = jwtDecode(token);
      this.user = decodedToken; // Almacena los datos del usuario logueado
      const userId = this.user.id_usuario; // Obtén el ID del usuario

      // Llama al servicio para obtener las tareas del usuario
      taskService
        .getTasksByUserId(userId)
        .then((response) => {
          this.tasks = response.data; // Almacena las tareas obtenidas
          console.log("Tareas del usuario:", this.tasks);
        })
        .catch((error) => {
          console.error("Error al obtener las tareas del usuario:", error);
        });
    } else {
      console.error("No se encontró el token de autenticación.");
    }
  },
    // Obtiene todas las tareas al montar el componente
    /* taskService
      .getAll()
      .then((response) => {
        this.tasks = response.data; // Ajusta esto según el formato de datos que retorna tu servicio
        console.log(this.tasks);
      })
      .catch((error) => {
        console.error("Error al obtener las tareas:", error);
      });
    


    const token = localStorage.getItem("token");
    if (token) {
      const decodedToken = jwtDecode(token);
      this.user = decodedToken;
    }
  }, */

  methods: {
    addTask() {
      console.log("Agregar nueva tarea");
      this.$router.push({ path: "/addeditwork" });
      // Aquí puedes agregar lógica para abrir un modal o formulario.
    },
    editTask(task) {
      console.log("Editar tarea:", task);
      this.$router.push({ path: "/addeditwork", query: { id: task.id_tarea } });
      // Aquí puedes agregar lógica para editar la tarea.
    },
  },
};
</script>

<style scoped>
.homework-container {
  height: 100vh;
  display: flex;
  align-items: center;
  background-image: url("../assets/fondoListaTarea.jpg");
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}
</style>