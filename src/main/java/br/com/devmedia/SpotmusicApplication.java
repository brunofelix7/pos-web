package br.com.devmedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpotmusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotmusicApplication.class, args);
    }

}
