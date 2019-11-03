package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "web_object", schema = "public", catalog = "e_commerce")
public class WebObjectEntity {
	private UUID id;
	private String name;
	private String description;
	private String fileLocation;

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
	@Column(name = "description", nullable = false, length = -1)
	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Basic
	@Column(name = "file_location", nullable = true, length = -1)
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(final String fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebObjectEntity that = (WebObjectEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(name, that.name) &&
				       Objects.equals(description, that.description) &&
				       Objects.equals(fileLocation, that.fileLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, fileLocation);
	}
}
