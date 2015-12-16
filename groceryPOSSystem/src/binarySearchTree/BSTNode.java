package binarySearchTree;


public class BSTNode <T>
{
	protected T info;
	protected BSTNode<T> left;
	protected BSTNode<T> right;
	static int maxCount, count=0;
	binarySearchTree<String> tree= new binarySearchTree<>();	

	public BSTNode(T info)
	{
		this.info = info;
		left = null;
		right = null;
	}


	public T getInfo() {
		//System.out.println("getInfo=="+this.info);
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	
	public BSTNode<T> getLeft() {
		//System.out.println("getLeft=="+this.left);
		return left;
	}
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	
	public BSTNode<T> getRight() {
		//System.out.println("getRight=="+this.right);
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
}