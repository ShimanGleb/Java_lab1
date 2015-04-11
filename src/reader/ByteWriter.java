package reader;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ByteWriter {

	public void WriteData(Request request) throws IOException
	{
		RandomAccessFile file=new RandomAccessFile(new File("log.dat"),"w");
		file.seek(file.length());
		file.writeChars(request.adress);
		file.write(request.date.day);
		file.writeChars(request.date.month);
		file.write(request.date.year);
		file.write(request.date.hour);
		file.write(request.date.minute);
		file.write(request.date.second);
		file.write(request.date.timeZone);
		file.writeChars(request.request);
		file.write(request.firstByte);
		file.write(request.secondByte);
		file.close();
	}
}
