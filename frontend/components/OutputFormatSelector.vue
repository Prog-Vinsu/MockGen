<template>
    <div class="output-format-selector">
      <label class="text-sm font-medium text-gray-700 mr-2">Formato de Saída:</label>
      <select
        v-model="selectedFormat"
        class="px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500"
        @change="$emit('format-change', selectedFormat)"
      >
        <option v-for="format in formats" :key="format.value" :value="format.value">
          {{ format.label }}
        </option>
      </select>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  
  export default {
    name: 'OutputFormatSelector',
    emits: ['format-change'],
    setup() {
      const formats = [
        { value: 'json', label: 'JSON' },
        { value: 'csv', label: 'CSV' },
        { value: 'xml', label: 'XML' },
        { value: 'sql', label: 'SQL' }
      ];
      
      const selectedFormat = ref('json');
      
      return {
        formats,
        selectedFormat
      };
    }
  };
  </script>
  
  <style scoped>
  .output-format-selector {
    display: flex;
    align-items: center;
  }
  </style>