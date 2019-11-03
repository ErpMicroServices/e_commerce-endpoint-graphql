package erp_microservices.e_commerce.endpoints.graphql.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "subscription_fulfillment_piece", schema = "public", catalog = "e_commerce")
public class SubscriptionFulfillmentPieceEntity {
	private UUID id;
	private SubscriptionEntity subscriptionBySubscriptionId;
	private SubscriptionActivityEntity subscriptionActivityBySubscriptionActivityId;

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
		final SubscriptionFulfillmentPieceEntity that = (SubscriptionFulfillmentPieceEntity) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@ManyToOne
	@JoinColumn(name = "subscription_id", referencedColumnName = "id", nullable = false)
	public SubscriptionEntity getSubscriptionBySubscriptionId() {
		return subscriptionBySubscriptionId;
	}

	public void setSubscriptionBySubscriptionId(final SubscriptionEntity subscriptionBySubscriptionId) {
		this.subscriptionBySubscriptionId = subscriptionBySubscriptionId;
	}

	@ManyToOne
	@JoinColumn(name = "subscription_activity_id", referencedColumnName = "id", nullable = false)
	public SubscriptionActivityEntity getSubscriptionActivityBySubscriptionActivityId() {
		return subscriptionActivityBySubscriptionActivityId;
	}

	public void setSubscriptionActivityBySubscriptionActivityId(final SubscriptionActivityEntity subscriptionActivityBySubscriptionActivityId) {
		this.subscriptionActivityBySubscriptionActivityId = subscriptionActivityBySubscriptionActivityId;
	}
}
