package BPlusTree;
import java.util.*;

public class InnerNode<K extends Comparable<K>, V> extends Node<K, V> {

	public List<Node<K,V>> children;
	
	public InnerNode(int order) {
		super(order);
		children = new ArrayList<Node<K,V>>(ORDER+1);
	}

	public Split<K, V> insert(K key, V value) {
		int i = getKeyLocation(key);
		Split<K,V> split = children.get(i).insert(key, value);
		
		if (split != null){
			int j = getKeyLocation(split.key);
			keys.add(j, split.key);
			children.add(j+1, split.right);
			
			if(needsToBeSplit()){
				return this.split();
			}
		}
		return null;
	}

	public Split<K, V> split() {
		int mid = keys.size()/2;
		InnerNode<K,V> rightSibling = new InnerNode<K,V>(ORDER);
		
		// srodkowy przechodzi calkowicie na wyzszy node
		K middleKey = this.keys.get(mid);
		
		rightSibling.keys = new ArrayList<K>(keys.subList(mid + 1, keys.size()));
		rightSibling.children = new ArrayList<Node<K,V>>(children.subList(mid + 1, children.size()));
		this.keys = new ArrayList<K>(keys.subList(0, mid));
		this.children =  new ArrayList<Node<K,V>>(children.subList(0, mid + 1));
		
		return new Split<K,V>(middleKey, this, rightSibling);
	}

	public void dump(String prefix) {
		System.out.println(prefix + "Inner Node");
		for(int i=0; i<children.size(); i++){
			children.get(i).dump(prefix + " ");
			if(i<ORDER && i<keys.size()){
				System.out.println(prefix + "+Key: " + keys.get(i));
			}
		}
	}

	/*@Override
	public Merge<K, V> remove(K key) {
		int i = getKeyLocation(key);
		Merge<K,V> merge = children.get(i).remove(key);
		
		return null;
	}*/ //todo

}
