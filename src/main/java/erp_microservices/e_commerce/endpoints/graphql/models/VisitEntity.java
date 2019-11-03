package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "visit", schema = "public", catalog = "e_commerce")
public class VisitEntity {
	private UUID id;
	private LocalDateTime fromDate;
	private LocalDateTime thruDate;
	private String cookie;
	private UUID webAddressId;
	private UUID visitorId;

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

	@Basic
	@Column(name = "cookie", nullable = false, length = -1)
	public String getCookie() {
		return cookie;
	}

	public void setCookie(final String cookie) {
		this.cookie = cookie;
	}

	@Basic
	@Column(name = "web_address_id", nullable = true)
	public UUID getWebAddressId() {
		return webAddressId;
	}

	public void setWebAddressId(final UUID webAddressId) {
		this.webAddressId = webAddressId;
	}

	@Basic
	@Column(name = "visitor_id", nullable = true)
	public UUID getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(final UUID visitorId) {
		this.visitorId = visitorId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final VisitEntity that = (VisitEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(fromDate, that.fromDate) &&
				       Objects.equals(thruDate, that.thruDate) &&
				       Objects.equals(cookie, that.cookie) &&
				       Objects.equals(webAddressId, that.webAddressId) &&
				       Objects.equals(visitorId, that.visitorId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, fromDate, thruDate, cookie, webAddressId, visitorId);
	}
}
