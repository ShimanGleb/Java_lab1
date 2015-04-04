package reader;

import java.util.ArrayList;

public class LargestSeeker<T extends Request> implements ILargestSeeker<T> {

String fileName="report.txt";
	
	public int convertMonth(String month)
	{
		switch(month)
		{
		case "Jan":return 1;
		case "Feb":return 2;
		case "Mar":return 3;
		case "Apr":return 4;
		case "May":return 5;
		case "Jun":return 6;
		case "Jul":return 7;
		case "Aug":return 8;
		case "Sep":return 9;
		case "Oct":return 10;
		case "Nov":return 11;
		case "Dec":return 12;
		}
		return 0;
	}
	
	public boolean fitsDate(Request request,Date startingDate, Date finalDate)
	{		
		if (request.date.year>=startingDate.year && request.date.year<=finalDate.year)
		{
			if (startingDate.year!=finalDate.year) return true;
			else
			{
				if (convertMonth(request.date.month)>=convertMonth(startingDate.month) && convertMonth(request.date.month)<=convertMonth(finalDate.month))
					if (convertMonth(startingDate.month)!=convertMonth(finalDate.month)) return true;
					else
					{
						if (request.date.day>=startingDate.day && request.date.day<=finalDate.day)
							if (startingDate.day!=finalDate.day) return true;
							else
							{
								if (request.date.hour>=startingDate.hour && request.date.hour<=finalDate.hour)
									if (startingDate.hour!=finalDate.hour) return true;
									else
									{
										if (request.date.minute>=startingDate.minute && request.date.minute<=finalDate.minute)
											if (startingDate.minute!=finalDate.minute) return true;
											else
											{
												if (request.date.second>=startingDate.second && request.date.second<=finalDate.second)
													if (startingDate.second!=finalDate.second) return true;
													else return false;
											}
									}
							}
					}
			}			
		}
		else return false;
		return false;
	}
	
	public User returnLargest(ArrayList<T> requests,Date startingDate, Date finalDate)
	{
		int largestSize=0;
		String largestName="None";
		for (int i=0; i<requests.size(); i++)
		{			
			if (requests.get(i).secondByte>largestSize && fitsDate(requests.get(i),startingDate,finalDate))
			{
				largestSize=requests.get(i).secondByte;
				largestName=requests.get(i).GetAdress();
			}
		}
		User user=new User();
		user.commonSize=largestSize;
		user.name=largestName;
		return user;
	}
}
