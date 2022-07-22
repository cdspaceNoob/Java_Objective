package lesson.day0721;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class TestMapCode {
	public void testMap() {
		System.out.println("map crud");
		
		/* CREATE - key: string & value:integer HashMap OBJ */
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		/* add data */
		map.put("k1", 1);
		map.put("k2", 2);
		map.put("k3", 3);
		/* KEY duplicated: modify */
		map.put("k1", 4);
		
		/* check size */
		int size = map.size();
		System.out.println("size of map is: "+size);
		
		/* select where */
		int val = map.get("k1");
		System.out.println("val is: "+val);
		
		/* select all from */
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		while(iterator.hasNext()){
			String key = iterator.next();
			int intVal = map.get(key);
			System.out.println("val to key is: "+intVal);
		}
		/* Delete from map */
		Integer delVal = map.remove("k1");
		System.out.println("삭제한 값: "+delVal.intValue());
		
		int sizeAfter = map.size();
		System.out.println("size of map is: "+size);
		try {
			Integer value = map.get("k1");
			System.out.println(value.intValue());
		}catch(NullPointerException ne) {
			System.out.println("No key available");
		}
		
	}
}
