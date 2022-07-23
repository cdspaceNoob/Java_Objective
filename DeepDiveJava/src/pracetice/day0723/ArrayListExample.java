package pracetice.day0723;
import java.util.*;

public class ArrayListExample {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("COM");
		list.add("Java");
		list.add("JAVA");
		
		int size = list.size();
		System.out.println("list size is: "+size);
		
		String skill = list.get(1);
		System.out.println("1: "+skill);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		list.remove(2);
		list.remove(1);
		for(int i=0; i<list.size(); i++) {
			System.out.println("after del:"+list.get(i));
		}
		
	}

}
