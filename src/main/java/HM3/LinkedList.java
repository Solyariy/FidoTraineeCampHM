package HM3;

import java.util.EmptyStackException;
import java.util.function.Supplier;

public class LinkedList<T> implements LinkedLiskInterface<T> {
	public Node<T> head = null;
	public Node<T> tail = null;
	private int size = 0;
	
	public LinkedList() {
	}
	
	@Override
	public T get(int index) {
		if (index >= size || size + index > size) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		Node<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current.value;
	}
	
	@Override
	public T getFirst() {
		return this.head.value;
	}
	
	@Override
	public T getLast() {
		return this.tail.value;
	}
	
	@Override
	public T remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Max index: " + this.size);
		}
		if (index == 0) {
			return this.removeFirst();
		} else if (this.size == index) {
			return this.removeLast();
		} else {
			Node<T> current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;
			--size;
			
			return current.value;
		}
	}
	
	@Override
	public T removeFirst() {
		if (this.size == 0) {
			throw new EmptyStackException();
		}
		T temp = this.head.value;
		this.head = null;
		return temp;
	}
	
	@Override
	public T removeLast() {
		if (this.size == 0) {
			throw new EmptyStackException();
		}
		T temp = this.tail.value;
		this.tail = null;
		return temp;
	}
	
	@Override
	public void add(int index, T elem) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Max index: " + this.size);
		}
		
		if (index == 0) {
			this.addFirst(elem);
		} else if (this.size == index) {
			this.addLast(elem);
		} else {
			Node<T> newNode = new Node<T>(elem);
			Node<T> current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			newNode.prev = current.prev;
			newNode.next = current;
			current.prev.next = newNode;
			current.prev = newNode;
			++size;
		}
	}
	
	@Override
	public void addFirst(T elem) {
		Node<T> newElem = new Node<>(elem);
		if (this.head == null) {
			this.tail = newElem;
		} else {
			this.head.prev = newElem;
			newElem.next = this.head;
		}
		this.head = newElem;
		
		++size;
	}
	
	@Override
	public void addLast(T elem) {
		Node<T> newElem = new Node<>(elem);
		if (this.tail == null) {
			this.head = newElem;
		} else {
			this.tail.next = newElem;
			newElem.prev = this.tail;
		}
		this.tail = newElem;
		++size;
	}
	
	@Override
	public void add(int index, Supplier<T> elemSupplier) {
		
		T elem = elemSupplier.get();
		this.add(index, elem);
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public void clear() {
		for (int i = 0; i < this.size; ++i) {
			this.head = this.head.next;
			this.head.prev = null;
		}
	}
}
