package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "login_account_history", schema = "public", catalog = "e_commerce")
public class LoginAccountHistoryEntity {
	private UUID id;
	private String userId;
	private String password;
	private LocalDateTime activeFrom;
	private LocalDateTime activeThru;

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

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final LoginAccountHistoryEntity that = (LoginAccountHistoryEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(userId, that.userId) &&
				       Objects.equals(password, that.password) &&
				       Objects.equals(activeFrom, that.activeFrom) &&
				       Objects.equals(activeThru, that.activeThru);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, userId, password, activeFrom, activeThru);
	}
}
