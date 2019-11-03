package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "object_usage", schema = "public", catalog = "e_commerce")
public class ObjectUsageEntity {
	private UUID id;
	private LocalDateTime fromDate;
	private LocalDateTime thruDate;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "from_date", nullable = false)
	public LocalDateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(final LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	@Basic
	@Column(name = "thru_date", nullable = true)
	public LocalDateTime getThruDate() {
		return thruDate;
	}

	public void setThruDate(final LocalDateTime thruDate) {
		this.thruDate = thruDate;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final ObjectUsageEntity that = (ObjectUsageEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(fromDate, that.fromDate) &&
				       Objects.equals(thruDate, that.thruDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fromDate, thruDate);
	}
}
