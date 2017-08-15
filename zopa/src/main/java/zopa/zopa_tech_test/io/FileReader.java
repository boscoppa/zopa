package zopa.zopa_tech_test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

	public void readFile(File file) {
		
		try
		{
			BufferedReader bf = new BufferedReader(new java.io.FileReader(file));
			
			String line = bf.readLine();
			
			do
			{
				//outList.add(line);
				
				line = bf.readLine();
			} 
			while (line != null);
			
			bf.close();
		}
		catch (IOException ioe){ioe.printStackTrace();}
	}
}
