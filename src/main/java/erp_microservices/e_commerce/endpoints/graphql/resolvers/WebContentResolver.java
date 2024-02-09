package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import erp_microservices.e_commerce.endpoints.graphql.types.WebContentType;
import erp_microservices.e_commerce.endpoints.models.WebContentAssociationEntity;
import erp_microservices.e_commerce.endpoints.models.WebContentEntity;
import erp_microservices.e_commerce.endpoints.repositories.WebContentAssociationRepository;
import erp_microservices.e_commerce.endpoints.repositories.WebContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WebContentResolver implements GraphQLResolver<WebContentType> {
	@Autowired
	private WebContentAssociationRepository webContentAssociationRepository;
	@Autowired
	private WebContentRepository webContentRepository;

	public List<WebContentAssociationEntity> association(WebContentType webContent) {
		final Optional<WebContentEntity> webContentEntity = webContentRepository.findById(webContent.getId());
		if (webContentEntity.isPresent()) {
			return webContentAssociationRepository.findByWebContentByAssociateFor(webContentEntity.get());
		} else {
			return new ArrayList<>();
		}
	}
}
