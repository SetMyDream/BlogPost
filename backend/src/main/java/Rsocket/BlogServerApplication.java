package Rsocket;

import io.rsocket.core.RSocketServer;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BlogServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogServerApplication.class, args);
    }

    @Autowired
    private BlogController blogController;

    @PostConstruct
    public void startRSocketServer() {
        RSocketServer.create()
                .payloadDecoder(PayloadDecoder.ZERO_COPY)
                .acceptor((setupPayload, reactiveSocket) -> Mono.just(blogController))
                .bind(TcpServerTransport.create(7878))
                .block()
                .onClose()
                .block();
    }
}

