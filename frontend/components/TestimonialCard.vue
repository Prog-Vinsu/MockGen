<template>
  <div
    class="bg-white p-8 rounded-xl shadow-lg hover:shadow-xl transition-shadow duration-300 h-full flex flex-col"
  >
    <div class="flex items-start mb-6">
      <div
        class="w-14 h-14 rounded-full flex items-center justify-center text-xl font-bold mr-4 flex-shrink-0"
        :class="color"
      >
        {{ initials }}
      </div>
      <div>
        <h4 class="font-semibold text-gray-900 text-lg">{{ name }}</h4>
        <p class="text-gray-600 text-sm">{{ role }}</p>
        <div class="mt-1 flex items-center">
          <span class="text-blue-600 text-sm font-medium">{{ company }}</span>
          <!-- <span class="mx-2 text-gray-400">•</span> -->
          <span class="text-gray-500 text-sm">{{ country }}</span>
        </div>
      </div>
    </div>

    <div class="flex-grow flex flex-col justify-between">
      <p class="text-gray-700 italic leading-relaxed">"{{ truncatedText }}"</p>

      <div class="mt-6 flex items-center justify-end">
        <div class="flex space-x-1 text-yellow-400">
          <svg
            v-for="star in 5"
            :key="star"
            class="w-5 h-5 fill-current"
            viewBox="0 0 20 20"
          >
            <path
              d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"
            />
          </svg>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    name: {
      type: String,
      required: true,
    },
    role: {
      type: String,
      required: true,
    },
    company: {
      type: String,
      required: true,
    },
    country: {
      type: String,
      required: true,
    },
    text: {
      type: String,
      required: true,
    },
    initials: {
      type: String,
      required: true,
    },
    color: {
      type: String,
      default: "bg-blue-100 text-blue-600",
    },
    maxLength: {
      type: Number,
      default: 180,
    },
  },
  computed: {
    truncatedText() {
      if (this.text.length <= this.maxLength) {
        return this.text;
      }
      return this.text.substring(0, this.maxLength) + "...";
    },
  },
};
</script>
