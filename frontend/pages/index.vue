<template>
  <div class="min-h-screen bg-gradient-to-br from-gray-50 to-blue-50">
    <!-- Hero Section -->
    <section class="pt-32 pb-20 px-4 sm:px-6 lg:px-8">
      <div class="max-w-7xl mx-auto">
        <div class="text-center">
          <div
            class="inline-flex items-center bg-blue-100 text-blue-800 px-4 py-2 rounded-full text-sm font-medium mb-6"
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
                d="M13 10V3L4 14h7v7l9-11h-7z"
              />
            </svg>
            Versão 1.0 Disponível
          </div>
          <h1 class="text-4xl md:text-6xl font-bold text-gray-900 mb-6">
            Gere dados <span class="text-blue-600">mockados</span> em segundos
          </h1>
          <p class="text-xl md:text-2xl text-gray-600 max-w-3xl mx-auto mb-10">
            MockGen é a ferramenta definitiva para desenvolvedores que precisam
            de dados realistas para testes e protótipos.
          </p>
          <div class="flex flex-col sm:flex-row justify-center gap-4">
            <NuxtLink
              to="/gerador"
              class="px-8 py-4 bg-blue-600 hover:bg-blue-700 text-white font-medium rounded-lg shadow-lg transition-all duration-300 transform hover:scale-105 flex items-center justify-center gap-2"
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
                  d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01"
                />
              </svg>
              Usar Gerador
            </NuxtLink>
            <a
              href="#features"
              class="px-8 py-4 bg-white hover:bg-gray-100 text-gray-800 font-medium rounded-lg shadow-md transition-all duration-300 flex items-center justify-center gap-2"
              @click.prevent="smoothScrollTo('#features')"
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
                  d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"
                />
              </svg>
              Saiba Mais
            </a>
          </div>
        </div>

        <!-- Preview do JSON -->
        <div
          class="mt-16 max-w-4xl mx-auto bg-white rounded-xl shadow-lg overflow-hidden"
        >
          <div class="p-4 bg-gray-800 flex items-center">
            <div class="flex space-x-2 mr-4">
              <div class="w-3 h-3 rounded-full bg-red-500" />
              <div class="w-3 h-3 rounded-full bg-yellow-500" />
              <div class="w-3 h-3 rounded-full bg-green-500" />
            </div>
            <div class="text-sm text-gray-300">dados-mockados.json</div>
          </div>
          <pre class="p-6 bg-gray-900 text-gray-100 text-sm overflow-x-auto">
  <code>[
    {
      "id": "550e8400-e29b-41d4-a716-446655440000",
      "nome": "João Silva",
      "email": "joao.silva@example.com",
      "cpf": "123.456.789-09",
      "telefone": "(11) 98765-4321",
      "endereco": {
        "rua": "Rua das Flores, 123",
        "cidade": "São Paulo",
        "estado": "SP",
        "cep": "01234-567"
      },
      "empresa": "Tech Solutions Ltda",
      "cnpj": "12.345.678/0001-90",
      "data_cadastro": "2023-05-15T10:30:00Z"
    },
    {
      "id": "550e8400-e29b-41d4-a716-446655440001",
      "nome": "Maria Oliveira",
      "email": "maria.oliveira@example.com",
      "cpf": "987.654.321-00",
      "telefone": "(21) 99876-5432",
      "endereco": {
        "rua": "Avenida Brasil, 456",
        "cidade": "Rio de Janeiro",
        "estado": "RJ",
        "cep": "20000-000"
      },
      "empresa": "Inova Sistemas S.A.",
      "cnpj": "98.765.432/0001-21",
      "data_cadastro": "2023-06-20T14:45:00Z"
  }
]</code>
          </pre>
        </div>
      </div>
    </section>

    <!-- Features Section -->
    <section id="features" class="py-16 bg-white">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="text-center mb-16">
          <h2 class="text-3xl font-bold text-gray-900">Recursos do MockGen</h2>
          <p class="mt-4 text-xl text-gray-600 max-w-3xl mx-auto">
            Tudo que você precisa para criar dados de teste realistas
          </p>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-10">
          <!-- Feature 1 -->
          <div
            class="bg-gray-50 p-8 rounded-xl shadow-sm hover:shadow-md transition-shadow"
          >
            <div
              class="w-14 h-14 bg-blue-100 rounded-lg flex items-center justify-center mb-6"
            >
              <svg
                class="w-8 h-8 text-blue-600"
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
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-3">
              Documentos Brasileiros
            </h3>
            <p class="text-gray-600">
              CPF, CNPJ e CEP válidos e formatados conforme as regras
              brasileiras.
            </p>
          </div>

          <!-- Feature 2 -->
          <div
            class="bg-gray-50 p-8 rounded-xl shadow-sm hover:shadow-md transition-shadow"
          >
            <div
              class="w-14 h-14 bg-green-100 rounded-lg flex items-center justify-center mb-6"
            >
              <svg
                class="w-8 h-8 text-green-600"
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
            <h3 class="text-xl font-semibold text-gray-900 mb-3">
              Dados Internacionais
            </h3>
            <p class="text-gray-600">
              Suporte para múltiplos países incluindo EUA, França, Alemanha e
              Itália.
            </p>
          </div>

          <!-- Feature 3 -->
          <div
            class="bg-gray-50 p-8 rounded-xl shadow-sm hover:shadow-md transition-shadow"
          >
            <div
              class="w-14 h-14 bg-purple-100 rounded-lg flex items-center justify-center mb-6"
            >
              <svg
                class="w-8 h-8 text-purple-600"
                fill="none"
                stroke="currentColor"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M10 20l4-16m4 4l4 4-4 4M6 16l-4-4 4-4"
                />
              </svg>
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-3">
              JSON Personalizado
            </h3>
            <p class="text-gray-600">
              Defina a estrutura exata do JSON que você precisa para seus
              testes.
            </p>
          </div>
        </div>
      </div>
    </section>

    <!-- How It Works Section -->
    <section class="py-20 bg-gray-50">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="text-center mb-16">
          <h2 class="text-3xl font-bold text-gray-900">Como Usar o MockGen</h2>
          <p class="mt-4 text-xl text-gray-600 max-w-3xl mx-auto">
            Crie dados mockados em apenas 3 passos simples
          </p>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
          <!-- Step 1 -->
          <div class="flex flex-col items-center text-center">
            <div
              class="w-16 h-16 bg-blue-600 text-white rounded-full flex items-center justify-center text-2xl font-bold mb-4"
            >
              1
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-3">
              Defina seus campos
            </h3>
            <p class="text-gray-600">
              Adicione os atributos que deseja em seu JSON e selecione seus
              tipos.
            </p>
          </div>

          <!-- Step 2 -->
          <div class="flex flex-col items-center text-center">
            <div
              class="w-16 h-16 bg-blue-600 text-white rounded-full flex items-center justify-center text-2xl font-bold mb-4"
            >
              2
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-3">
              Configure as opções
            </h3>
            <p class="text-gray-600">
              Escolha a região, quantidade de itens e outras preferências.
            </p>
          </div>

          <!-- Step 3 -->
          <div class="flex flex-col items-center text-center">
            <div
              class="w-16 h-16 bg-blue-600 text-white rounded-full flex items-center justify-center text-2xl font-bold mb-4"
            >
              3
            </div>
            <h3 class="text-xl font-semibold text-gray-900 mb-3">
              Gere e copie
            </h3>
            <p class="text-gray-600">
              Obtenha seu JSON pronto para usar em seus projetos com um clique.
            </p>
          </div>
        </div>

        <div class="mt-16 text-center">
          <NuxtLink
            to="/gerador"
            class="inline-block px-8 py-4 bg-blue-600 hover:bg-blue-700 text-white font-medium rounded-lg shadow-lg transition-all duration-300 transform hover:scale-105"
          >
            Experimente Agora
          </NuxtLink>
        </div>
      </div>
    </section>

    <!-- Testimonials Section -->
    <section class="py-16 bg-white">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="text-center mb-16">
          <h2 class="text-3xl font-bold text-gray-900">
            O que os desenvolvedores dizem
          </h2>
          <p class="mt-4 text-xl text-gray-600 max-w-3xl mx-auto">
            MockGen está ajudando equipes a acelerar seu desenvolvimento
          </p>
        </div>

        <div class="grid grid-cols-1 md:grid-cols-2 gap-8">
          <!-- Testimonial 1 -->
          <div class="bg-gray-50 p-8 rounded-xl">
            <div class="flex items-center mb-4">
              <div
                class="w-12 h-12 rounded-full bg-blue-100 flex items-center justify-center text-blue-600 font-bold mr-4"
              >
                AC
              </div>
              <div>
                <h4 class="font-semibold text-gray-900">Ana Carolina</h4>
                <p class="text-gray-600 text-sm">Desenvolvedora Front-end</p>
              </div>
            </div>
            <p class="text-gray-700 italic">
              "O MockGen salvou incontáveis horas do nosso time de QA. Gerar
              dados realistas para testar nosso sistema de cadastro nunca foi
              tão fácil."
            </p>
          </div>

          <!-- Testimonial 2 -->
          <div class="bg-gray-50 p-8 rounded-xl">
            <div class="flex items-center mb-4">
              <div
                class="w-12 h-12 rounded-full bg-green-100 flex items-center justify-center text-green-600 font-bold mr-4"
              >
                RS
              </div>
              <div>
                <h4 class="font-semibold text-gray-900">Ricardo Silva</h4>
                <p class="text-gray-600 text-sm">Arquiteto de Software</p>
              </div>
            </div>
            <p class="text-gray-700 italic">
              "Finalmente uma ferramenta que entende as necessidades do mercado
              brasileiro. Os documentos gerados passam em todas as validações."
            </p>
          </div>
        </div>
      </div>
    </section>

    <!-- CTA Section -->
    <section class="py-20 bg-gradient-to-r from-blue-600 to-blue-800">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 text-center">
        <h2 class="text-3xl font-bold text-white mb-6">Pronto para começar?</h2>
        <p class="text-xl text-blue-100 max-w-3xl mx-auto mb-10">
          Crie dados de teste em segundos e acelere seu desenvolvimento.
        </p>
        <div class="flex flex-col sm:flex-row justify-center gap-4">
          <NuxtLink
            to="/gerador"
            class="inline-block px-8 py-4 bg-white hover:bg-gray-100 text-blue-600 font-medium rounded-lg shadow-lg transition-all duration-300 transform hover:scale-105"
          >
            Usar Gerador
          </NuxtLink>
          <NuxtLink
            to="/sobre"
            class="inline-block px-8 py-4 border-2 border-white text-white hover:bg-white hover:text-blue-600 hover:bg-opacity-10 font-medium rounded-lg transition-all duration-300"
          >
            Conheça Mais
          </NuxtLink>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: "IndexPage",
  head() {
    return {
      title: "MockGen - Gerador de Dados Mockados para Desenvolvimento",
      meta: [
        {
          hid: "description",
          name: "description",
          content:
            "Gere dados fictícios em JSON para testes e desenvolvimento. CPF, CNPJ, CEP válidos e suporte para múltiplos países. Ferramenta essencial para desenvolvedores.",
        },
      ],
    };
  },
  methods: {
    smoothScrollTo(target) {
      const element = document.querySelector(target);
      if (element) {
        element.scrollIntoView({
          behavior: "smooth",
          block: "start",
        });
      }
    },
  },
};
</script>

<style scoped>
html {
  scroll-behavior: smooth;
}

:target {
  scroll-margin-top: 100px;
  padding-top: 100px;
  margin-top: -100px; 
}
</style>
