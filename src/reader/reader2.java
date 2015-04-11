package reader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class reader2 {	
	
	public static Date assignDate(String day, String time)
	{
		Date date=new Date();			
		date.year+=(Integer.valueOf(day.charAt(0))-48)*1000;
		date.year+=(Integer.valueOf(day.charAt(1))-48)*100;
		date.year+=(Integer.valueOf(day.charAt(2))-48)*10;
		date.year+=Integer.valueOf(day.charAt(3))-48;
		date.month=day.substring(5, 8);
		date.day+=(Integer.valueOf(day.charAt(9))-48)*10;
		date.day+=Integer.valueOf(day.charAt(10))-48;
		
		date.hour+=(Integer.valueOf(time.charAt(0))-48)*10;
		date.hour+=Integer.valueOf(time.charAt(1))-48;
		date.minute+=(Integer.valueOf(time.charAt(3))-48)*10;
		date.minute+=Integer.valueOf(time.charAt(4))-48;
		date.second+=(Integer.valueOf(time.charAt(6))-48)*10;
		date.second+=Integer.valueOf(time.charAt(7))-48;
		return date;
	}
	
	public static void main(String[] args) throws IOException
	{			
		ArrayList<Request> requests = new ArrayList<Request>();
		Processor processor=new Processor();
		requests=processor.processStrings(args[0],args[1],args[2],args[3]);				
		Date startingDate=new Date();
		startingDate=assignDate(args[5],args[6]);
		Date finalDate=new Date();
		finalDate=assignDate(args[7],args[8]);
		Parameters parameters=new Parameters();
		parameters.requests=requests;
		parameters.startingDate=startingDate;
		parameters.finalDate=finalDate;
		
		if (Integer.valueOf(args[4])==1) 
		{
			ActiveReporter<ArrayList<User>,Parameters> actives=new ActiveReporter<ArrayList<User>,Parameters>();
			ArrayList<User> mostActive=actives.ReturnReport(parameters);
			FileWriter fw=new FileWriter(new File("report.txt"));
			fw.write("Most active users: \r\n");
			for (int i=0; i<mostActive.size(); i++) 
			{
				fw.write(mostActive.get(i).name+ " with " + (mostActive.get(i).requests+1) + " message(s) \r\n");
			}				
			fw.close();
		}
		if (Integer.valueOf(args[4])==2) 
		{	
			CommonBytesReporter<ByteSum,Parameters> report=new CommonBytesReporter<ByteSum,Parameters>();
			ByteSum commonBytes=report.ReturnReport(parameters);
			FileWriter fw=new FileWriter(new File("report.txt"));
			fw.write(commonBytes + " bytes.");
			fw.close();
		}
		if (Integer.valueOf(args[4])==3) 
		{			
			LargestSeeker<User,Parameters> report=new LargestSeeker<User,Parameters>();
			User user=report.ReturnReport(parameters);
			FileWriter fw=new FileWriter(new File("report.txt"));
			fw.write(user.name + " with " + user.commonSize + " bytes.");		
			fw.close();	
		}		
	}
}