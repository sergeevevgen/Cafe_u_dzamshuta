package client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Компоненты должны быть все тут, т.е. без собственного сервиса в этом модуле ниче не работает
@EnableJpaRepositories(basePackages = "data")
@EntityScan(basePackages = "data")
@ComponentScan(basePackages = { "client" })
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
