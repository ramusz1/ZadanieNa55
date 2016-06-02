
public class BPlusTree<K extends Comparable<K>, V> {
	
	private Node<K,V> root;
	
	private final int ORDER;

	public BPlusTree(int order) {
		ORDER = order;
		root = new LeafNode<K,V>(ORDER);
	}
	
	public void insert(K key, V value){
		Split<K,V> split = root.insert(key, value);
		if (split != null){
			root = new InnerNode<K,V>(ORDER);
			root.keys.add(split.key);
			((InnerNode<K,V>)root).children.add(split.left);
			((InnerNode<K,V>)root).children.add(split.right);
		}
	}
	
	public V retrieve(K key){
		Node<K,V> node = root;
		while (node instanceof InnerNode){
			InnerNode<K,V> inner = (InnerNode<K,V>)node;
			node = inner.children.get(inner.getKeyLocation(key));
		}
		LeafNode<K,V> leaf = (LeafNode<K,V>) node;
		int i = leaf.getKeyLocation(key);
		if (i>0 && i<=leaf.keys.size() && leaf.keys.get(i-1).equals(key)){
			return leaf.values.get(i-1);
		} else {
			return null;
		}
		
	}
	
	public void dump(){
		root.dump("");
	}

}
