package Rsocket;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogPostRepository extends MongoRepository<BlogPost, Integer> {
}
