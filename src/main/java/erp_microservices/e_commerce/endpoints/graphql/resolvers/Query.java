package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import erp_microservices.e_commerce.endpoints.UserLogin;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

	public UserLogin userById(long id) {
		return new UserLogin(id, true, "ChesterTester");
	}
}
