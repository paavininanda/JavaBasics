package jersey;

@FunctionalInterface
public interface Writer<T> {
	public void print (T output);
};

