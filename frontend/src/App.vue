<template>
  <div id="app">
    <h1>BlogPost</h1>
    <PostList />
  </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import { Inject } from 'vue-property-decorator';
import { RSocketService } from './services/RSocketService';
import PostList from './components/PostList.vue';

@Options({
  components: {
    PostList
  }
})
export default class App extends Vue {
  @Inject('rSocketService') private rSocketService!: RSocketService;

  // Другие методы и свойства компонента
}
</script>

<style scoped>
/* Стили компонента */
</style>
