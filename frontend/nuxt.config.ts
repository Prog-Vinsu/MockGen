// https://nuxt.com/docs/api/configuration/nuxt-config
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
      ],
      script: [
        {
          src: 'https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js',
          'data-ad-client': 'ca-pub-1424643380498076',
          async: true,
          crossorigin: 'anonymous'
        }
      ]
    }
  },
  
  devtools: { enabled: true },
  css: ['~/assets/css/main.css'],

  modules: [
    '@nuxt/eslint',
    '@nuxt/fonts',
    '@nuxt/icon',
    '@nuxt/image',
    '@nuxt/scripts',
  ],

  vite: {
    plugins: [
      tailwindcss(),
    ],
  },

  compatibilityDate: '2025-03-31',
})