<template>
  <nav
    class="bg-gradient-to-r from-gray-800 to-gray-900 p-4 text-white fixed top-0 left-0 right-0 z-50 shadow-xl"
  >
    <div
      class="container mx-auto flex justify-between items-center max-w-7xl px-4"
    >
      <!-- Logo com estilo moderno -->
      <div class="flex items-center space-x-2">
        <div
          class="w-8 h-8 bg-blue-600 rounded-lg flex items-center justify-center"
        >
          <svg
            class="w-5 h-5"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M9 3v2m6-2v2M9 19v2m6-2v2M5 9H3m2 6H3m18-6h-2m2 6h-2M7 19h10a2 2 0 002-2V7a2 2 0 00-2-2H7a2 2 0 00-2 2v10a2 2 0 002 2z"
            />
          </svg>
        </div>
        <router-link
          to="/"
          class="text-xl font-bold hover:text-blue-400 transition-colors"
        >
          Mock<span class="text-blue-400">Gen</span>
        </router-link>
      </div>

      <!-- Menu desktop -->
      <div class="hidden md:flex space-x-8 items-center">
        <router-link
          to="/"
          class="hover:text-blue-400 transition-colors font-medium flex items-center py-1 px-3 rounded-lg hover:bg-gray-700/50"
          active-class="text-blue-400 bg-gray-700/30"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"
            />
          </svg>
          Home
        </router-link>

        <router-link
          to="/sobre"
          class="hover:text-blue-400 transition-colors font-medium flex items-center py-1 px-3 rounded-lg hover:bg-gray-700/50"
          active-class="text-blue-400 bg-gray-700/30"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
            />
          </svg>
          Sobre
        </router-link>

        <router-link
          to="/gerador"
          class="hover:text-blue-400 transition-colors font-medium flex items-center py-1 px-3 rounded-lg hover:bg-gray-700/50"
          active-class="text-blue-400 bg-gray-700/30"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01"
            />
          </svg>
          Gerador
        </router-link>

        <router-link
          to="/contato"
          class="hover:text-blue-400 transition-colors font-medium flex items-center py-1 px-3 rounded-lg hover:bg-gray-700/50"
          active-class="text-blue-400 bg-gray-700/30"
        >
          <svg
            class="w-4 h-4 mr-2"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"
            />
          </svg>
          Contato
        </router-link>
      </div>

      <!-- Botão mobile -->
      <div class="md:hidden">
        <button
          class="p-2 rounded-lg hover:bg-gray-700/50 focus:outline-none focus:ring-2 focus:ring-blue-500"
          aria-label="Menu"
          @click="isOpen = !isOpen"
        >
          <svg
            class="w-6 h-6"
            fill="none"
            stroke="currentColor"
            viewBox="0 0 24 24"
          >
            <path
              v-if="!isOpen"
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M4 6h16M4 12h16M4 18h16"
            />
            <path
              v-else
              stroke-linecap="round"
              stroke-linejoin="round"
              stroke-width="2"
              d="M6 18L18 6M6 6l12 12"
            />
          </svg>
        </button>
      </div>

      <!-- Menu mobile -->
      <transition
        enter-active-class="transition ease-out duration-200"
        enter-from-class="opacity-0 translate-y-1"
        enter-to-class="opacity-100 translate-y-0"
        leave-active-class="transition ease-in duration-150"
        leave-from-class="opacity-100 translate-y-0"
        leave-to-class="opacity-0 translate-y-1"
      >
        <div
          v-if="isOpen"
          class="md:hidden absolute top-16 left-0 right-0 bg-gradient-to-b from-gray-800 to-gray-900 shadow-xl rounded-b-lg mx-4 py-3 px-4"
        >
          <div class="flex flex-col space-y-2">
            <router-link
              to="/"
              class="flex items-center py-3 px-4 rounded-lg hover:bg-gray-700/50 text-white font-medium"
              active-class="text-blue-400 bg-gray-700/30"
              @click="isOpen = false"
            >
              <svg
                class="w-5 h-5 mr-3"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"
                />
              </svg>
              Home
            </router-link>
            <router-link
              to="/sobre"
              class="flex items-center py-3 px-4 rounded-lg hover:bg-gray-700/50 text-white font-medium"
              active-class="text-blue-400 bg-gray-700/30"
              @click="isOpen = false"
            >
              <svg
                class="w-5 h-5 mr-3"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                />
              </svg>
              Sobre
            </router-link>
            <router-link
              to="/gerador"
              class="flex items-center py-3 px-4 rounded-lg hover:bg-gray-700/50 text-white font-medium"
              active-class="text-blue-400 bg-gray-700/30"
              @click="isOpen = false"
            >
              <svg
                class="w-5 h-5 mr-3"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01"
                />
              </svg>
              Gerador
            </router-link>
            <router-link
              to="/contato"
              class="flex items-center py-3 px-4 rounded-lg hover:bg-gray-700/50 text-white font-medium"
              active-class="text-blue-400 bg-gray-700/30"
              @click="isOpen = false"
            >
              <svg
                class="w-5 h-5 mr-3"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z"
                />
              </svg>
              Contato
            </router-link>
          </div>
        </div>
      </transition>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
  data() {
    return {
      isOpen: false,
    };
  },
  watch: {
    $route() {
      this.isOpen = false;
    },
  },
};
</script>
