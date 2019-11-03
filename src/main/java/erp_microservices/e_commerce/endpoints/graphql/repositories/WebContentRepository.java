package erp_microservices.e_commerce.endpoints.graphql.repositories;

import erp_microservices.e_commerce.endpoints.graphql.models.WebContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WebContentRepository extends JpaRepository<WebContentEntity, UUID> {
	List<WebContentEntity> findByWebAddressId(UUID webAddressId);
}
