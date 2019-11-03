package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "server_hit", schema = "public", catalog = "e_commerce")
public class ServerHitEntity {
	private UUID id;
	private UUID ipAdddressId;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "ip_adddress_id", nullable = false)
	public UUID getIpAdddressId() {
		return ipAdddressId;
	}

	public void setIpAdddressId(final UUID ipAdddressId) {
		this.ipAdddressId = ipAdddressId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ServerHitEntity that = (ServerHitEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(ipAdddressId, that.ipAdddressId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ipAdddressId);
	}
}
