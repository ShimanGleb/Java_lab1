package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class reader2 {
	public static void main(String[] args) throws IOException 
	{
		
		try
		{
			FileReader fr=new FileReader(args[2]);
			FileWriter fw=new FileWriter(new File(args[3]));
			Scanner file=new Scanner(fr);	
			
			for (int i=0; i<Integer.parseInt(args[0]); i++)
			{
				file.nextLine();
			}
			int i=0;
			while (file.hasNext())
			{
				request rek=new request();
				String line=file.nextLine();
				rek.SetInitalString(line);							
				
				rek.SplitRequest(rek);
				rek.OutRequest(args[3], fw);				
				i++;
				if (i==Integer.parseInt(args[0])) break;
			}
			file.close();
			fw.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		
	}
}
