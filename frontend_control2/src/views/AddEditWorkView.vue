<template>
  <v-container class="add-edit-container" fluid>
    <v-row justify="center">
      <v-card class="pa-6" elevation="8" max-width="600">
        <v-card-title class="text-h5">
          {{ isEditing ? "Editar Tarea" : "Crear Tarea" }}
        </v-card-title>
        <v-divider class="my-4"></v-divider>

        <v-form ref="form">
          <!-- Campo Título -->
          <v-text-field
            v-model="tarea.titulo"
            label="Título"
            outlined
            required
          ></v-text-field>

          <!-- Campo Descripción -->
          <v-textarea
            v-model="tarea.descripcion"
            label="Descripción"
            outlined
            rows="3"
          ></v-textarea>

          <!-- Campo Fecha de Creación -->
          <v-text-field
            v-model="tarea.fecha_creacion"
            label="Fecha de Creación"
            type="date"
            outlined
            required
          ></v-text-field>

          <!-- Campo Fecha de Término -->
          <v-text-field
            v-model="tarea.fecha_termino"
            label="Fecha de Término"
            type="date"
            outlined
          ></v-text-field>

          <!-- Campo Estado -->
          <v-switch
            v-model="tarea.estado"
            label="Estado"
            false-value="false"
            true-value="true"
          ></v-switch>

          <v-btn
            color="primary"
            class="mt-4"
            :loading="loading"
            @click="saveTarea"
          >
            {{ isEditing ? "Guardar Cambios" : "Crear Tarea" }}
          </v-btn>
        </v-form>
      </v-card>
    </v-row>
  </v-container>
</template>


<script>
import taskService from '@/services/task.service';
import { jwtDecode } from "jwt-decode";
export default {
    name: "AddEditWorkView",
    data() {
      return {
        tarea: {
          titulo: "",
          descripcion: "",
          fecha_creacion: "",
          fecha_termino: "",
          estado: false,
        },
        isEditing: false, // Determina si estamos editando o creando
        loading: false,
        userId: null,
      };
    },
  
  mounted() {
    const token = localStorage.getItem("token");
    if (token) {
      const decodedToken = jwtDecode(token);
      this.userId = decodedToken.id_usuario; // Almacena el ID del usuario logueado
      console.log("ID del usuario logueado:", this.userId);
    } else {
      console.error("No se encontró el token.");
    }

    const tareaId = this.$route.query.id; // Obtenemos el ID de la tarea (si existe)
    if (tareaId) {
      this.isEditing = true;
      this.loadTarea(tareaId);
    }
  },

  methods: {
    // Cargar tarea existente (para edición)
    loadTarea(id) {
      this.loading = true;
      taskService
        .getById(id)
        .then((response) => {
          this.tarea = response.data;
          this.loading = false;
        })
        .catch((error) => {
          console.error("Error al cargar la tarea:", error);
          this.loading = false;
        });
    },
    // Crear o editar tarea
    saveTarea() {
      if (this.$refs.form.validate()) {
        this.loading = true;
        if (this.isEditing) {
          // Editar tarea
          taskService
            .update(this.tarea.id_tarea, this.tarea)
            .then(() => {
              this.$router.push({ path: '/homeworks' }); // Redirigir a la lista de tareas
            })
            .catch((error) => {
              console.error("Error al guardar la tarea:", error);
              this.loading = false;
            });
        } else {
          // Crear tarea
          const newTask = {
          ...this.tarea,
          id_usuario: this.userId, // Agrega el ID del usuario logueado
        };
          taskService
            .create(newTask)
            .then(() => {
              this.$router.push({ path: '/homeworks' }); // Redirigir a la lista de tareas
            })
            .catch((error) => {
              console.error("Error al crear la tarea:", error);
              this.loading = false;
            });
        }
      }
    },
  },
};
</script>

<style scoped>
  .add-edit-container{
    height: 100vh;
    display: flex;
    align-items: center;
    background-image: url('../assets/fondoEditWork.jpg');
    background-size: cover;
    background-position: center; 
    background-repeat: no-repeat;
  }
</style>