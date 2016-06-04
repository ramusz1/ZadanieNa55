package miTree;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Adam
 *
 */
public class Node<K extends Comparable<K>, V> implements Serializable {
//TODO wszystko
	public List<K> keys;
	public List<V> values;
}
