package zopa.zopa_tech_test;

import zopa.zopa_tech_test.io.LoanResponse;
import zopa.zopa_tech_test.io.MarketData;
import zopa.zopa_tech_test.io.MarketDataRecord;

public class LoanCalculator {

	private static final int LOAN_PERIOD = 36; // months

	private MarketData marketData;

	public LoanCalculator(MarketData marketData) {
		this.marketData = marketData;
	}

	public LoanResponse newQuote(long loanAmount) {
		LoanResponse response = null;
		long remainingLoan = loanAmount;
		if (loanAmount <= marketData.getTotalAvailable()) {
			MarketDataRecord lender = null;
			while (remainingLoan > 0) {
				lender = marketData.getLowestRateLender(loanAmount);
				
			}
		}

		return response;
	}
	
	public long calcRepayment(long loanAmount, float rate, int loanPeriod) {
		
		return 0;
	}
}
