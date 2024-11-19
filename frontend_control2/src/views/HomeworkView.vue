<template>
  <v-container class="homework-container" fluid style="padding-top: 80px;">
    <v-col justify="space-between" align="center" class="mb-12">
      <!-- Botón para agregar una tarea -->
      <v-row justify="center" class="mb-4">
        <v-col cols="12" sm="6" md="4">
          <v-btn color="primary" @click="addTask" block>Agregar Tarea</v-btn>
        </v-col>
      </v-row>
      <v-row justify="center" class="mb-4">
        <v-col cols="12" sm="6" md="4">
          <v-text-field
            v-model="search"
            label="Buscar tareas"
            outlined
            @input="applyFilters"
            dense
            block
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row justify="center" class="mb-4">
        <v-col cols="12" sm="6" md="4" class="mb-3">
          <v-select
            v-model="filterStatus"
            :items="statusOptions.map(option => option.text)"
            item-text="text"
            item-value="value"
            label="Filtrar por estado"
            class="mb-4"
            outlined
            @change="applyFilters"
          ></v-select>
        </v-col>
      </v-row>
    </v-col>

    <!-- Contenedor con scroll para la tabla -->
    <v-row justify="center">
      <div class="table-container mr-5">
        <v-data-table
          :headers="headers"
          :items="filteredTasks.length > 0 ? filteredTasks : tasks"
          class="elevation-1"
          item-value="id_tarea"
          dense
        >
          <template v-slot:[`item.actions`]="{ item }">
            <div class="d-flex justify-end align-center">
              <v-chip
                :color="item.estado === 'Completada' ? 'green' : item.estado === 'Pendiente' ? 'orange' : 'red'"
                class="mr-2"
              >
                {{ item.estado }}
              </v-chip>
              <v-spacer></v-spacer>
              <v-btn color="primary" icon @click="editTask(item)">
                <v-icon>mdi-pencil</v-icon>
              </v-btn>
              <v-btn color="error" class="mx-10" icon @click="deleteTask(item)">
                <v-icon>mdi-delete-forever</v-icon>
              </v-btn>
            </div>
          </template>
        </v-data-table>
      </div>
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
      tasks: [],
      filteredTasks: [],
      search: "",
      filterStatus: null,
      statusOptions: [
        { text: "Todas", value: "Todas" },
        { text: "Pendiente", value: "Pendiente" },
        { text: "Completada", value: "Completada" },
        { text: "Caducada", value: "Caducada" },
      ],
      headers: [
        { title: "Título", value: "titulo" },
        { title: "Descripción", value: "descripcion" },
        { title: "Fecha Creación", value: "fecha_creacion" },
        { title: "Fecha Término", value: "fecha_termino" },
        { title: "Estado", value: "actions", sortable: false },
      ],
    };
  },

  computed: {
    applyFilters() {
      this.filteredTasks = this.tasks
        .filter((task) => {
          // Si el estado es "Todas", no filtrar por estado
          if (this.filterStatus === "Todas" || this.filterStatus === null) {
            return true;
          }
          return task.estado === this.filterStatus;
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
    }
      // Llama al servicio para obtener las tareas del usuario
      taskService
        .getTasksByUserId(this.user.id_usuario)
        .then((response) => {
          this.tasks = response.data; // Almacena las tareas obtenidas
          console.log("Tareas del usuario:", this.tasks);
        })
        .catch((error) => {
          console.error("Error al obtener las tareas del usuario:", error);
        });

      taskService
        .getTasksExpiredUser(this.user.id_usuario)
        .then((response) => {
          console.log("Tareas caducadas de usuario:", response.data);
        })
        .catch((error) => {
          console.error("Error al obtener las tareas expiradas del usuario:", error);
        });
  },


  methods: {
    addTask() {
      this.$router.push({ path: "/addeditwork" });
    },
    editTask(task) {
      this.$router.push({ path: "/addeditwork", query: { id: task.id_tarea } });
    },


    deleteTask(task) {
      if (confirm("¿Estás seguro de que deseas eliminar esta tarea?")) {
        taskService
          .remove(task.id_tarea)
          .then(() => {
            alert("Tarea eliminada con éxito.");
            this.$router.go(); // Redirigir a la lista de tareas
          })
          .catch((error) => {
            console.error("Error al eliminar la tarea:", error);
            this.loading = false;
          });
      }
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

.table-container {
  max-height: 85vh; /* Altura máxima */
  overflow-y: auto; /* Scroll vertical */
  width: 100%; /* Para que ocupe todo el ancho */
}
</style>
