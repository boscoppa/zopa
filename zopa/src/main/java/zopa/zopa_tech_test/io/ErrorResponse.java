package zopa.zopa_tech_test.io;

/**
 * Response to be used when system conditions have not been met.
 *
 */
public class ErrorResponse implements Response {

	private String errorMessage;

	public ErrorResponse(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}

}
