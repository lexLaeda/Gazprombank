<template>
  <div>
    <v-card
        class="mx-auto"
        max-width="450"
    >
      <v-card-title class="justify-center">
        <h1 class="mt-4 mb-4 text-h4">Регистрация</h1>
      </v-card-title>
      <v-card-text>
        <v-form
            ref="reg-form"
        >
          <v-text-field
              v-model="regForm.username"
              label="Логин"
              required
              outlined
          ></v-text-field>

          <v-text-field
              v-model="regForm.email"
              label="E-mail"
              required
              outlined
          ></v-text-field>

          <v-text-field
              v-model="regForm.password"
              label="Пароль"
              required
              outlined
          ></v-text-field>

          <v-text-field
              v-model="regForm.password2"
              label="Подтверждение пароля"
              required
              outlined
          ></v-text-field>

          <div class="mb-4 text-center">
            <v-btn
                color="primary"
                class="mb-4 v-btn--block"
                large
            >
              Зарегистрироваться
            </v-btn>

            <router-link :to="{name: 'login'}">Уже есть аккаунт?</router-link>
          </div>
        </v-form>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>

export default {
  name: 'Register',
  data: () => ({
    regForm: {}
  })
}

</script>