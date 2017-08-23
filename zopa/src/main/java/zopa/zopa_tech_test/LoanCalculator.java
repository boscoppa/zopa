package zopa.zopa_tech_test;

import zopa.zopa_tech_test.io.ErrorResponse;
import zopa.zopa_tech_test.io.MarketData;
import zopa.zopa_tech_test.io.MarketDataRecord;
import zopa.zopa_tech_test.io.Response;

public class LoanCalculator {

	/**
	 * The loan period in months.
	 */
	public static final int LOAN_PERIOD = 36; // months

	private static final String WRONG_INCREMENT = "Loan requests should be in increments of £100";
	private static final String WRONG_AMOUNT = "Loan requests should be between £1000 and £15000";
	private static final String INSUFFICIENT = "It is currently not possible to provide a quote";

	private static final long MIN_LOAN = 1000;

	private static final long MAX_LOAN = 15000;

	private MarketData marketData;

	public LoanCalculator(MarketData marketData) {
		this.marketData = marketData;
	}

	/**
	 * Get a loan quote.
	 * 
	 * @param loanAmount
	 * @return
	 */
	public Response newQuote(long loanAmount) {
		Response response = null;
		if (loanAmount < MIN_LOAN || loanAmount > MAX_LOAN) {
			response = new ErrorResponse(WRONG_AMOUNT);
		} else if (loanAmount % 100 != 0) {
			response = new ErrorResponse(WRONG_INCREMENT);
		} else if (loanAmount > marketData.getTotalAvailable()) {
			response = new ErrorResponse(INSUFFICIENT);
		} else {
			QuoteRecord loan = new QuoteRecord();
			long remainingLoan = loanAmount;

			MarketDataRecord lender = null;
			long amountToBorrow = 0;
			while (remainingLoan > 0) {
				lender = marketData.getLowestRateLender(loanAmount);
				amountToBorrow = Math.min(lender.getAvailable(), remainingLoan);

				remainingLoan -= lender.getAvailable();
				lender.borrow(amountToBorrow);
				loan.addLoan(lender.getLender(), lender.getRate(), amountToBorrow);
			}
			response = loan.getResponse();
		}

		return response;
	}

}
