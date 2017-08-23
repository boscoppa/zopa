package zopa.zopa_tech_test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Readers market data from a CSV file. It uses a very basic method to parse the
 * file. Ideally I'd use a proper CSV parser and add more error handling.
 */
public class MarketFileReader {

	public MarketData readFile(File file) {

		MarketData marketData = new MarketData();

		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));

			String line = bf.readLine();

			// skip the first line if it contains headers
			if (line.equals("Lender,Rate,Available")) {
				line = bf.readLine();
			}

			String[] s;

			do {
				s = line.split(",");
				marketData.addLender(s[0], Float.parseFloat(s[1]), Long.parseLong(s[2]));

				line = bf.readLine();
			} while (line != null);

			bf.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return marketData;
	}
}
