package zopa.zopa_tech_test.io;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Response containing details of the quote.
 *
 */
public class QuoteResponse implements Response {

	private long requestedAmount;
	private float rate;
	private float monthlyRepayment;
	private float totalRepyment;

	private static final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.UK);
	private static final NumberFormat rateFormat = NumberFormat.getPercentInstance();

	public QuoteResponse(long requestedAmount, float rate, float monthlyRepayment, float totalRepyment) {
		this.requestedAmount = requestedAmount;
		this.rate = rate;
		this.monthlyRepayment = monthlyRepayment;
		this.totalRepyment = totalRepyment;

		rateFormat.setMinimumFractionDigits(1);
		moneyFormat.setGroupingUsed(false);
	}

	public long getRequestedAmount() {
		return requestedAmount;
	}

	public float getRate() {
		return rate;
	}

	public float getMonthlyRepayment() {
		return monthlyRepayment;
	}

	public float getTotalRepyment() {
		return totalRepyment;
	}

	@Override
	public String toString() {
		return "Requested amount: " + moneyFormat.format(requestedAmount) + "\n" + "Rate: " + rateFormat.format(rate)
				+ "\n" + "Monthly repayment: " + moneyFormat.format(monthlyRepayment) + "\n" + "Total repayment: "
				+ moneyFormat.format(totalRepyment);
	}
}
