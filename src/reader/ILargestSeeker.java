package reader;

import java.util.ArrayList;

public interface ILargestSeeker<T extends Request> {

	public User returnLargest(ArrayList<T> requests,Date startingDate, Date finalDate);
}
