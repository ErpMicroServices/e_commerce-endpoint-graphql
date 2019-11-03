package erp_microservices.e_commerce.endpoints.graphql.models;

import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "web_content_association", schema = "public", catalog = "e_commerce")
public class WebContentAssociationEntity {
	private UUID id;
	private Point upperLeftCoordinate;
	private FunctionTypeEntity functionTypeByFunctionType;
	private WebContentEntity webContentByAssociateFor;
	private WebContentEntity webContentByAssociateOf;

	@Id
	@Column(name = "id", nullable = false)
	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	@Basic
	@Column(name = "upper_left_coordinate", nullable = true)
	public Point getUpperLeftCoordinate() {
		return upperLeftCoordinate;
	}

	public void setUpperLeftCoordinate(final Point upperLeftCoordinate) {
		this.upperLeftCoordinate = upperLeftCoordinate;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final WebContentAssociationEntity that = (WebContentAssociationEntity) o;
		return Objects.equals(id, that.id) &&
				       Objects.equals(upperLeftCoordinate, that.upperLeftCoordinate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, upperLeftCoordinate);
	}

	@ManyToOne
	@JoinColumn(name = "function_type", referencedColumnName = "id")
	public FunctionTypeEntity getFunctionTypeByFunctionType() {
		return functionTypeByFunctionType;
	}

	public void setFunctionTypeByFunctionType(final FunctionTypeEntity functionTypeByFunctionType) {
		this.functionTypeByFunctionType = functionTypeByFunctionType;
	}

	@ManyToOne
	@JoinColumn(name = "associate_for", referencedColumnName = "id")
	public WebContentEntity getWebContentByAssociateFor() {
		return webContentByAssociateFor;
	}

	public void setWebContentByAssociateFor(final WebContentEntity webContentByAssociateFor) {
		this.webContentByAssociateFor = webContentByAssociateFor;
	}

	@ManyToOne
	@JoinColumn(name = "associate_of", referencedColumnName = "id")
	public WebContentEntity getWebContentByAssociateOf() {
		return webContentByAssociateOf;
	}

	public void setWebContentByAssociateOf(final WebContentEntity webContentByAssociateOf) {
		this.webContentByAssociateOf = webContentByAssociateOf;
	}
}
