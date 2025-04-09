<template>
  <div>
    <NuxtLayout>
      <NuxtPage />
    </NuxtLayout>
  </div>
</template>

<script>
export default {
  name: "App",
  script: [
    {
      src: "https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js",
      "data-ad-client": "ca-pub-1424643380498076",
      async: true,
      crossorigin: "anonymous",
    },
  ],
};
</script>

<style>
.page-enter-active,
.page-leave-active {
  transition: all 0.2s;
}
.page-enter-from,
.page-leave-to {
  opacity: 0;
  filter: blur(2px);
  transform: translateY(20px);
}
</style>
