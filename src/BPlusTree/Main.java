package BPlusTree;

public class Main {

	public static void main(String[] args){
		BPlusTree<Integer, Integer> tree = new BPlusTree<Integer, Integer>(2);
		/*tree.insert(5, 5);
		tree.insert(1, 1);
		tree.insert(2, 2);
		System.out.println("DONE 2");
		tree.dump();
		tree.insert(3, 3);
		System.out.println("DONE 3");
		tree.dump();
		tree.insert(4, 4);
		System.out.println("DONE 4");
		tree.dump();
		tree.insert(6, 6);
		System.out.println("DONE 6");
		tree.dump();
		tree.insert(7, 7);
		System.out.println("DONE 7");
		tree.dump();
		tree.insert(8, 8);
		System.out.println("DONE 8");
		tree.dump();
		tree.insert(9, 9);
		System.out.println("DONE 9");
		tree.dump();
		tree.insert(12, 12);
		System.out.println("DONE 12");
		tree.dump();*/
		
		int[] array = {1,4,16,25,9,20,13,15,10,11,12,21,22,23};
		for(int i=0; i<array.length; i++){
			tree.insert(array[i], array[i]);
			System.out.println("DONE " + array[i]);
			//tree.dump();
		}
		
		for(int i=0; i<27; i++){
			System.out.println(i + ": " + tree.retrieve(i));
		}
		System.out.println(tree.getHeight());
		
		BPlusTree<Integer, Integer> tree2 = new BPlusTree<Integer, Integer>(4);
		for(int i=200; i>=0; i--){
			if (i%2 == 0){
				tree2.insert(i, i);
			}
		}
		/*for(int i=0; i<=2100; i++){
			if (i%2 == 1){
				tree2.insert(i, i);
			}
		}*/
		//tree2.dump();
		for(int i=0; i<=200; i++){
			System.out.println(i + ": " + tree2.retrieve(i));
		}
		System.out.println(tree2.getHeight());
	}

}
