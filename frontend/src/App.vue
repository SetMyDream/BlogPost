<template>
  <div id="app">
    <h1>BlogPost</h1>
    <PostList />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { PostPreview, PostList } from './components';
import PostDetails from './components/PostDetails.vue';

export default defineComponent({
  name: 'App',
  components: {
    PostDetails,
    PostPreview,
    PostList
  },
});
</script>

<style scoped>
/* Стили компонента */
</style>
