package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Processor implements IProcessor {
	
	public void processStrings(String skipLines, String readLines,
			String dataFile, String resultFile) {
		try
		{
			FileReader fr=new FileReader(dataFile);
			FileWriter fw=new FileWriter(new File(resultFile));
			Scanner file=new Scanner(fr);	
			
			for (int i=0; i<Integer.parseInt(skipLines); i++)
			{
				file.nextLine();
			}
			int i=0;
			while (file.hasNext())
			{
				Request rek=new Request();
				String line=file.nextLine();
				rek.SetInitalString(line);							
				
				rek.splitter.splitRequest(rek);
				rek.outer.outRequest(resultFile, fw, rek);			
				i++;
				if (i==Integer.parseInt(readLines)) break;
			}
			file.close();
			fw.close();
		}
		catch (FileNotFoundException e)
		{
			
		} catch (IOException e) {			
			e.printStackTrace();
		}

	}

}
