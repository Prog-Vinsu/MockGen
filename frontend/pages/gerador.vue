<template>
    <div class="min-h-screen bg-gradient-to-br from-gray-50 to-blue-50 py-12 mt-5">
      <JsonMockGenerator />
    </div>
  </template>
  
  <script>
  import JsonMockGenerator from '~/components/JsonMockGenerator.vue';
  
  export default {
    components: {
      JsonMockGenerator,
    },
  };
  </script>