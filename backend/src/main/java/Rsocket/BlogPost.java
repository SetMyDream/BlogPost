package Rsocket;

import lombok.Data;

import java.time.LocalDateTime;

@Data
class BlogPost {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
