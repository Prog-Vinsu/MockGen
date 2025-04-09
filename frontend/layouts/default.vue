<template>
  <div>
    <head>
      <script
        async
        src="https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js?client=ca-pub-1424643380498076"
        crossorigin="anonymous"
      />
    </head>
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
