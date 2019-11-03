package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "web_content_role", schema = "public", catalog = "e_commerce")
public class WebContentRoleEntity {
	private UUID id;
	private LocalDateTime activeFrom;
	private LocalDateTime activeThru;
	private UUID partyId;
	private WebContentEntity webContentByWebContentId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "active_from", nullable = false)
	public LocalDateTime getActiveFrom() {
		return activeFrom;
	}

	public void setActiveFrom(final LocalDateTime activeFrom) {
		this.activeFrom = activeFrom;
	}

	@Basic
	@Column(name = "active_thru", nullable = true)
	public LocalDateTime getActiveThru() {
		return activeThru;
	}

	public void setActiveThru(final LocalDateTime activeThru) {
		this.activeThru = activeThru;
	}

	@Basic
	@Column(name = "party_id", nullable = false)
	public UUID getPartyId() {
		return partyId;
	}

	public void setPartyId(final UUID partyId) {
		this.partyId = partyId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebContentRoleEntity that = (WebContentRoleEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(activeFrom, that.activeFrom) &&
				       Objects.equals(activeThru, that.activeThru) &&
				       Objects.equals(partyId, that.partyId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, activeFrom, activeThru, partyId);
	}

	@ManyToOne
	@JoinColumn(name = "web_content_id", referencedColumnName = "id")
	public WebContentEntity getWebContentByWebContentId() {
		return webContentByWebContentId;
	}

	public void setWebContentByWebContentId(final WebContentEntity webContentByWebContentId) {
		this.webContentByWebContentId = webContentByWebContentId;
	}
}
