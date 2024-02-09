package erp_microservices.e_commerce.endpoints.graphql.types;

import java.net.URI;
import java.util.Objects;
import java.util.UUID;

public class WebContentType {
	private UUID id;
	private String description;
	private URI fileLocation;

	public WebContentType() {
	}

	public WebContentType(final UUID id, final String description, final URI fileLocation) {
		this.id = id;
		this.description = description;
		this.fileLocation = fileLocation;
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public URI getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(final URI fileLocation) {
		this.fileLocation = fileLocation;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof WebContentType)) return false;
		final WebContentType that = (WebContentType) o;
		return Objects.equals(getId(), that.getId()) &&
				       Objects.equals(getDescription(), that.getDescription()) &&
				       Objects.equals(getFileLocation(), that.getFileLocation());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getDescription(), getFileLocation());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("WebContent{");
		sb.append("id=").append(id);
		sb.append(", description='").append(description).append('\'');
		sb.append(", file_location=").append(fileLocation);
		sb.append('}');
		return sb.toString();
	}
}
