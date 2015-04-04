package reader;

import java.util.ArrayList;

public interface IProcessor {

	public ArrayList<Request> processStrings(String skipLines, String readLines, String dataFile, String resultFile);
}
