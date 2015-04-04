package reader;

public interface ISplitter {
	
	Request splitRequest(Request rec,String initialString);	
}