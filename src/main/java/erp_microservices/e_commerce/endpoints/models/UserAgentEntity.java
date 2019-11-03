package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user_agent", schema = "public", catalog = "e_commerce")
public class UserAgentEntity {
	private UUID id;
	private PlatformTypeEntity platformTypeByPlatformTypeId;
	private ProtocolTypeEntity protocolTypeByProtocolTypeId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final UserAgentEntity that = (UserAgentEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@ManyToOne
	@JoinColumn(name = "platform_type_id", referencedColumnName = "id")
	public PlatformTypeEntity getPlatformTypeByPlatformTypeId() {
		return platformTypeByPlatformTypeId;
	}

	public void setPlatformTypeByPlatformTypeId(final PlatformTypeEntity platformTypeByPlatformTypeId) {
		this.platformTypeByPlatformTypeId = platformTypeByPlatformTypeId;
	}

	@ManyToOne
	@JoinColumn(name = "protocol_type_id", referencedColumnName = "id")
	public ProtocolTypeEntity getProtocolTypeByProtocolTypeId() {
		return protocolTypeByProtocolTypeId;
	}

	public void setProtocolTypeByProtocolTypeId(final ProtocolTypeEntity protocolTypeByProtocolTypeId) {
		this.protocolTypeByProtocolTypeId = protocolTypeByProtocolTypeId;
	}
}
