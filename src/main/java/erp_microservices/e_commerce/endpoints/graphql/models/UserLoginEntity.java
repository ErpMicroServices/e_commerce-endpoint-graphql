package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user_login", schema = "public", catalog = "e_commerce")
public class UserLoginEntity {
	private UUID id;
	private String userId;
	private String password;
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
	@Column(name = "user_id", nullable = false, length = -1)
	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "password", nullable = false, length = -1)
	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
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
		final UserLoginEntity that = (UserLoginEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(userId, that.userId) &&
				       Objects.equals(password, that.password) &&
				       Objects.equals(partyId, that.partyId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userId, password, partyId);
	}
}
