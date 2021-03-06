package zopa.zopa_tech_test.io;

import java.util.ArrayList;

/**
 * Stores all the details of the lenders in the market.
 *
 */
public class MarketData {

	private ArrayList<MarketDataRecord> lenders;

	private long totalAvailable;

	public MarketData() {
		lenders = new ArrayList<MarketDataRecord>();
		totalAvailable = 0;
	}

	public void addLender(String lender, float rate, long available) {
		lenders.add(new MarketDataRecord(lender, rate, available));
		totalAvailable += available;
	}

	public long getTotalAvailable() {
		return totalAvailable;
	}

	public MarketDataRecord getLowestRateLender(long loanAmount) {
		MarketDataRecord lowestRateLender = lenders.get(0);
		for (MarketDataRecord lender : lenders) {
			if (lender.getRate() < lowestRateLender.getRate() && lender.getAvailable() > 0) {
				lowestRateLender = lender;
			}
		}

		return lowestRateLender;
	}

}
