package zopa.zopa_tech_test;

/**
 * Class to store details about a loan from a specific lender.
 */
public class SmallQuoteRecord {

	private String lender;
	private float rate;
	private long loanAmount;

	public SmallQuoteRecord(String lender, float rate, long loanAmount) {
		this.lender = lender;
		this.rate = rate;
		this.loanAmount = loanAmount;
	}

	public String getLender() {
		return lender;
	}

	public float getRate() {
		return rate;
	}

	public long getLoanAmount() {
		return loanAmount;
	}

}
