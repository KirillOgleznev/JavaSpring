package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"spring"})
public class SpringPostgresApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPostgresApplication.class, args);
    }

}