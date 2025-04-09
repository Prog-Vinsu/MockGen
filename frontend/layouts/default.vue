<template>
  <div>
    <NavBar />
    <NuxtPage />
    <AppFooter />
  </div>
</template>

<script>
import NavBar from "~/components/NavBar.vue";
import AppFooter from "~/components/Footer.vue";

export default {
  components: {
    NavBar,
    AppFooter,
  },
};
</script>
