<template>
  <div class="min-h-screen bg-gradient-to-br from-gray-50 to-blue-50 py-12">
    <div class="container mx-auto px-4 max-w-6xl">
      <!-- Cabeçalho -->
      <div class="text-center mb-12 mt-16">
        <h1 class="text-3xl md:text-4xl font-bold text-gray-900 mb-2">
          Entre em <span class="text-blue-600">Contato</span>
        </h1>
        <p class="text-gray-600 max-w-lg mx-auto">
          Tem dúvidas ou sugestões? Envie-nos uma mensagem!
        </p>
      </div>

      <!-- Grid de contato -->
      <div class="grid grid-cols-1 md:grid-cols-2 gap-8">
        <!-- Formulário -->
        <div class="bg-white p-8 rounded-2xl shadow-lg">
          <h2 class="text-xl font-semibold mb-6 text-gray-800">
            Envie sua mensagem
          </h2>

          <form class="space-y-6" @submit.prevent="submitForm">
            <div>
              <label
                for="name"
                class="block text-sm font-medium text-gray-700 mb-1"
                >Nome</label
              >
              <input
                id="name"
                v-model="form.name"
                type="text"
                required
                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
                placeholder="Seu nome completo"
              />
            </div>

            <div>
              <label
                for="email"
                class="block text-sm font-medium text-gray-700 mb-1"
                >Email</label
              >
              <input
                id="email"
                v-model="form.email"
                type="email"
                required
                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
                placeholder="seu@email.com"
              />
            </div>

            <div>
              <label
                for="subject"
                class="block text-sm font-medium text-gray-700 mb-1"
                >Assunto</label
              >
              <select
                id="subject"
                v-model="form.subject"
                required
                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
              >
                <option value="" disabled selected>Selecione um assunto</option>
                <option value="suporte">Suporte Técnico</option>
                <option value="sugestao">Sugestão</option>
                <option value="parceria">Parceria</option>
                <option value="outro">Outro</option>
              </select>
            </div>

            <div>
              <label
                for="message"
                class="block text-sm font-medium text-gray-700 mb-1"
                >Mensagem</label
              >
              <textarea
                id="message"
                v-model="form.message"
                rows="5"
                required
                class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
                placeholder="Escreva sua mensagem aqui..."
              />
            </div>

            <button
              type="submit"
              class="w-full bg-blue-600 hover:bg-blue-700 text-white px-6 py-3 rounded-lg font-medium transition-all duration-200 transform hover:scale-105 active:scale-95"
              :disabled="loading"
            >
              <span v-if="!loading">Enviar Mensagem</span>
              <span v-else class="flex items-center justify-center">
                <svg
                  class="animate-spin -ml-1 mr-3 h-5 w-5 text-white"
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                >
                  <circle
                    class="opacity-25"
                    cx="12"
                    cy="12"
                    r="10"
                    stroke="currentColor"
                    stroke-width="4"
                  />
                  <path
                    class="opacity-75"
                    fill="currentColor"
                    d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"
                  />
                </svg>
                Enviando...
              </span>
            </button>
          </form>
        </div>

        <!-- Informações de contato -->
        <div class="bg-white p-8 rounded-2xl shadow-lg">
          <h2 class="text-xl font-semibold mb-6 text-gray-800">
            Informações de Contato
          </h2>

          <div class="space-y-6">
            <div class="flex items-start">
              <div
                class="flex-shrink-0 h-10 w-10 rounded-lg bg-blue-100 flex items-center justify-center"
              >
                <svg
                  class="h-6 w-6 text-blue-600"
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
              </div>
              <div class="ml-4">
                <h3 class="text-lg font-medium text-gray-900">Email</h3>
                <p class="text-gray-600">tognerepoloniniv@gmail.com</p>
                <p class="mt-1 text-sm text-gray-500">
                  Respondemos em até 24 horas
                </p>
              </div>
            </div>

            <div class="flex items-start">
              <div
                class="flex-shrink-0 h-10 w-10 rounded-lg bg-green-100 flex items-center justify-center"
              >
                <svg
                  class="h-6 w-6 text-green-600"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M3 5a2 2 0 012-2h3.28a1 1 0 01.948.684l1.498 4.493a1 1 0 01-.502 1.21l-2.257 1.13a11.042 11.042 0 005.516 5.516l1.13-2.257a1 1 0 011.21-.502l4.493 1.498a1 1 0 01.684.949V19a2 2 0 01-2 2h-1C9.716 21 3 14.284 3 6V5z"
                  />
                </svg>
              </div>
              <div class="ml-4">
                <h3 class="text-lg font-medium text-gray-900">Telefone</h3>
                <p class="text-gray-600">+55 (27) 99727-0573</p>
                <p class="mt-1 text-sm text-gray-500">
                  Segunda a Sexta, 9h às 17h
                </p>
              </div>
            </div>

            <div class="flex items-start">
              <div
                class="flex-shrink-0 h-10 w-10 rounded-lg bg-purple-100 flex items-center justify-center"
              >
                <svg
                  class="h-6 w-6 text-purple-600"
                  fill="none"
                  stroke="currentColor"
                  viewBox="0 0 24 24"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z"
                  />
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M15 11a3 3 0 11-6 0 3 3 0 016 0z"
                  />
                </svg>
              </div>
              <div class="ml-4">
                <h3 class="text-lg font-medium text-gray-900">Endereço</h3>
                <p class="text-gray-600">São Mateus, Espírito Santo, Brasil</p>
                <p class="mt-1 text-sm text-gray-500">Localização da empresa</p>
              </div>
            </div>

            <div class="border-t border-gray-200 pt-6">
              <h3 class="text-lg font-medium text-gray-900 mb-4">
                Redes Sociais
              </h3>
              <div class="flex space-x-4">
                <a
                  href="https://www.linkedin.com/in/vincenzo-tognere-polonini/"
                  target="_blank"
                  class="text-gray-500 hover:text-blue-600 transition-colors"
                >
                  <span class="sr-only">LinkedIn</span>
                  <svg class="h-6 w-6" fill="currentColor" viewBox="0 0 24 24">
                    <path
                      d="M19 0h-14c-2.761 0-5 2.239-5 5v14c0 2.761 2.239 5 5 5h14c2.762 0 5-2.239 5-5v-14c0-2.761-2.238-5-5-5zm-11 19h-3v-11h3v11zm-1.5-12.268c-.966 0-1.75-.79-1.75-1.764s.784-1.764 1.75-1.764 1.75.79 1.75 1.764-.783 1.764-1.75 1.764zm13.5 12.268h-3v-5.604c0-3.368-4-3.113-4 0v5.604h-3v-11h3v1.765c1.396-2.586 7-2.777 7 2.476v6.759z"
                    />
                  </svg>
                </a>
                <a
                  href="https://www.instagram.com/vinn_tp"
                  target="_blank"
                  class="text-gray-500 hover:text-pink-600 transition-colors"
                >
                  <span class="sr-only">Instagram</span>
                  <svg class="h-6 w-6" fill="currentColor" viewBox="0 0 24 24">
                    <path
                      d="M12 2.163c3.204 0 3.584.012 4.85.07 3.252.148 4.771 1.691 4.919 4.919.058 1.265.069 1.645.069 4.849 0 3.205-.012 3.584-.069 4.849-.149 3.225-1.664 4.771-4.919 4.919-1.266.058-1.644.07-4.85.07-3.204 0-3.584-.012-4.849-.07-3.26-.149-4.771-1.699-4.919-4.92-.058-1.265-.07-1.644-.07-4.849 0-3.204.013-3.583.07-4.849.149-3.227 1.664-4.771 4.919-4.919 1.266-.057 1.645-.069 4.849-.069zm0-2.163c-3.259 0-3.667.014-4.947.072-4.358.2-6.78 2.618-6.98 6.98-.059 1.281-.073 1.689-.073 4.948 0 3.259.014 3.668.072 4.948.2 4.358 2.618 6.78 6.98 6.98 1.281.058 1.689.072 4.948.072 3.259 0 3.668-.014 4.948-.072 4.354-.2 6.782-2.618 6.979-6.98.059-1.28.073-1.689.073-4.948 0-3.259-.014-3.667-.072-4.947-.196-4.354-2.617-6.78-6.979-6.98-1.281-.059-1.69-.073-4.949-.073zm0 5.838c-3.403 0-6.162 2.759-6.162 6.162s2.759 6.163 6.162 6.163 6.162-2.759 6.162-6.163c0-3.403-2.759-6.162-6.162-6.162zm0 10.162c-2.209 0-4-1.79-4-4 0-2.209 1.791-4 4-4s4 1.791 4 4c0 2.21-1.791 4-4 4zm6.406-11.845c-.796 0-1.441.645-1.441 1.44s.645 1.44 1.441 1.44c.795 0 1.439-.645 1.439-1.44s-.644-1.44-1.439-1.44z"
                    />
                  </svg>
                </a>
                <a
                  href="https://github.com/Prog-Vinsu"
                  target="_blank"
                  class="text-gray-500 hover:text-gray-900 transition-colors"
                >
                  <span class="sr-only">GitHub</span>
                  <svg class="h-6 w-6" fill="currentColor" viewBox="0 0 24 24">
                    <path
                      fill-rule="evenodd"
                      d="M12 2C6.477 2 2 6.484 2 12.017c0 4.425 2.865 8.18 6.839 9.504.5.092.682-.217.682-.483 0-.237-.008-.868-.013-1.703-2.782.605-3.369-1.343-3.369-1.343-.454-1.158-1.11-1.466-1.11-1.466-.908-.62.069-.608.069-.608 1.003.07 1.531 1.032 1.531 1.032.892 1.53 2.341 1.088 2.91.832.092-.647.35-1.088.636-1.338-2.22-.253-4.555-1.113-4.555-4.951 0-1.093.39-1.988 1.029-2.688-.103-.253-.446-1.272.098-2.65 0 0 .84-.27 2.75 1.026A9.564 9.564 0 0112 6.844c.85.004 1.705.115 2.504.337 1.909-1.296 2.747-1.027 2.747-1.027.546 1.379.202 2.398.1 2.651.64.7 1.028 1.595 1.028 2.688 0 3.848-2.339 4.695-4.566 4.943.359.309.678.92.678 1.855 0 1.338-.012 2.419-.012 2.747 0 .268.18.58.688.482A10.019 10.019 0 0022 12.017C22 6.484 17.522 2 12 2z"
                      clip-rule="evenodd"
                    />
                  </svg>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "ContatoPage",
  data() {
    return {
      form: {
        name: "",
        email: "",
        subject: "",
        message: "",
      },
      loading: false,
    };
  },
  methods: {
    async submitForm() {
      this.loading = true;

      try {
        const response = await axios.post(
          "http://localhost:8080/api/contact",
          this.form,
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        );

        if (response.status === 200) {
          alert("Mensagem enviada com sucesso!");
          this.form = { name: "", email: "", subject: "", message: "" };
        }
      } catch (error) {
        if (error.response) {
          // Erro da resposta do servidor
          console.error("Erro do servidor:", error.response.data);
          alert(
            `Erro ${error.response.status}: ${error.response.data.message}`
          );
        } else if (error.request) {
          // A requisição foi feita mas não houve resposta
          console.error("Sem resposta do servidor:", error.request);
          alert("Servidor não respondeu. Verifique se o backend está rodando.");
        } else {
          // Erro ao configurar a requisição
          console.error("Erro de configuração:", error.message);
          alert("Erro ao enviar mensagem. Verifique sua conexão.");
        }
      } finally {
        this.loading = false;
      }
    },
  },
};
</script>

<style scoped>
/* Animação de entrada */
.animate-fade-in {
  animation: fadeIn 0.6s ease-out;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

/* Transições suaves */
.transition-colors {
  transition: color 0.2s ease-in-out;
}

/* Estilo para o textarea */
textarea {
  resize: vertical;
  min-height: 120px;
}
</style>
