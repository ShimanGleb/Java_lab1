package reader;

public class Request{
			
	String adress;
	public Date date=new Date();
	public String request;
	public int firstByte=0;
	public int secondByte=0;			
		
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