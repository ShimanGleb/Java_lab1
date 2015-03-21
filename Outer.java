package reader;

import java.io.FileWriter;
import java.io.IOException;

public class Outer implements IOuter {
	
	public void outRequest(String fileName, FileWriter fw, Request rec) {
		
		try {			
			fw.write(rec.GetAdress()+"- - [");				
			fw.write(rec.date.initial+"] \"");
			fw.write(rec.GetRequest()+"\" ");
			fw.write(Integer.toString(rec.GetFirstByte()));
			fw.write(" ");
			fw.write(Integer.toString(rec.GetSecondByte()));
			fw.write("\r\n");
			
		} 
		catch (IOException e) {			
		}

	}

}
