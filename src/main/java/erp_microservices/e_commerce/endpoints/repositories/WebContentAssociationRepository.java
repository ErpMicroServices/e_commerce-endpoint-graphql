package erp_microservices.e_commerce.endpoints.repositories;

import erp_microservices.e_commerce.endpoints.models.WebContentAssociationEntity;
import erp_microservices.e_commerce.endpoints.models.WebContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WebContentAssociationRepository extends JpaRepository<WebContentAssociationEntity, UUID> {
	public List<WebContentAssociationEntity> findByWebContentByAssociateFor(WebContentEntity webContentId);
}
