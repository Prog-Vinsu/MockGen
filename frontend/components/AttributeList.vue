<template>
  <div class="w-full mb-8 bg-white p-6 rounded-2xl shadow-lg">
    <div v-if="attributes && Object.keys(attributes).length > 0">
      <h2 class="text-xl font-semibold text-gray-800 mb-4">
        {{ title || "Atributos Definidos" }}
      </h2>
      <div class="space-y-3">
        <div
          v-for="(data, attr) in attributes"
          :key="attr"
          class="group flex items-center justify-between p-4 bg-gray-50 rounded-lg border border-gray-200 hover:bg-gray-100 transition-colors"
        >
          <div class="flex items-center space-x-3">
            <div
              class="w-8 h-8 flex items-center justify-center bg-blue-100 text-blue-600 rounded-lg"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-5 w-5"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M13 10V3L4 14h7v7l9-11h-7z"
                />
              </svg>
            </div>
            <div>
              <h3 class="font-medium text-gray-900">{{ attr }}</h3>
              <div class="flex flex-wrap gap-2 mt-1">
                <span
                  class="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-blue-100 text-blue-800"
                >
                  {{ data.type }}
                </span>
                <span
                  class="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-green-100 text-green-800"
                >
                  {{ data.region }}
                </span>
                <span
                  class="inline-flex items-center px-2.5 py-0.5 rounded-full text-xs font-medium bg-purple-100 text-purple-800"
                >
                  Qt: {{ data.quantity }}
                </span>
              </div>
            </div>
          </div>

          <div
            class="flex space-x-2 opacity-0 group-hover:opacity-100 transition-opacity"
          >
            <button
              v-if="editable"
              class="p-2 text-gray-500 hover:text-blue-600 hover:bg-blue-50 rounded-full transition-colors"
              title="Editar atributo"
              @click="$emit('edit', attr)"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-5 w-5"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z"
                />
              </svg>
            </button>
            <button
              v-if="removable"
              class="p-2 text-gray-500 hover:text-red-600 hover:bg-red-50 rounded-full transition-colors"
              title="Remover atributo"
              @click="$emit('remove', attr)"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-5 w-5"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>

      <div v-if="showCount" class="text-sm text-gray-500 mt-3 text-right">
        Total:
        <span class="font-medium">{{ Object.keys(attributes).length }}</span>
        atributo(s)
      </div>
    </div>

    <div
      v-else
      class="text-center p-6 bg-gray-50 rounded-xl border-2 border-dashed border-gray-300"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        class="mx-auto h-12 w-12 text-gray-400"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          d="M9 13h6m-3-3v6m-9 1V7a2 2 0 012-2h6l2 2h6a2 2 0 012 2v8a2 2 0 01-2 2H5a2 2 0 01-2-2z"
        />
      </svg>
      <h3 class="mt-2 text-sm font-medium text-gray-900">
        {{ emptyMessage || "Nenhum atributo definido" }}
      </h3>
      <p class="mt-1 text-sm text-gray-500">Adicione atributos para começar</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "AttributeList",
  props: {
    attributes: {
      type: Object,
      required: true,
    },
    title: {
      type: String,
      default: "",
    },
    emptyMessage: {
      type: String,
      default: "",
    },
    removable: {
      type: Boolean,
      default: true,
    },
    editable: {
      type: Boolean,
      default: false,
    },
    showCount: {
      type: Boolean,
      default: true,
    },
  },
  emits: ["remove", "edit"],
};
</script>

<style scoped>
/* Transição suave para hover */
.transition-colors {
  transition-property: background-color, border-color, color, fill, stroke;
  transition-timing-function: cubic-bezier(0.4, 0, 0.2, 1);
  transition-duration: 150ms;
}

/* Efeito de hover nos itens da lista */
.group:hover .group-hover\:opacity-100 {
  opacity: 1;
}
</style>
