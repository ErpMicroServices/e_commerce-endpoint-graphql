package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "web_user_preference", schema = "public", catalog = "e_commerce")
public class WebUserPreferenceEntity {
	private UUID id;
	private String value;
	private UserLoginEntity userLoginByUserLoginId;
	private WebPreferenceTypeEntity webPreferenceTypeByWebPreferenceTypeId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "value", nullable = true, length = -1)
	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebUserPreferenceEntity that = (WebUserPreferenceEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(value, that.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value);
	}

	@ManyToOne
	@JoinColumn(name = "user_login_id", referencedColumnName = "id", nullable = false)
	public UserLoginEntity getUserLoginByUserLoginId() {
		return userLoginByUserLoginId;
	}

	public void setUserLoginByUserLoginId(final UserLoginEntity userLoginByUserLoginId) {
		this.userLoginByUserLoginId = userLoginByUserLoginId;
	}

	@ManyToOne
	@JoinColumn(name = "web_preference_type_id", referencedColumnName = "id", nullable = false)
	public WebPreferenceTypeEntity getWebPreferenceTypeByWebPreferenceTypeId() {
		return webPreferenceTypeByWebPreferenceTypeId;
	}

	public void setWebPreferenceTypeByWebPreferenceTypeId(final WebPreferenceTypeEntity webPreferenceTypeByWebPreferenceTypeId) {
		this.webPreferenceTypeByWebPreferenceTypeId = webPreferenceTypeByWebPreferenceTypeId;
	}
}
