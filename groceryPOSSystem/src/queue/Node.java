//package groceryPOSSystem;
package queue;

public class Node<T>
{
	private T element;
	private Node<T> node;//data is head
	public Node(T element)
	{
		this.element=element;
		this.node=null;
	}
	public T getElement()
	{
		return element;
	}
	public void setLink(Node<T> node) {
		this.node = node;
	}
	public void setElement(T element) {
		this.element = element;
	}
	public Node<T> getLink(){
		return node;
	}
}