<template>
  <div class="post-details">
    <h2>{{ post.title }}</h2>
    <p>By {{ post.author }}</p>
    <p>{{ post.content }}</p>
  </div>
</template>

<script>
import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class PostDetails extends Vue {
  @Prop() post!: any;
}
</script>

<style scoped>
.post-details {
  margin-bottom: 20px;
}
</style>
