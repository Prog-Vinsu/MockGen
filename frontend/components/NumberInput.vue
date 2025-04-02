<template>
  <div
    class="flex items-center border border-gray-300 rounded-lg overflow-hidden bg-white shadow-sm"
  >
    <button
      class="px-3 py-3 bg-gray-50 hover:bg-gray-100 text-gray-600 border-r border-gray-200 transition-all duration-200 disabled:opacity-40 disabled:cursor-not-allowed"
      :disabled="modelValue <= min"
      @click="decrease"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        class="h-4 w-4"
        fill="none"
        viewBox="0 0 24 24"
        stroke="currentColor"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          d="M20 12H4"
        />
      </svg>
    </button>
    <input
      type="number"
      :value="modelValue"
      :min="min"
      :max="max"
      class="w-12 pl-4 text-center py-2 focus:outline-none focus:ring-0 focus:ring-blue-500/30 bg-white text-gray-700 font-medium"
      @input="updateValue($event)"
    />
    <button
      class="px-3 py-3 bg-gray-50 hover:bg-gray-100 text-gray-600 border-l border-gray-200 transition-all duration-200 disabled:opacity-40 disabled:cursor-not-allowed"
      :disabled="modelValue >= max"
      @click="increase"
    >
      <svg
        xmlns="http://www.w3.org/2000/svg"
        class="h-4 w-4"
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
</template>

<script>
export default {
  name: "NumberInput",
  props: {
    modelValue: {
      type: Number,
      default: 1,
    },
    min: {
      type: Number,
      default: 1,
    },
    max: {
      type: Number,
      default: 50,
    },
  },
  emits: ["update:modelValue"],
  methods: {
    updateValue(event) {
      let value = parseInt(event.target.value) || this.min;
      value = Math.min(Math.max(value, this.min), this.max);
      this.$emit("update:modelValue", value);
    },
    increase() {
      if (this.modelValue < this.max) {
        this.$emit("update:modelValue", this.modelValue + 1);
      }
    },
    decrease() {
      if (this.modelValue > this.min) {
        this.$emit("update:modelValue", this.modelValue - 1);
      }
    },
  },
};
</script>
