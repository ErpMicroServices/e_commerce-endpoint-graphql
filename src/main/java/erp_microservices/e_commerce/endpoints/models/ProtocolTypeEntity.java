package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "protocol_type", schema = "public", catalog = "e_commerce")
public class ProtocolTypeEntity {
	private UUID id;
	private String name;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", nullable = false, length = -1)
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ProtocolTypeEntity that = (ProtocolTypeEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
