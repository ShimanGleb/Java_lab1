package reader;

import java.util.ArrayList;

public interface IActiveReporter<T extends Request> {

	public ArrayList<User> returnActives(ArrayList<T> requests,Date startingDate, Date finalDate);
}