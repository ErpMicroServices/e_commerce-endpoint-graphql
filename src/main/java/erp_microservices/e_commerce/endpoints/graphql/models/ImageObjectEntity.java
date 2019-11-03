package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "image_object", schema = "public", catalog = "e_commerce")
public class ImageObjectEntity {
	private UUID id;
	private String name;
	private String description;
	private String fileLocation;
	private UUID webObjectTypeId;
	private String imageLocation;

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

	@Basic
	@Column(name = "web_object_type_id", nullable = false)
	public UUID getWebObjectTypeId() {
		return webObjectTypeId;
	}

	public void setWebObjectTypeId(final UUID webObjectTypeId) {
		this.webObjectTypeId = webObjectTypeId;
	}

	@Basic
	@Column(name = "image_location", nullable = false, length = -1)
	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(final String imageLocation) {
		this.imageLocation = imageLocation;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ImageObjectEntity that = (ImageObjectEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(name, that.name) &&
				       Objects.equals(description, that.description) &&
				       Objects.equals(fileLocation, that.fileLocation) &&
				       Objects.equals(webObjectTypeId, that.webObjectTypeId) &&
				       Objects.equals(imageLocation, that.imageLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, fileLocation, webObjectTypeId, imageLocation);
	}
}
