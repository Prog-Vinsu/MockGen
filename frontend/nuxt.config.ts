// https://nuxt.com/docs/api/configuration/nuxt-config
import type { ModuleOptions } from "@nuxt/content";
import tailwindcss from "@tailwindcss/vite";

export default defineNuxtConfig({
  app: {
    pageTransition: { name: 'page', mode: 'out-in' },
    layoutTransition: { name: 'layout', mode: 'out-in' },
    head: {
      title: 'MockGen - Gerador de Dados Mockados',
      link: [
        { rel: 'icon', type: 'image/svg+xml', href: '/favicon.ico' }, 
        { rel: 'apple-touch-icon', href: '/apple-touch-icon.png' },
        { rel: 'mask-icon', href: '/safari-pinned-tab.svg', color: '#3b82f6' }
      ],
      meta: [
        { name: 'msapplication-TileColor', content: '#3b82f6' },
        { name: 'theme-color', content: '#3b82f6' }
      ]
    }
  },
  
  devtools: { enabled: true },
  css: ['~/assets/css/main.css'],

  modules: [
    '@nuxt/content',
    '@nuxt/eslint',
    '@nuxt/fonts',
    '@nuxt/icon',
    '@nuxt/image',
    '@nuxt/scripts',
  ],
  content: {
    documentDriven: true,
    experimental: {
      nativeSqlite: false
    }
  } as unknown as Partial<ModuleOptions>,

  vite: {
    plugins: [
      tailwindcss(),
    ],
  },

  compatibilityDate: '2025-03-31',
})