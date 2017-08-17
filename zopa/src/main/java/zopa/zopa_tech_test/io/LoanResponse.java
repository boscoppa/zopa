package zopa.zopa_tech_test.io;

import java.text.NumberFormat;
import java.util.Locale;

public class LoanResponse {

	private int requestedAmount;
	private float rate;
	private long monthlyRepayment;
	private long totalRepyment;

	private static final NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.UK);

	public LoanResponse(int requestedAmount, float rate, long monthlyRepayment, long totalRepyment) {
		this.requestedAmount = requestedAmount;
		this.rate = rate;
		this.monthlyRepayment = monthlyRepayment;
		this.totalRepyment = totalRepyment;
	}

	public int getRequestedAmount() {
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

	private String formatRepayment(float value) {
		return nf.format(value / 100.0);
	}

	public String toString() {
		return "Requested amount: " + requestedAmount + "\n" + "Rate: " + rate + "\n" + "Monthly repayment: "
				+ formatRepayment(monthlyRepayment) + "\n" + "Total repayment: " + formatRepayment(totalRepyment);
	}
}
