<template>
  <div>
    <v-card
        class="mx-auto"
        max-width="450"
    >
      <v-card-title class="justify-center">
        <h1 class="mt-4 mb-4 text-h4">Авторизация</h1>
      </v-card-title>
      <v-card-text>
        <v-form
            ref="login-form"
        >
          <v-text-field
              v-model="loginForm.username"
              label="Логин"
              required
              outlined
          ></v-text-field>

          <v-text-field
              v-model="loginForm.password"
              label="Пароль"
              required
              outlined
          ></v-text-field>

          <div class="mb-4 text-center">
            <v-btn
                color="primary"
                class="mb-4 v-btn--block"
                large
            >
              Войти
            </v-btn>

            <router-link :to="{name: 'register'}">Зарегистрироваться</router-link>
          </div>
        </v-form>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>

export default {
  name: 'Login',
  data: () => ({
    loginForm: {}
  })
}

</script>