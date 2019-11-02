package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import erp_microservices.e_commerce.endpoints.graphql.types.UserLogin;
import erp_microservices.e_commerce.endpoints.graphql.types.WebAddress;
import erp_microservices.e_commerce.endpoints.graphql.types.WebContent;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Query implements GraphQLQueryResolver {

	public UserLogin userById(long id) {
		return new UserLogin(id, true, "ChesterTester");
	}

	public List<WebContent> contentForWebAddress(WebAddress webAddress) {
		List<WebContent> content = new ArrayList<>();
		try {
			content.add(new WebContent(UUID.randomUUID(), "This is content", new URI("http://localhost/chester/tester")));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return content;
	}
}
