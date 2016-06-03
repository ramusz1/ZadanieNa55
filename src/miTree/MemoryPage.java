package miTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class MemoryPage<K extends Comparable<K>, V> {
	public static int NumberOfPages;
	public static int PageSize = 1024;
	public static Writer writer;
	public static File file;

	public static void setWriter(String filename) {
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename+".txt"), "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MemoryPage(ArrayList<Node<K, V>> nodes, int height) {

		NumberOfPages++;

		int nodeLength=0;
		int nodeSize = (int) (PageSize / (Math.pow(2, height))); // musi byæ
																// podzielne
		if(nodes.size()>height){
			System.out.println("Error, to many nodes, not enough height");
		}
		if (nodes.size() < height) {
			for(int i=1;i<height-nodes.size();i++)		//ró¿nica = 1 to nie mnó¿
				nodeSize*=2;
			write(nodeSize);
		}
		for (int i = 0; i < nodes.size(); i++){
			nodeLength+=write(nodes.get(i).keys);
			//nodeLength+=write(nodes.get(i).pointers);			///zapisaæ jeszcze wskaiki i wartosci jeœli leaf
			//nodeLength+=write(nodes.get(i).values);
			if(nodeLength<= nodeSize)
				write(nodeSize-nodeLength);
			else
				System.out.println("Error, Out Of Memory");
			nodeSize*=2;
		}
			
	}

	public int write(List<K> keys) {
		String str;
		int nodeLength=0;
		for (int i = 0; i < keys.size(); i++){
			str=keys.get(i).toString();
			nodeLength+=str.length();
			try {
				writer.write(str+' ');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer.write('\n');
			nodeLength+=1;			///??? 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nodeLength;
	}

	public void write(int offset) {
		for(int i=0;i<offset;i++)
			try {
				writer.write(' ');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
