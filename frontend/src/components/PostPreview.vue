<template>
    <div class="post-preview">
      <h3>{{ post.title }}</h3>
      <p>By {{ post.author }}</p>
      <p>{{ post.contentPreview }}</p>
      <button @click="expandPost">Read More</button>
    </div>
  </template>
  
  <script>
  import { Component, Prop, Vue } from 'vue-property-decorator';
  
  @Component
  export default class PostPreview extends Vue {
    @Prop() post!: any;
  
    expandPost() {
      // Emit an event to notify the parent component to expand the post
      this.$emit('expand-post', this.post.id);
    }
  }
  </script>
  
  <style scoped>
  .post-preview {
    margin-bottom: 20px;
  }
  </style>
  