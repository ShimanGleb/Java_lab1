package reader;

public class Splitter implements ISplitter {
	
	public Request splitRequest(Request rec) {
		rec.SetAdress(rec.initialString.substring(0, rec.initialString.indexOf('-')));
		rec.date.initial=rec.initialString.substring(rec.initialString.indexOf('[')+1, rec.initialString.indexOf(']'));
		rec.date.SplitDate();
		rec.request=rec.initialString.substring(rec.initialString.indexOf('"')+1, rec.initialString.lastIndexOf('"'));		
		for (int j=rec.initialString.lastIndexOf('"')+2; j<rec.initialString.length(); j++)
		{
			if (rec.initialString.charAt(j)==' ')
			{
				for (int k=j+1; k<rec.initialString.length(); k++)
				{
					rec.secondByte*=10; 
					rec.secondByte+=Integer.valueOf(rec.initialString.charAt(k))-48;
				}
				break;
			}
			rec.firstByte*=10; 
			rec.firstByte+=Integer.valueOf(rec.initialString.charAt(j))-48;
		}
		return rec;		
	}

}
