package erp_microservices.e_commerce.endpoints.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import erp_microservices.e_commerce.endpoints.graphql.types.WebContentType;
import erp_microservices.e_commerce.endpoints.models.WebContentAssociationEntity;
import erp_microservices.e_commerce.endpoints.models.WebContentEntity;
import erp_microservices.e_commerce.endpoints.repositories.WebContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebContentAssociationResolver implements GraphQLResolver<WebContentAssociationEntity> {

	@Autowired
	private WebContentRepository webContentRepository;

	public String upper_left_coordinate(WebContentAssociationEntity webContentAssociationEntity) {
		return webContentAssociationEntity.getUpperLeftCoordinate().toString();
	}

	public WebContentType associate_for(WebContentAssociationEntity webContentAssociationEntity) {
		final WebContentEntity webContentByAssociateOf = webContentAssociationEntity.getWebContentByAssociateOf();
		return new WebContentType(webContentByAssociateOf.getId(), webContentByAssociateOf.getContentDescription(), webContentByAssociateOf.getFileLocation());
	}
}
