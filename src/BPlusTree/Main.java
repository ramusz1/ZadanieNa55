package BPlusTree;
public class Main {

	public static void main(String[] args){
		BPlusTree<Integer, Integer> tree = new BPlusTree<Integer, Integer>(2);
		
		int[] array = {1,4,16,25,9,20,13,15,10,11,12,21,22,23};
		for(int i=0; i<array.length; i++){
			tree.insert(array[i], array[i]);
			System.out.println("added " + array[i]);
			tree.dump();
		}
		
		for(int i=0; i<27; i++){
			System.out.println(i + ": " + tree.retrieve(i));
		}
		
		BPlusTree<Integer, Integer> tree2 = new BPlusTree<Integer, Integer>(4);
		for(int i=200; i>=0; i--){
			if (i%2 == 0){
				tree2.insert(i, i);
			}
		}
		tree2.dump();
		for(int i=0; i<=200; i++){
			System.out.println(i + ": " + tree2.retrieve(i));
		}
	}

}
