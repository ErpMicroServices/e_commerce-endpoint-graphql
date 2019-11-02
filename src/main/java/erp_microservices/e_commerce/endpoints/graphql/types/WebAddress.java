package erp_microservices.e_commerce.endpoints.graphql.types;

import java.util.Objects;

public class WebAddress {

	private String endPoint = "";

	public WebAddress() {
	}

	public WebAddress(final String endPoint) {
		this.endPoint = endPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(final String endPoint) {
		this.endPoint = endPoint;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof WebAddress)) return false;
		final WebAddress that = (WebAddress) o;
		return Objects.equals(getEndPoint(), that.getEndPoint());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getEndPoint());
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("WebAddress{");
		sb.append("endPoint='").append(endPoint).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
