package reader;

import java.io.FileWriter;
import java.io.IOException;

public class request implements Splitter, Outer{
		
	String initialString;
	String adress;
	public Date date=new Date();
	public String request;
	public int firstByte=0;
	public int secondByte=0;	
	public request SplitRequest(request rec)
	{
		SetAdress(initialString.substring(0, initialString.indexOf('-')));
		date.initial=initialString.substring(initialString.indexOf('[')+1, initialString.indexOf(']'));
		request=initialString.substring(initialString.indexOf('"')+1, initialString.lastIndexOf('"'));		
		for (int j=initialString.lastIndexOf('"')+2; j<initialString.length(); j++)
		{					
			if (initialString.charAt(j)==' ')
			{
				for (int k=j+1; k<initialString.length(); k++)
				{
					secondByte*=10; 
					secondByte+=Integer.valueOf(initialString.charAt(k))-48;
				}
				break;
			}
			firstByte*=10; 
			firstByte+=Integer.valueOf(initialString.charAt(j))-48;
		}
		return rec;
	}
	
	public void OutRequest(String fileName, FileWriter fw)
	{
		
		try {			
			fw.write(GetAdress()+"- - [");				
			fw.write(date.initial+"] \"");
			fw.write(GetRequest()+"\" ");
			fw.write(Integer.toString(GetFirstByte()));
			fw.write(" ");
			fw.write(Integer.toString(GetSecondByte()));
			fw.write("\r\n");
			
		} catch (IOException e) {			
		}
		
		
	}
	
	public void SetInitalString(String str)
	{
		initialString=str;
	}
	public void SetAdress(String ad)
	{
		adress=ad;
	}
	public String GetAdress()
	{
		return adress;
	}
	public String GetRequest()
	{
		return request;
	}
	public int GetFirstByte()
	{
		return firstByte;
	}
	public int GetSecondByte()
	{
		return secondByte;
	}
}
