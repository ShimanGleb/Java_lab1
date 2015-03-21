package reader;

import java.io.FileWriter;

public interface IOuter {

	public void outRequest(String fileName, FileWriter fw, Request rec);
}
