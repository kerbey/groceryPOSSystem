package Heap;

public interface WeightedGraphInterface<T>
{
	void clearMarks();
	 boolean isEmpty();
	 boolean isFull();
	boolean isMarked(String vertex);
	void addVertex(T vertex);
	boolean hasVertex(T vertex);
	boolean markVertex(String vertex);
	UnboundedQueueInterface<String> getToVertices(String vertex);
	void addEdge(T fromVertex, T toVertex, int weight);
	int weightIs(T fromVertex, T toVertex);
	T getUnmarked();
}