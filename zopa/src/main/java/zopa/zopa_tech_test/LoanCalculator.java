package zopa.zopa_tech_test;

import zopa.zopa_tech_test.io.LoanResponse;
import zopa.zopa_tech_test.io.MarketData;

public class LoanCalculator {

	private static final int LOAN_PERIOD = 36; // months

	private MarketData marketData;

	public LoanCalculator(MarketData marketData) {
		this.marketData = marketData;
	}

	public LoanResponse newQuote(long loanAmount) {
		LoanResponse response = null;
		if (loanAmount <= marketData.getTotalAvailable()) {

		}

		return response;
	}
}
