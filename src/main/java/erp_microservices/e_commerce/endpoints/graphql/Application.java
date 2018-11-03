package erp_microservices.e_commerce.endpoints.graphql;

import erp_microservices.e_commerce.endpoints.graphql.resolvers.Mutation;
import erp_microservices.e_commerce.endpoints.graphql.resolvers.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	Mutation mutation() {
//		return new Mutation();
//	}
//
//	@Bean
//	Query query() {
//		return new Query();
//	}
	
}
