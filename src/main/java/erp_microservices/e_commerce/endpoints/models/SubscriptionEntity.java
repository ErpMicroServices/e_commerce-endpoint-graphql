package erp_microservices.e_commerce.endpoints.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "subscription", schema = "public", catalog = "e_commerce")
public class SubscriptionEntity {
	private UUID id;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private UUID productId;
	private UUID productCategoryId;
	private UUID needType;
	private UUID partyRoleId;
	private UUID contactMechanismId;
	private UUID commmunicationEventId;
	private UUID partyNeed;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "start_date", nullable = false)
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(final LocalDateTime startDate) {
		this.startDate = startDate;
	}

	@Basic
	@Column(name = "end_date", nullable = true)
	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(final LocalDateTime endDate) {
		this.endDate = endDate;
	}

	@Basic
	@Column(name = "product_id", nullable = true)
	public UUID getProductId() {
		return productId;
	}

	public void setProductId(final UUID productId) {
		this.productId = productId;
	}

	@Basic
	@Column(name = "product_category_id", nullable = true)
	public UUID getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(final UUID productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	@Basic
	@Column(name = "need_type", nullable = true)
	public UUID getNeedType() {
		return needType;
	}

	public void setNeedType(final UUID needType) {
		this.needType = needType;
	}

	@Basic
	@Column(name = "party_role_id", nullable = true)
	public UUID getPartyRoleId() {
		return partyRoleId;
	}

	public void setPartyRoleId(final UUID partyRoleId) {
		this.partyRoleId = partyRoleId;
	}

	@Basic
	@Column(name = "contact_mechanism_id", nullable = true)
	public UUID getContactMechanismId() {
		return contactMechanismId;
	}

	public void setContactMechanismId(final UUID contactMechanismId) {
		this.contactMechanismId = contactMechanismId;
	}

	@Basic
	@Column(name = "commmunication_event_id", nullable = true)
	public UUID getCommmunicationEventId() {
		return commmunicationEventId;
	}

	public void setCommmunicationEventId(final UUID commmunicationEventId) {
		this.commmunicationEventId = commmunicationEventId;
	}

	@Basic
	@Column(name = "party_need", nullable = true)
	public UUID getPartyNeed() {
		return partyNeed;
	}

	public void setPartyNeed(final UUID partyNeed) {
		this.partyNeed = partyNeed;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final SubscriptionEntity that = (SubscriptionEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(startDate, that.startDate) &&
				       Objects.equals(endDate, that.endDate) &&
				       Objects.equals(productId, that.productId) &&
				       Objects.equals(productCategoryId, that.productCategoryId) &&
				       Objects.equals(needType, that.needType) &&
				       Objects.equals(partyRoleId, that.partyRoleId) &&
				       Objects.equals(contactMechanismId, that.contactMechanismId) &&
				       Objects.equals(commmunicationEventId, that.commmunicationEventId) &&
				       Objects.equals(partyNeed, that.partyNeed);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, startDate, endDate, productId, productCategoryId, needType, partyRoleId, contactMechanismId, commmunicationEventId, partyNeed);
	}
}
