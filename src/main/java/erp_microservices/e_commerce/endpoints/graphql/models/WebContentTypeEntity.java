package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "web_content_type", schema = "public", catalog = "e_commerce")
public class WebContentTypeEntity {
	private UUID id;
	private String description;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "description", nullable = false, length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebContentTypeEntity that = (WebContentTypeEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(description, that.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, description);
	}
}
