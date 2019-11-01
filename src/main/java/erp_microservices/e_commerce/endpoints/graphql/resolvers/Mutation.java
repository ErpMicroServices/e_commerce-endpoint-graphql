package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import erp_microservices.e_commerce.endpoints.UserLogin;
import erp_microservices.e_commerce.endpoints.graphql.NewUserLogin;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

	//	login(credentials: NewUserLogin!): UserLogin
	public UserLogin login(NewUserLogin credentials) {
		return new UserLogin(1, true, "ChesterTester");
	}
}
