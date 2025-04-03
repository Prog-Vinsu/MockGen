<template>
  <div class="min-h-screen bg-gradient-to-br from-gray-50 to-blue-50 py-12">
    <div class="container mx-auto px-4 max-w-4xl">
      <!-- Cabeçalho -->
      <div class="text-center mb-8 animate-fade-in">
        <h1 class="text-3xl md:text-4xl font-bold text-gray-900 mb-2">
          Gerador de Dados <span class="text-blue-600">Mockados</span>
        </h1>
        <p class="text-gray-600 max-w-lg mx-auto">
          Crie dados fictícios personalizados para seus projetos de
          desenvolvimento e teste
        </p>
      </div>

      <!-- Formulário para adicionar atributos -->
      <div class="w-full mb-8 bg-white p-6 rounded-2xl shadow-lg">
        <h2 class="text-xl font-semibold mb-4 text-gray-800">
          Adicionar novo atributo
        </h2>
        <div class="grid grid-cols-1 md:grid-cols-12 gap-4 items-end">
          <div class="md:col-span-4">
            <label
              for="attributeInput"
              class="block text-sm font-medium text-gray-700 mb-1"
              >Nome do Atributo</label
            >
            <input
              id="attributeInput"
              ref="attributeInput"
              v-model="newAttribute"
              type="text"
              placeholder="Ex: nome_completo"
              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
              @keyup.enter="addAttribute"
            />
          </div>

          <div class="md:col-span-2">
            <label
              for="typeSelect"
              class="block text-sm font-medium text-gray-700 mb-1"
              >Tipo</label
            >
            <select
              id="typeSelect"
              v-model="newType"
              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
            >
              <option value="name">Nome</option>
              <option value="email">Email</option>
              <option value="number">Número</option>
              <option value="date">Data</option>
              <option value="address">Endereço</option>
              <option value="text">Texto</option>
              <option value="cpf">CPF</option>
              <option value="cnpj">CNPJ</option>
              <option value="phone">Telefone</option>
              <option value="cep">CEP</option>
              <option value="uuid">UUID</option>
              <option value="color">Cor</option>
              <option value="url">URL</option>
              <option value="datetime">Data e Hora</option>
            </select>
          </div>

          <div class="md:col-span-3">
            <label
              for="regionSelect"
              class="block text-sm font-medium text-gray-700 mb-1"
              >Região</label
            >
            <select
              id="regionSelect"
              v-model="region"
              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
            >
              <option value="pt-BR">Brasil</option>
              <option value="en-US">Estados Unidos</option>
              <option value="fr-FR">França</option>
              <option value="de-DE">Alemanha</option>
              <option value="it-IT">Itália</option>
            </select>
          </div>

          <div class="md:col-span-2">
            <label
              for="quantityInput"
              class="block text-sm font-medium text-gray-700 mb-1"
              >Quantidade</label
            >
            <input
              id="quantityInput"
              v-model="newQuantity"
              type="number"
              min="1"
              class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition-all"
              @keyup.enter="addAttribute"
            />
          </div>

          <div class="md:col-span-1">
            <button
              class="w-full bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded-lg font-medium transition-all duration-200 transform hover:scale-105 active:scale-95"
              @click="addAttribute"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-5 w-5 mx-auto"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M12 6v6m0 0v6m0-6h6m-6 0H6"
                />
              </svg>
            </button>
          </div>
        </div>

        <div v-if="error" class="mt-3 text-red-500 text-sm font-medium">
          {{ error }}
        </div>
      </div>

      <!-- Lista de atributos -->
      <AttributeList
        :attributes="schema"
        empty-message="Adicione atributos para gerar dados mockados"
        :removable="true"
        :editable="true"
        :show-count="true"
        @edit="editAttribute"
        @remove="removeAttribute"
      />

      <!-- Controles de geração -->
      <div class="w-full mb-8 bg-white p-6 rounded-2xl shadow-lg">
        <div
          class="flex flex-col md:flex-row items-center justify-between gap-4"
        >
          <div class="flex items-center gap-4 w-full md:w-auto">
            <label
              for="quantityJsonInput"
              class="text-sm font-medium text-gray-700"
              >Quantidade de JSONs</label
            >
            <NumberInput v-model="newQuantityJson" :min="1" :max="50" />
          </div>

          <button
            :disabled="Object.keys(schema).length === 0"
            class="w-full md:w-auto bg-green-600 hover:bg-green-700 text-white px-6 py-3 rounded-lg font-medium transition-all duration-200 transform hover:scale-105 active:scale-95 disabled:opacity-50 disabled:cursor-not-allowed disabled:transform-none"
            @click="generateMockData"
          >
            <div class="flex items-center justify-center gap-2">
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
              Gerar JSON
            </div>
          </button>
        </div>
      </div>

      <!-- Saída do JSON -->
      <div v-if="mockData" class="w-full bg-white p-6 rounded-2xl shadow-lg">
        <div class="flex justify-between items-center mb-4">
          <h2 class="text-xl font-semibold text-gray-800">Dados Gerados</h2>
          <button
            class="bg-blue-600 hover:bg-blue-700 text-white px-4 py-2 rounded-lg font-medium transition-all duration-200 transform hover:scale-105 active:scale-95 flex items-center gap-2"
            @click="copyToClipboard"
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
                d="M8 5H6a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2v-1M8 5a2 2 0 002 2h2a2 2 0 002-2M8 5a2 2 0 012-2h2a2 2 0 012 2m0 0h2a2 2 0 012 2v3m2 4H10m0 0l3-3m-3 3l3 3"
              />
            </svg>
            Copiar
          </button>
        </div>

        <pre
          class="language-json bg-gray-50 p-4 rounded-lg overflow-x-auto border border-gray-200 text-sm"
        ><code v-html="highlightedJson"/></pre>
      </div>
    </div>
  </div>
</template>

<script>
import {
  defineComponent,
  ref,
  reactive,
  computed,
  onMounted,
  nextTick,
} from "vue";
import axios from "axios";
import AttributeList from "./AttributeList.vue";
import Prism from "prismjs";
import "prismjs/themes/prism-solarizedlight.css";
import "prismjs/components/prism-json";
import "prismjs/plugins/line-numbers/prism-line-numbers";

export default defineComponent({
  components: {
    AttributeList,
  },
  setup() {
    const newAttribute = ref("");
    const newType = ref("name");
    const region = ref("pt-BR");
    const newQuantity = ref(1);
    const newQuantityJson = ref(1);
    const schema = reactive({});
    const mockData = ref(null);
    const error = ref("");
    const attributeInput = ref(null);

    onMounted(() => {
      if (attributeInput.value) {
        attributeInput.value.focus();
      }
    });

    const addAttribute = () => {
      const trimmedAttribute = newAttribute.value.trim();

      if (!trimmedAttribute) {
        error.value = "Por favor, digite um nome de atributo válido.";
        return;
      }

      if (schema[trimmedAttribute]) {
        error.value = `Atributo "${trimmedAttribute}" já existe.`;
        return;
      }

      const quantity = parseInt(newQuantity.value, 10) || 1;

      schema[trimmedAttribute] = {
        type: newType.value,
        region: region.value,
        quantity,
      };
      newAttribute.value = "";
      newQuantity.value = 1;

      nextTick(() => {
        if (attributeInput.value) {
          attributeInput.value.focus();
        }
      });
    };

    const editAttribute = (attr) => {
      if (!schema[attr]) {
        error.value = `Atributo "${attr}" não encontrado.`;
        return;
      }

      newAttribute.value = attr;
      newType.value = schema[attr].type;
      region.value = schema[attr].region;
      newQuantity.value = schema[attr].quantity;

      removeAttribute(attr);

      nextTick(() => {
        if (attributeInput.value) {
          attributeInput.value.focus();
        }
      });
    };

    const removeAttribute = (attr) => {
      const newSchema = {};
      Object.entries(schema).forEach(([key, value]) => {
        if (key !== attr) {
          newSchema[key] = value;
        }
      });

      Object.keys(schema).forEach((key) => {
        delete schema[key];
      });

      Object.assign(schema, newSchema);
    };

    const generateMockData = async () => {
      if (Object.keys(schema).length === 0) {
        error.value = "Adicione pelo menos um atributo antes de gerar o JSON.";
        return;
      }

      const quantityJson = Math.max(
        1,
        Math.min(parseInt(newQuantityJson.value) || 1, 100)
      );
      newQuantityJson.value = quantityJson;

      const payload = {
        quantityJson,
        attributes: schema,
      };

      try {
        const response = await axios.post(
          "http://localhost:8080/api/mock",
          payload,
          {
            headers: { "Content-Type": "application/json" },
          }
        );

        mockData.value = JSON.stringify(response.data, null, 2);
        error.value = "";
      } catch (err) {
        console.error(
          "Erro ao gerar dados mockados:",
          err.response ? err.response.data : err.message
        );
        error.value =
          "Erro ao gerar dados mockados. Verifique o console para mais detalhes.";
        mockData.value = null;
      }
    };

    const copyToClipboard = () => {
      if (mockData.value) {
        navigator.clipboard
          .writeText(mockData.value)
          .then(() => {
            alert("JSON copiado para o clipboard!");
          })
          .catch((err) => {
            console.error("Erro ao copiar para o clipboard:", err);
            error.value = "Não foi possível copiar para o clipboard.";
          });
      }
    };

    const highlightedJson = computed(() => {
      if (!mockData.value) return "";
      return Prism.highlight(mockData.value, Prism.languages.json, "json");
    });

    return {
      newAttribute,
      newType,
      region,
      newQuantity,
      newQuantityJson,
      schema,
      mockData,
      error,
      attributeInput,
      addAttribute,
      editAttribute,
      removeAttribute,
      generateMockData,
      copyToClipboard,
      highlightedJson,
    };
  },
});
</script>

<style scoped>
.animate-fade-in {
  animation: fadeIn 0.4s ease-out forwards;
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

pre {
  font-family: "Fira Code", "Courier New", Courier, monospace;
  line-height: 1.5;
  tab-size: 2;
}

pre code {
  display: block;
  overflow-x: auto;
  padding: 1em;
}

pre[class*="language-"] {
  background-color: #f9f9f9;
  border: 1px solid #e1e4e8;
  border-radius: 0.5rem;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1);
}

.token.comment,
.token.prolog,
.token.doctype,
.token.cdata {
  color: #9a9a9a;
}

.token.punctuation {
  color: #6b6b6b;
}

.token.property,
.token.tag,
.token.boolean,
.token.number,
.token.constant,
.token.symbol,
.token.deleted {
  color: #2f6f9f;
}

.token.selector,
.token.attr-name,
.token.string,
.token.char,
.token.builtin,
.token.inserted {
  color: #4f9f4f;
}

.token.operator,
.token.entity,
.token.url,
.language-css .token.string,
.style .token.string {
  color: #d77206;
}

.token.atrule,
.token.attr-value,
.token.keyword {
  color: #0077aa;
}

.token.function,
.token.class-name {
  color: #dd4a68;
}

.token.regex,
.token.important,
.token.variable {
  color: #ee9900;
}
</style>
