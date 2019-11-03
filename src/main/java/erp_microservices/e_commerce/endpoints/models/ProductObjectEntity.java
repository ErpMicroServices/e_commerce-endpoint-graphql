package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product_object", schema = "public", catalog = "e_commerce")
public class ProductObjectEntity {
	private UUID id;
	private UUID productId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "product_id", nullable = false)
	public UUID getProductId() {
		return productId;
	}

	public void setProductId(final UUID productId) {
		this.productId = productId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ProductObjectEntity that = (ProductObjectEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(productId, that.productId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, productId);
	}
}
