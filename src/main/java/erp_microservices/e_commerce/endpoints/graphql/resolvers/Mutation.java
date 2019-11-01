package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import erp_microservices.e_commerce.endpoints.graphql.types.NewUserLogin;
import erp_microservices.e_commerce.endpoints.graphql.types.UserLogin;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

	public UserLogin login(NewUserLogin credentials) {
		return new UserLogin(1, true, "ChesterTester");
	}
}
