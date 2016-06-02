import java.util.*;

public abstract class Node<K extends Comparable<K>, V> {

	protected final int ORDER;
	public List<K> keys;
	
	Node(int order){
		ORDER = order;
		keys = new ArrayList<K>(ORDER);
	}
	
	public int getKeyLocation(K key){
		int i=0;
		while(i < keys.size() && keys.get(i).compareTo(key) <= 0){
			i++;
		}
		return i;
	}
	
	abstract public Split<K,V> insert(K key, V value);
	abstract public Split<K,V> split();
	abstract public void dump(String prefix);
}
