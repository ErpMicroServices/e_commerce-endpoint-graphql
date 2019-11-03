package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.net.URI;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "web_content", schema = "public", catalog = "e_commerce")
public class WebContentEntity {
	private UUID id;
	private String contentDescription;
	private URI fileLocation;
	private WebAddressEntity webAddress;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "content_description", nullable = false, length = -1)
	public String getContentDescription() {
		return contentDescription;
	}

	public void setContentDescription(final String contentDescription) {
		this.contentDescription = contentDescription;
	}

	@Basic
	@Column(name = "file_location", nullable = true, length = -1)
	public URI getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(final URI fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebContentEntity that = (WebContentEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(contentDescription, that.contentDescription) &&
				       Objects.equals(fileLocation, that.fileLocation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, contentDescription, fileLocation);
	}

	@ManyToOne
	@JoinColumn(name = "web_address", referencedColumnName = "id", nullable = false)
	public WebAddressEntity getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(final WebAddressEntity webAddress) {
		this.webAddress = webAddress;
	}
}
