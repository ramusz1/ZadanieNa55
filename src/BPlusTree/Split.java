package BPlusTree;

public class Split<K extends Comparable<K>, V> {
	
	public final K key;
	public final Node<K,V> left;
	public final Node<K,V> right;

	public Split(K key, Node<K,V> left, Node<K,V> right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

}
