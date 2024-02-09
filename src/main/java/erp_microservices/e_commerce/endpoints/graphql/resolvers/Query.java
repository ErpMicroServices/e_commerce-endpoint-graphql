package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import erp_microservices.e_commerce.endpoints.graphql.types.UserLoginType;
import erp_microservices.e_commerce.endpoints.graphql.types.WebContentType;
import erp_microservices.e_commerce.endpoints.repositories.WebContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	private WebContentRepository webContentRepository;

	public UserLoginType userById(long id) {
		return new UserLoginType(id, true, "ChesterTester");
	}

	public List<WebContentType> contentForWebAddress(UUID webAddressId) {
		final List<WebContentType> collect = webContentRepository.findByWebAddressId(webAddressId).stream().map(webContent -> new WebContentType(webContent.getId(), webContent.getContentDescription(), webContent.getFileLocation())).collect(Collectors.toList());
		return collect;
	}
}
