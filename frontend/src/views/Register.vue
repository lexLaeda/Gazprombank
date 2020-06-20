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
            ref="regForm"
            v-model="valid"
            lazy-validation
        >
          <v-text-field
              v-model="user.username"
              label="Логин"
              :rules="[rules.required]"
              required
              outlined
          ></v-text-field>

          <v-text-field
              v-model="user.email"
              label="E-mail"
              :rules="[rules.required, rules.email]"
              required
              outlined
          ></v-text-field>

          <v-text-field
              v-model="user.password"
              :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
              :rules="[rules.required, rules.min]"
              :type="showPassword ? 'text' : 'password'"
              label="Пароль"
              :hint="passwordMessage"
              @click:append="showPassword = !showPassword"
              outlined
          ></v-text-field>

          <div class="mb-4 text-center">
            <v-btn
                color="primary"
                class="mb-4 v-btn--block"
                large
                :disabled="!valid"
                @click="submit"
            >
              Зарегистрироваться
            </v-btn>

            <router-link :to="{name: 'login'}">Уже есть аккаунт?</router-link>

            <div class="mt-4 mb-4" v-if="message">
              {{message}}
            </div>
          </div>
        </v-form>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>

import User from "../models/user";

export default {
  name: 'Register',
  data: () => ({
    user: new User('', '', ''),
    message: '',
    valid: true,
    showPassword: false,
    passwordMessage: 'Минимум 8 символов',
    rules: {
      required: value => !!value || 'Обязательное поле',
      min: v => v.length >= 8 || 'Минимум 8 символов',
      email: v => /.+@.+\..+/.test(v) || 'Введите email'
    }
  }),
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    submit() {
      this.message = '';
      this.$refs.regForm.validate();
      this.$store.dispatch('auth/register', this.user).then(
          data => {
            this.message = data.message;
          },
          error => {
            this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
          }
      );
    }
  }
}

</script>