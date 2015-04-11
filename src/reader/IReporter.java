package reader;

public interface IReporter<T,V> {

	public T ReturnReport(V parameters);
}
