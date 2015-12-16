package Heap;

public class LLNode<T> {

	private LLNode link;
	private T info;
	protected LLNode<T> front;
	protected LLNode<T> rear;
	public LLNode(T info)
	{
		this.info = info;
		link = null;
		front = null;
		rear = null;
	}
	public LLNode<T> getFront() {
		return front;
	}
	public void setFront(LLNode<T> front) {
		this.front = front;
	}
	public LLNode<T> getRear() {
		return rear;
	}
	public void setRear(LLNode<T> rear) {
		this.rear = rear;
	}
	public void setInfo(T info)
	{
		this.info = info;
	}
	public T getInfo()
	{
		return info;
	}
	public void setLink(LLNode link)
	{
		this.link = link;
	}
	public LLNode getLink()
	{
		return link;
	}
}
