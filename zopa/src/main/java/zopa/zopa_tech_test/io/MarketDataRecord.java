package zopa.zopa_tech_test.io;

public class MarketDataRecord {

	private String lender;
	private float rate;
	private long available;

	public MarketDataRecord(String lender, float rate, long available) {
		this.lender = lender;
		this.rate = rate;
		this.available = available;
	}

	public String getLender() {
		return lender;
	}

	public float getRate() {
		return rate;
	}

	public long getAvailable() {
		return available;
	}

	public void borrow(float amount) {
		available -= amount;
	}
}
