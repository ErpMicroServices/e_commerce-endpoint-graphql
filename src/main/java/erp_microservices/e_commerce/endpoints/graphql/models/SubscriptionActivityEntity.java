package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "subscription_activity", schema = "public", catalog = "e_commerce")
public class SubscriptionActivityEntity {
	private UUID id;
	private LocalDateTime dateSent;
	private String comment;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "date_sent", nullable = false)
	public LocalDateTime getDateSent() {
		return dateSent;
	}

	public void setDateSent(final LocalDateTime dateSent) {
		this.dateSent = dateSent;
	}

	@Basic
	@Column(name = "comment", nullable = true, length = -1)
	public String getComment() {
		return comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SubscriptionActivityEntity that = (SubscriptionActivityEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(dateSent, that.dateSent) &&
				       Objects.equals(comment, that.comment);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, dateSent, comment);
	}
}
