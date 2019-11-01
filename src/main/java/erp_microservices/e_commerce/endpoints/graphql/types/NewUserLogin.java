package erp_microservices.e_commerce.endpoints.graphql.types;

import java.util.Objects;

public class NewUserLogin {
	private String userId = "";
	private String password = "";

	public NewUserLogin() {
	}

	public NewUserLogin(final String userId, final String password) {
		assert userId != null : "userId cannot be null";
		assert password != null : "password cannot be null";
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(final String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof NewUserLogin)) return false;
		final NewUserLogin that = (NewUserLogin) o;
		return getUserId().equals(that.getUserId()) &&
				       getPassword().equals(that.getPassword());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUserId(), getPassword());
	}
}
