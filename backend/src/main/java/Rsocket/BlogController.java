package Rsocket;

import io.rsocket.RSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Controller
public class BlogController implements RSocket {

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogController(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @MessageMapping("blog.posts")
    public Flux<BlogPost> getBlogPosts() {
        return Flux.fromIterable(blogPostRepository.findAll());
    }

    @MessageMapping("blog.addPost")
    public BlogPost addBlogPost(@Payload BlogPost blogPost) {
        blogPost.setCreatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }
}

