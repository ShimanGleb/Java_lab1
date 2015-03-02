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
				rek.adress=line.substring(0, line.indexOf('-'));
				rek.date=line.substring(line.indexOf('[')+1, line.indexOf(']'));
				rek.request=line.substring(line.indexOf('"')+1, line.lastIndexOf('"'));
				for (int j=line.lastIndexOf('"')+2; j<line.length(); j++)
				{					
					if (line.charAt(j)==' ')
					{
						for (int k=j+1; k<line.length(); k++)
						{
							rek.secondByte*=10; 
							rek.secondByte+=Integer.valueOf(line.charAt(k))-48;
						}
						break;
					}
					rek.firstByte*=10; 
					rek.firstByte+=Integer.valueOf(line.charAt(j))-48;
				}
				fw.write(rek.adress+"- - [");
				fw.write(rek.date+"] \"");
				fw.write(rek.request+"\" ");
				fw.write(Integer.toString(rek.firstByte));
				fw.write(" ");
				fw.write(Integer.toString(rek.secondByte));
				fw.write("\r\n");
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
