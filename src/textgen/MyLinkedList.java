package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) { 
			throw new NullPointerException("");
		}
		
		LLNode <E> nodeToAdd = new LLNode<E>(element);
		nodeToAdd.next = tail;
		nodeToAdd.prev = tail.prev;
		tail.prev.next = nodeToAdd;
		tail.prev = nodeToAdd;
		
		
		size++;
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index > size - 1 || index < 0){
			throw new IndexOutOfBoundsException("");
		}
		LLNode<E> currentNode = head;
		for (int i = -1; i < index; i++){
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		
		
		if ((index != 0 && index > size - 1) || index < 0){
			
			throw new IndexOutOfBoundsException("");
		} 
		if (element == null) { 
			throw new NullPointerException("");
		}
		LLNode<E> currentNode = head;
		LLNode<E> nodeToAdd = new LLNode<E>(element);
		
		for (int i = -1; i < index; i++){
			currentNode = currentNode.next;
		}

		nodeToAdd.next = currentNode;
		nodeToAdd.prev = currentNode.prev;
	
		currentNode.prev.next = nodeToAdd;
		currentNode.prev = nodeToAdd;
		
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method - while next != tail
		
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (size == 0){
			throw new IndexOutOfBoundsException("Cannot remove from empty linked list"); 
		}
		
		if (index > size - 1 || index < 0){
			
			throw new IndexOutOfBoundsException("");
		}
		
		LLNode<E> nodeToRemove = head;
		
		for (int i = -1; i < index; i++){
			nodeToRemove = nodeToRemove.next;
		}
		E data = nodeToRemove.data;
		
		nodeToRemove.prev.next = nodeToRemove.next;
		nodeToRemove.next.prev = nodeToRemove.prev;
		nodeToRemove = null;
		
		size--;
		return data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if ((index != 0 && index > size - 1) || index < 0){
			
			throw new IndexOutOfBoundsException("");
		} else if (element == null) { 
			throw new NullPointerException("");
		}
		
		LLNode<E> nodeToRemove = head;
		LLNode<E> nodeToSet = new LLNode<E>(element);
		for (int i = -1; i < index; i++){
			nodeToRemove = nodeToRemove.next;
		}

		E data = nodeToRemove.data;
		nodeToRemove.prev.next = nodeToSet;
		nodeToRemove.next.prev = nodeToSet;
		nodeToSet.next = nodeToRemove.next;
		nodeToSet.prev = nodeToRemove.prev;
		nodeToRemove = null;
		return data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
