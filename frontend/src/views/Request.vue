<template>
  <div>
    <h1>Запросы</h1>
    {{content}}
  </div>
</template>

<script>
import UserService from '../services/user.service';

export default {
  name: 'Request',
  data() {
    return {
      content: ''
    };
  },
  mounted() {
    UserService.getUserBoard().then(
        response => {
          this.content = response.data;
        },
        error => {
          this.content =
              (error.response && error.response.data) ||
              error.message ||
              error.toString();
        }
    );
  }
}
</script>