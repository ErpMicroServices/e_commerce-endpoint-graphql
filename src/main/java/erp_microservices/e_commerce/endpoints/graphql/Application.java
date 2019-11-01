package erp_microservices.e_commerce.endpoints.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	GraphQLSchema schema() {
//		return GraphQLSchema.newSchema()
//				       .query(GraphQLObjectType.newObject()
//						              .name("query")
//						              .field(field -> field
//								                              .name("test")
//								                              .type(Scalars.GraphQLString)
//								                              .dataFetcher(environment -> "response")
//						              )
//						              .build())
//				       .build();
//	}
}
