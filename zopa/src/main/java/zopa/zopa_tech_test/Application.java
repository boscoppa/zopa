package zopa.zopa_tech_test;

import java.io.File;

import zopa.zopa_tech_test.io.MarketData;
import zopa.zopa_tech_test.io.MarketFileReader;
import zopa.zopa_tech_test.io.Response;

public class Application {

	public static void main(String[] args) {
		if (args.length == 2) {
			File dataFile = new File(args[0]);
			long loanAmount = Long.parseLong(args[1]);

			MarketFileReader reader = new MarketFileReader();
			MarketData marketData = reader.readFile(dataFile);
			LoanCalculator loanCalculator = new LoanCalculator(marketData);
			Response loanResponse = loanCalculator.newQuote(loanAmount);

			System.out.println(loanResponse);
		} else {
			System.out.println("Incorrect number of arguments. Expecting 2.");
		}
	}
}
