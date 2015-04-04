package reader;

public class Splitter implements ISplitter {
	
	public Request splitRequest(Request rec, String initialString) {
		rec.SetAdress(initialString.substring(0, initialString.indexOf('-')));
		rec.date.initial=initialString.substring(initialString.indexOf('[')+1, initialString.indexOf(']'));
		rec.date.SplitDate();
		rec.request=initialString.substring(initialString.indexOf('"')+1, initialString.lastIndexOf('"'));		
		for (int j=initialString.lastIndexOf('"')+2; j<initialString.length(); j++)
		{
			if (initialString.charAt(j)==' ')
			{
				for (int k=j+1; k<initialString.length(); k++)
				{
					rec.secondByte*=10; 
					rec.secondByte+=Integer.valueOf(initialString.charAt(k))-48;
				}
				break;
			}
			rec.firstByte*=10; 
			rec.firstByte+=Integer.valueOf(initialString.charAt(j))-48;
		}
		return rec;		
	}

}