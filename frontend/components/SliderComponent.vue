<template>
  <div ref="containerRef" class="flex gap-5 max-sm:gap-0 w-full relative">
    <button
      v-if="showNavigation && !insideArrow"
      class="flex items-center z-10"
      @click="slidePrev"
    >
      <svg
        class="w-6 h-6"
        :class="[colorArrow, { 'opacity-50 hover:opacity-75': grayScaleArrow }]"
        fill="none"
        stroke="currentColor"
        viewBox="0 0 24 24"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          d="M15 19l-7-7 7-7"
        />
      </svg>
    </button>

    <swiper
      :class="[
        withThumbs && pagination && navItems && !insideArrow ? 'pb-14' : '',
        fullScreen ? 'w-full h-screen' : '',
      ]"
      :modules="modules"
      :slides-per-view="itemsPerSlide"
      :space-between="gutter"
      :grid="gridOptions"
      :pagination="paginationOptions"
      :loop="loopInfinite"
      :slides-per-group="qttScroll"
      class="swiper-container w-full"
      @swiper="onSwiper"
    >
      <swiper-slide
        v-for="(item, index) in items"
        :key="index"
        class="flex justify-center items-center"
      >
        <slot v-if="item" :item="item" :index="index" />
      </swiper-slide>
    </swiper>

    <button
      v-if="showNavigation && !insideArrow"
      class="flex items-center z-10"
      @click="slideNext"
    >
      <svg
        class="w-6 h-6"
        :class="[colorArrow, { 'opacity-50 hover:opacity-75': grayScaleArrow }]"
        fill="none"
        stroke="currentColor"
        viewBox="0 0 24 24"
      >
        <path
          stroke-linecap="round"
          stroke-linejoin="round"
          stroke-width="2"
          d="M9 5l7 7-7 7"
        />
      </svg>
    </button>

    <div v-if="withThumbs && pagination" class="swiper-pagination" />
  </div>
</template>

<script setup>
import { ref, computed, onMounted, onBeforeUnmount } from "vue";
import { Swiper, SwiperSlide } from "swiper/vue";
import { Grid, Pagination } from "swiper/modules";
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/grid";

const props = defineProps({
  items: {
    type: Array,
    default: () => [],
  },
  withThumbs: {
    type: Boolean,
    default: true,
  },
  insideArrow: {
    type: Boolean,
    default: false,
  },
  navItems: {
    type: Boolean,
    default: true,
  },
  colorArrow: {
    type: String,
    default: "text-blue-600",
  },
  grayScaleArrow: {
    type: Boolean,
    default: false,
  },
  fullScreen: {
    type: Boolean,
    default: false,
  },
  qttItemsLg: {
    type: Number,
    default: 4,
  },
  qttItemsMd: {
    type: Number,
    default: 3,
  },
  qttItemsSm: {
    type: Number,
    default: 2,
  },
  qttItemsXs: {
    type: Number,
    default: 1,
  },
  qttRows: {
    type: Number,
    default: 1,
  },
  gutter: {
    type: Number,
    default: 32,
  },
  loopInfinite: {
    type: Boolean,
    default: true,
  },
  autoScroll: {
    type: Boolean,
    default: false,
  },
  timerScroll: {
    type: Number,
    default: 3000,
  },
  fullScroll: {
    type: Boolean,
    default: false,
  },
  qttScroll: {
    type: Number,
    default: 1,
  },
});

const swiperInstance = ref(null);
const containerRef = ref(null);
const itemsPerSlide = ref(props.qttItemsLg);
const pagination = ref(true);
let autoScrollInterval = null;

const modules = [Pagination, Grid];

const gridOptions = computed(() => {
  return props.qttRows > 1 ? { rows: props.qttRows, fill: "row" } : undefined;
});

const paginationOptions = computed(() => ({
  type: "bullets",
  el: ".swiper-pagination",
  clickable: true,
  enabled: props.withThumbs && pagination.value,
}));

const showNavigation = computed(() => {
  return props.navItems && props.items.length > itemsPerSlide.value;
});

const onSwiper = (swiper) => {
  swiperInstance.value = swiper;
};

const slideNext = () => {
  swiperInstance.value?.slideNext();
};

const slidePrev = () => {
  swiperInstance.value?.slidePrev();
};

const startAutoScroll = () => {
  if (props.autoScroll) {
    autoScrollInterval = setInterval(() => {
      if (props.fullScroll) slideNext();
      else Array.from({ length: props.qttScroll }).forEach(() => slideNext());
    }, props.timerScroll);
  }
};

const updateItemsPerSlide = () => {
  const width = containerRef.value?.offsetWidth || 1024;
  if (width >= 1024) itemsPerSlide.value = props.qttItemsLg;
  else if (width >= 768) itemsPerSlide.value = props.qttItemsMd;
  else if (width >= 640) {
    itemsPerSlide.value = props.qttItemsSm;
    pagination.value = true;
  } else {
    itemsPerSlide.value = props.qttItemsXs;
    pagination.value = false;
  }
};

onMounted(() => {
  updateItemsPerSlide();
  window.addEventListener("resize", updateItemsPerSlide);
  startAutoScroll();
});

onBeforeUnmount(() => {
  window.removeEventListener("resize", updateItemsPerSlide);
  if (autoScrollInterval) clearInterval(autoScrollInterval);
});
</script>

<style scoped>
.swiper-container {
  width: 100%;
  padding-bottom: 30px;
}

.swiper-pagination {
  position: relative;
  margin-top: 2rem;
}

/* Estilizando os bullets do paginador */
:deep(.swiper-pagination-bullet) {
  width: 0.75rem;
  height: 0.75rem;
  background-color: rgb(209, 213, 219);
  opacity: 1;
}

:deep(.swiper-pagination-bullet-active) {
  background-color: rgb(37, 99, 235);
  transform: scale(1.25);
}
</style>
