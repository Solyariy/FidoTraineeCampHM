package HM3;

import java.util.function.Supplier;

public interface LinkedLiskInterface<T> {
	T get(int index);
	T getFirst();
	T getLast();
	T remove(int index);
	T removeFirst();
	T removeLast();
	void add(int index, T elem);
	void addFirst(T elem);
	void addLast(T elem);
	void add(int index, Supplier<T> elemSupplier);
	int size();
	void clear();
}
