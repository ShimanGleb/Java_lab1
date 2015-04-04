package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Processor implements IProcessor {
	
	public ArrayList<Request> processStrings(String skipLines, String readLines,
			String dataFile, String resultFile) {
		ArrayList<Request> requests = new ArrayList<Request>();
		try
		{
			
			FileReader fr=new FileReader(dataFile);
			FileWriter fw=new FileWriter(new File(resultFile));
			Scanner file=new Scanner(fr);	
			
			for (int i=0; i<Integer.parseInt(skipLines); i++)
			{
				Request rek=new Request();
				String line=file.nextLine();									
				
				Splitter splitter=new Splitter();
				splitter.splitRequest(rek,line);
				requests.add(rek);
			}
			int i=0;
			while (file.hasNext())
			{				
				Request rek=new Request();
				String line=file.nextLine();										
				
				Splitter splitter=new Splitter();
				splitter.splitRequest(rek,line);
				Outer outer=new Outer();
				outer.outRequest(resultFile, fw, rek);	
				requests.add(rek);
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
		return requests;
	}

}