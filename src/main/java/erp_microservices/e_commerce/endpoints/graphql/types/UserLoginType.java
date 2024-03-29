package erp_microservices.e_commerce.endpoints.graphql.types;

import java.util.Objects;

public class UserLoginType {
	private long id;
	private boolean active;
	private String userId;

	public UserLoginType(final long id, final boolean active, final String userId) {
		this.id = id;
		this.active = active;
		this.userId = userId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof UserLoginType)) return false;
		final UserLoginType userLogin = (UserLoginType) o;
		return getId() == userLogin.getId();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}
}
