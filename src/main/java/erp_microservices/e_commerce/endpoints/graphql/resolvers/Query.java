package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import erp_microservices.e_commerce.endpoints.graphql.repositories.WebContentRepository;
import erp_microservices.e_commerce.endpoints.graphql.types.UserLogin;
import erp_microservices.e_commerce.endpoints.graphql.types.WebContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private WebContentRepository webContentRepository;

	public UserLogin userById(long id) {
		return new UserLogin(id, true, "ChesterTester");
	}

	public List<WebContent> contentForWebAddress(UUID webAddressId) {
		System.out.println("Hello world");
		final List<WebContent> collect = webContentRepository.findByWebAddressId(webAddressId).stream().map(webContent -> new WebContent(webContent.getId(), webContent.getContentDescription(), webContent.getFileLocation())).collect(Collectors.toList());
		return collect;
	}
}
