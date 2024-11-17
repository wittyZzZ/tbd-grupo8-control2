<template>
  
  <v-container class="home-container" fluid>
    <v-row justify="center">
      <v-card class="text-center pa-6" elevation="8" max-width="400">
        <v-card-title class="text-h5">Bienvenido</v-card-title>
        <v-card-subtitle>Tareas de la asignatura</v-card-subtitle>

        <v-divider class="my-4"></v-divider>

        

      </v-card>

    </v-row>
  </v-container>
</template>


<script>

// Components

export default{
  name: 'HomeView',

  components: {
  },
};
</script>

<style scoped>
  .home-container {
    height: 100vh;
    display: flex;
    align-items: center;
    background-image: url('../assets/fondo_app_contorl.jpg');
    background-size: cover;
    background-position: center; 
    background-repeat: no-repeat;
  }
</style>
