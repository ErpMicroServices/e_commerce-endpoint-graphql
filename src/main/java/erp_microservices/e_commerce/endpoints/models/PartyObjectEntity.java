package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "party_object", schema = "public", catalog = "e_commerce")
public class PartyObjectEntity {
	private UUID id;
	private UUID partyId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
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
		final PartyObjectEntity that = (PartyObjectEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(partyId, that.partyId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, partyId);
	}
}
