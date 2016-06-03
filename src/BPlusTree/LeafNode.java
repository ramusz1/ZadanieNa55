package BPlusTree;
import java.util.*;

public class LeafNode<K extends Comparable<K>, V> extends Node<K, V> {
	
	public List<V> values;

	public LeafNode(int order) {
		super(order);
		values = new ArrayList<V>(ORDER);
	}
	
	public int getExactKeyLocation(K key){
		int i = getKeyLocation(key);
		if (i>0 && i<=keys.size() && keys.get(i-1).equals(key)){
			return i-1;
		} else {
			return -1;
		}
	}

	public Split<K, V> insert(K key, V value) {
		if(keys.size() == 0){
			keys.add(key);
			values.add(value);
			return null;
		} else {
			int i = getKeyLocation(key);
			keys.add(i, key);
			values.add(i, value);
			
			if(needsToBeSplit()){
				return this.split();
			} else {
				return null;
			}
		}
	}

	public Split<K, V> split() {
		int mid = (int)Math.ceil((double)keys.size()/2);
		LeafNode<K,V> rightSibling = new LeafNode<K,V>(ORDER);
		
		rightSibling.keys = new ArrayList<K>(keys.subList(mid, keys.size()));
		rightSibling.values = new ArrayList<V>(values.subList(mid, keys.size()));
		this.keys = new ArrayList<K>(keys.subList(0, mid));
		this.values = new ArrayList<V>(values.subList(0, mid));
		
		return new Split<K,V>(rightSibling.keys.get(0), this, rightSibling);
	}

	public void dump(String prefix) {
		System.out.println(prefix + "Leaf Node ");
		for(int i=0; i<keys.size(); i++){
			System.out.println(prefix + values.get(i).toString());
		}
	}

	/*@Override
	public Merge<K, V> remove(K key) {
		int loc = getExactKeyLocation(key);
		
		return null;
	}*/ //todo

}
