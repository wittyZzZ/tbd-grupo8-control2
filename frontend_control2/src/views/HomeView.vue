<template>
  
  <v-container class="home-container" fluid>
    <v-row justify="center">
      <v-card class="text-center pa-6" elevation="8" max-width="400">
        <v-card-title class="text-h5">Bienvenido</v-card-title>
        <v-card-subtitle>Elige una opción para continuar</v-card-subtitle>

        <v-divider class="my-4"></v-divider>

        <v-card-text>
          <!-- Botón de Login -->
          <v-btn @click="logout" color="primary" class="ma-2" :to="{ name: 'Login' }" block>
            LOGIN
          </v-btn>

          <!-- Botón de Register -->
          <v-btn @click="logout" color="secondary" class="ma-2" :to="{ name: 'Register' }" block>
            REGISTER
          </v-btn>
        </v-card-text>

      </v-card>

      <!-- <v-col cols="4" class="bg-purple text-center">
        <v-btn color="primary" :to="{ name: 'Products' }">
          LINK A PRODUCTOS
        </v-btn>
      </v-col> -->

    </v-row>
  </v-container>
</template>


<script>
import { defineComponent } from 'vue';

// Components

export default defineComponent({
  name: 'HomeView',

  components: {
  },
});
</script>
