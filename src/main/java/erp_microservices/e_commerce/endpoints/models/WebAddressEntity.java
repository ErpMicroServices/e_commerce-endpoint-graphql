package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "web_address", schema = "public", catalog = "e_commerce")
public class WebAddressEntity {
	private UUID id;
	private String endPoint;
	private UUID contactMechanismId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "end_point", nullable = false, length = -1)
	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(final String endPoint) {
		this.endPoint = endPoint;
	}

	@Basic
	@Column(name = "contact_mechanism_id", nullable = false)
	public UUID getContactMechanismId() {
		return contactMechanismId;
	}

	public void setContactMechanismId(final UUID contactMechanismId) {
		this.contactMechanismId = contactMechanismId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebAddressEntity that = (WebAddressEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(endPoint, that.endPoint) &&
				       Objects.equals(contactMechanismId, that.contactMechanismId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, endPoint, contactMechanismId);
	}
}
