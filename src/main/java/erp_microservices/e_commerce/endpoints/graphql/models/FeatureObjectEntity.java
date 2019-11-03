package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "feature_object", schema = "public", catalog = "e_commerce")
public class FeatureObjectEntity {
	private UUID id;
	private UUID productFeatureId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "product_feature_id", nullable = false)
	public UUID getProductFeatureId() {
		return productFeatureId;
	}

	public void setProductFeatureId(final UUID productFeatureId) {
		this.productFeatureId = productFeatureId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final FeatureObjectEntity that = (FeatureObjectEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(productFeatureId, that.productFeatureId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productFeatureId);
	}
}
