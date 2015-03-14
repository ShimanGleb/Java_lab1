package reader;

public class Date {

	public String initial;	
	int day=0;
	String month;
	int year=0;
	public void SplitDate()
	{
		int initialIndex=initial.indexOf('[')+1;
		day+=(Integer.valueOf(initialIndex)-48)*10;
		day+=(Integer.valueOf(initialIndex+1)-48);
		month=initial.substring(initialIndex+4,initialIndex+6);
		year+=(Integer.valueOf(initialIndex+8)-48)*1000;
		year+=(Integer.valueOf(initialIndex+9)-48)*100;
		year+=(Integer.valueOf(initialIndex+10)-48)*10;
		year+=Integer.valueOf(initialIndex+11)-48;
	}
}
