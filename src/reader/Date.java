package reader;

public class Date {

	public String initial;	
	int day=0;
	String month;
	int year=0;
	int hour=0;
	int minute=0;
	int second=0;
	int timeZone=0;
	public void SplitDate()
	{
		int initialIndex=initial.indexOf('[');
		
		day+=(Integer.valueOf(initial.charAt(initialIndex+1))-48)*10;
		day+=Integer.valueOf(initial.charAt(initialIndex+2))-48;
		month=initial.substring(initialIndex+3,initialIndex+6);
		year+=(Integer.valueOf(initial.charAt(initialIndex+8))-48)*1000;
		year+=(Integer.valueOf(initial.charAt(initialIndex+9))-48)*100;
		year+=(Integer.valueOf(initial.charAt(initialIndex+10))-48)*10;
		year+=Integer.valueOf(initial.charAt(initialIndex+11))-48;
		hour+=(Integer.valueOf(initial.charAt(initialIndex+13))-48)*10;
		hour+=Integer.valueOf(initial.charAt(initialIndex+14))-48;
		minute+=(Integer.valueOf(initial.charAt(initialIndex+16))-48)*10;
		minute+=Integer.valueOf(initial.charAt(initialIndex+17))-48;
		second+=(Integer.valueOf(initial.charAt(initialIndex+19))-48)*10;
		second+=Integer.valueOf(initial.charAt(initialIndex+20))-48;
	}
}
