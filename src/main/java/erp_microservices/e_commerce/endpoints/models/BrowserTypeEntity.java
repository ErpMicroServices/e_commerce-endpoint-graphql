package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "browser_type", schema = "public", catalog = "e_commerce")
public class BrowserTypeEntity {
	private UUID id;
	private String name;
	private String version;

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

	@Basic
	@Column(name = "version", nullable = false, length = -1)
	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final BrowserTypeEntity that = (BrowserTypeEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(name, that.name) &&
				       Objects.equals(version, that.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, version);
	}
}
