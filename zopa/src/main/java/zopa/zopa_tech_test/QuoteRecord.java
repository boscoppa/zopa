package zopa.zopa_tech_test;

import java.util.ArrayList;

import zopa.zopa_tech_test.io.QuoteResponse;

/**
 * Class contains details of the loan, i.e. which lenders are used, and the loan
 * rate.
 *
 */
public class QuoteRecord {

	/**
	 * Loans from each lender.
	 */
	private ArrayList<SmallQuoteRecord> loans;

	private float rate;
	private long loanAmount;

	public QuoteRecord() {
		loans = new ArrayList<SmallQuoteRecord>();
	}

	/**
	 * Add loan from new lender.
	 */
	public void addSmallLoan(SmallQuoteRecord loanRecord) {
		loans.add(loanRecord);
		recalculateLoanRate();
	}

	/**
	 * Add loan from new lender.
	 */
	public void addLoan(String lender, float rate, long amount) {
		loans.add(new SmallQuoteRecord(lender, rate, amount));
		recalculateLoanRate();
	}

	/**
	 * Get the rate of the loan.
	 */
	public float getRate() {
		return rate;
	}

	public QuoteResponse getResponse() {
		float monthlyRepayment = calcMonthlyRepayments();
		float totalRepayment = monthlyRepayment * LoanCalculator.LOAN_PERIOD;

		return new QuoteResponse(loanAmount, rate, monthlyRepayment, totalRepayment);
	}

	/**
	 * Recalculate the loan rate, based on the rate provided by each lender.
	 */
	private void recalculateLoanRate() {
		long totalLoan = 0;
		float totalInterest = 0;
		for (SmallQuoteRecord loan : loans) {
			totalLoan += loan.getLoanAmount();
			totalInterest += loan.getLoanAmount() * loan.getRate();
		}
		rate = (float) totalInterest / totalLoan;
		loanAmount = totalLoan;
	}

	/**
	 * Calculate the effect monthly interest rate.
	 */
	private float getMonthlyRate() {
		return (float) Math.pow(1 + rate, (double) 1 / 12) - 1;
	}

	/**
	 * Calculate monthly repayment amount.
	 * 
	 * @return
	 */
	private float calcMonthlyRepayments() {
		float result = (float) ((float) (getMonthlyRate() * loanAmount)
				/ (1 - Math.pow(1 + getMonthlyRate(), -LoanCalculator.LOAN_PERIOD)));

		return result;
	}
}
