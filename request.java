package reader;

public class request {

	String initialString;
	String adress;
	public String date;
	public String request;
	public int firstByte=0;
	public int secondByte=0;
	public void SplitRequest()
	{
		SetAdress(initialString.substring(0, initialString.indexOf('-')));
		date=initialString.substring(initialString.indexOf('[')+1, initialString.indexOf(']'));
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
