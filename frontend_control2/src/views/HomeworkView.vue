<template>
  
  <v-container class="homework-container" fluid>
    <v-row justify="center">
      <v-card class="text-center pa-6" elevation="8" max-width="400">
        <v-card-title class="text-h5">Tareas</v-card-title>
        <v-divider class="my-4"></v-divider>

        <!-- Botón para agregar una tarea -->
        <v-btn color="primary" class="mb-4" @click="addTask">
          Agregar Tarea
        </v-btn>

        <v-text-field
          v-model="search"
          label="Buscar tareas"
          class="mb-4"
          outlined
        />

        <v-data-table
          :headers="headers"
          :items="tasks"
          class="elevation-1"
          item-value="id"
          dense
          search="search"
        >
          <template v-slot:[`item.actions`]="{ item }">
            <!-- <v-chip color="green" text-color="white" v-if="item.status === 'Completada'">
              {{ item.status }}
            </v-chip>
            <v-chip color="orange" text-color="white" v-else>
              {{ item.status }}
            </v-chip> -->
            <!-- Botón para editar la tarea -->
            <v-btn icon @click="editTask(item)">
              <v-icon>mdi-pencil</v-icon>
            </v-btn>
          </template>
        </v-data-table>

      </v-card>

    </v-row>
  </v-container>
</template>

<script>
  import taskService from '@/services/task.service';
  export default {
    name: "HomeworkView",

    data() {
      return {
        tasks: [], // Lista de tareas obtenidas del servicio
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

    mounted() {
    // Obtiene todas las tareas al montar el componente
      taskService
        .getAll()
        .then((response) => {
          this.tasks = response.data; // Ajusta esto según el formato de datos que retorna tu servicio
        })
        .catch((error) => {
          console.error("Error al obtener las tareas:", error);
        });
    },

    methods: {
    addTask() {
      console.log("Agregar nueva tarea");
      this.$router.push({ path: "/addeditwork" });
      // Aquí puedes agregar lógica para abrir un modal o formulario.
    },
    editTask(task) {
      console.log("Editar tarea:", task);
      this.$router.push({ path: "/addeditwork", query: { id: task.id } });
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
    background-image: url('../assets/fondoListaTarea.jpg');
    background-size: cover;
    background-position: center; 
    background-repeat: no-repeat;
  }
</style>