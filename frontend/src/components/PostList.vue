<template>
    <div>
      <PostPreview v-for="post in posts" :key="post.id" :post="post" @expand-post="expandPost" />
    </div>
  </template>
  
  <script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import { RSocketClient } from 'rsocket-core';
  import { JsonSerializer, BufferEncoders } from 'rsocket-core/build';
  import RSocketWebSocketClient from 'rsocket-websocket-client';
  import { ReactiveSocket } from 'rsocket-types';
  
  @Component
  export default class PostList extends Vue {
    private rsocket: ReactiveSocket<any, any> | null = null;
    private posts: any[] = [];
  
    created() {
      this.connectToRSocketServer();
      this.fetchPosts();
    }
  
    async connectToRSocketServer() {
      const client = new RSocketClient({
        transport: new RSocketWebSocketClient({
          url: 'ws://localhost:7878',
        }),
        setup: {
          dataMimeType: 'application/json',
          metadataMimeType: 'message/x.rsocket.routing.v0',
        },
        serializers: {
          data: JsonSerializer,
          metadata: JsonSerializer,
        },
        encoders: BufferEncoders,
      });
  
      this.rsocket = await client.connect();
    }
  
    async fetchPosts() {
      if (this.rsocket) {
        const response = await this.rsocket.requestResponse({
          data: null,
          metadata: Buffer.from('blog.posts'),
        });
  
        this.posts = JSON.parse(response.data);
      }
    }
  
    expandPost(postId: number) {
      // Logic to expand the selected post
    }
  }
  </script>
  