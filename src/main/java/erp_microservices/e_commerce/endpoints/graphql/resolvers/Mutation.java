package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import erp_microservices.e_commerce.endpoints.graphql.types.NewUserLoginType;
import erp_microservices.e_commerce.endpoints.graphql.types.UserLoginType;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

	public UserLoginType login(NewUserLoginType credentials) {
		return new UserLoginType(1, true, "ChesterTester");
	}
}
