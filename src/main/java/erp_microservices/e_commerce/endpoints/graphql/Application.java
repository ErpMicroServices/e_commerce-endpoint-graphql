package erp_microservices.e_commerce.endpoints.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"erp_microservices.e_commerce.endpoints", "erp_microservices.e_commerce.endpoints.graphql.models", "erp_microservices.e_commerce.endpoints.graphql.repositories"})
@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
