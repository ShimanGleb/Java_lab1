package reader;

import java.util.ArrayList;

public interface ICommonBytesReporter<T extends Request> {

	public long returnBytes(ArrayList<T> requests,Date startingDate, Date finalDate);
}
