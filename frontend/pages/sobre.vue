<template>
  <div class="min-h-screen bg-gradient-to-br from-gray-50 to-blue-50 py-12">
    <div class="container mx-auto px-4 max-w-6xl">
      <!-- Cabeçalho Hero -->
      <div class="text-center mb-16 animate-fade-in">
        <h1 class="text-4xl md:text-5xl font-bold text-gray-900 mb-4 mt-16">
          Sobre o Mock<span class="text-blue-600">Gen</span>
        </h1>
        <p class="text-xl text-gray-600 max-w-2xl mx-auto">
          Solução completa para geração de dados fictícios em aplicações
          modernas
        </p>
      </div>

      <!-- Seção de Destaques -->
      <div class="grid md:grid-cols-3 gap-8 mb-16">
        <div
          class="feature-card p-6 bg-white rounded-xl shadow-lg hover:shadow-xl transition-shadow"
        >
          <div
            class="w-12 h-12 bg-blue-100 rounded-lg mb-4 flex items-center justify-center"
          >
            <svg
              class="w-6 h-6 text-blue-600"
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
          </div>
          <h3 class="text-xl font-semibold mb-2">Internacionalização</h3>
          <p class="text-gray-600">
            Dados regionais para Brasil, EUA, França, Alemanha e Itália
          </p>
        </div>

        <div
          class="feature-card p-6 bg-white rounded-xl shadow-lg hover:shadow-xl transition-shadow"
        >
          <div
            class="w-12 h-12 bg-green-100 rounded-lg mb-4 flex items-center justify-center"
          >
            <svg
              class="w-6 h-6 text-green-600"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M4 6h16M4 12h16m-7 6h7"
              />
            </svg>
          </div>
          <h3 class="text-xl font-semibold mb-2">Documentos Válidos</h3>
          <p class="text-gray-600">
            CPF, CNPJ e CEP brasileiros com formatação e validação
          </p>
        </div>

        <div
          class="feature-card p-6 bg-white rounded-xl shadow-lg hover:shadow-xl transition-shadow"
        >
          <div
            class="w-12 h-12 bg-purple-100 rounded-lg mb-4 flex items-center justify-center"
          >
            <svg
              class="w-6 h-6 text-purple-600"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                stroke-width="2"
                d="M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z"
              />
            </svg>
          </div>
          <h3 class="text-xl font-semibold mb-2">Tipos Diversificados</h3>
          <p class="text-gray-600">
            15+ tipos de dados incluindo UUID, cores, URLs e datas
          </p>
        </div>
      </div>

      <!-- Seção Missão/Visão -->
      <div class="grid md:grid-cols-2 gap-12 mb-16">
        <div class="mission-card bg-blue-600 p-8 rounded-2xl text-white">
          <h2 class="text-2xl font-bold mb-4">Como Funciona</h2>
          <p class="opacity-90 leading-relaxed">
            Nosso sistema combina a biblioteca Java Faker com geradores
            customizados para documentos brasileiros, processando requisições
            via API REST. Você define o schema com tipos, quantidades e regiões,
            e recebe dados prontos para uso em desenvolvimento e testes.
          </p>
        </div>

        <div class="vision-card bg-white p-8 rounded-2xl shadow-lg">
          <h2 class="text-2xl font-bold mb-4 text-gray-900">Casos de Uso</h2>
          <ul class="text-gray-600 leading-relaxed list-disc pl-5 space-y-2">
            <li>Popular bancos de dados para desenvolvimento</li>
            <li>Testes automatizados e QA</li>
            <li>Prototipação de interfaces</li>
            <li>Demonstrações e ambientes de treinamento</li>
          </ul>
        </div>
      </div>

      <!-- Stack Tecnológica -->
      <div class="bg-white rounded-2xl shadow-lg p-8 mb-16">
        <h2 class="text-2xl font-bold text-gray-900 mb-6">
          Tecnologias Utilizadas
        </h2>
        <div class="grid grid-cols-2 md:grid-cols-4 gap-4">
          <div class="tech-item p-4 border rounded-lg text-center">
            <div class="text-blue-600 font-bold">Spring Boot</div>
            <div class="text-sm text-gray-500">Backend API</div>
          </div>
          <div class="tech-item p-4 border rounded-lg text-center">
            <div class="text-blue-600 font-bold">Java Faker</div>
            <div class="text-sm text-gray-500">Dados internacionais</div>
          </div>
          <div class="tech-item p-4 border rounded-lg text-center">
            <div class="text-blue-600 font-bold">Vue 3</div>
            <div class="text-sm text-gray-500">Frontend</div>
          </div>
          <div class="tech-item p-4 border rounded-lg text-center">
            <div class="text-blue-600 font-bold">Tailwind CSS</div>
            <div class="text-sm text-gray-500">Estilização</div>
          </div>
        </div>
      </div>

      <!-- Timeline de Recursos -->
      <div class="bg-white rounded-2xl shadow-lg p-8">
        <h2 class="text-2xl font-bold text-gray-900 mb-8">
          Próximas Atualizações
        </h2>
        <div class="space-y-8">
          <!-- <div class="timeline-item">
            <div class="flex items-center mb-2">
              <div class="w-3 h-3 bg-green-500 rounded-full mr-3" />
              <h3 class="font-semibold text-gray-900">API Pública</h3>
            </div>
            <p class="text-gray-600 ml-6">
              Endpoint RESTful para integração direta em seus projetos
            </p>
          </div>
          <div class="timeline-item">
            <div class="flex items-center mb-2">
              <div class="w-3 h-3 bg-blue-500 rounded-full mr-3" />
              <h3 class="font-semibold text-gray-900">
                Exportação Multi-Formato
              </h3>
            </div>
            <p class="text-gray-600 ml-6">
              Suporte a CSV, JSON e XML com download direto
            </p>
          </div> -->
          <div class="timeline-item">
            <div class="flex items-center mb-2">
              <div class="w-3 h-3 bg-yellow-500 rounded-full mr-3" />
              <h3 class="font-semibold text-gray-900">Novos Países</h3>
            </div>
            <p class="text-gray-600 ml-6">
              Expansão para Reino Unido, Espanha, Japão, Etc...
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "AboutPage",
};
</script>

<style scoped>
.animate-fade-in {
  animation: fadeIn 0.4s ease-out;
}

@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.feature-card:hover {
  transform: translateY(-5px);
  transition: transform 0.3s ease;
}

.mission-card {
  background-image: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
}

.timeline-item {
  position: relative;
}

.timeline-item:not(:last-child):after {
  content: "";
  position: absolute;
  left: 5px;
  top: 24px;
  bottom: -28px;
  width: 2px;
  background: #e5e7eb;
}
</style>
