package com.learning.java.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		Map<Key, Integer> map = new HashMap<>();
		map.put(new Key("Vishal"), 20);
		
		Key sachin = new Key("Sachin");
		map.put(sachin, 20);
		map.put(new Key("Vinod"), 20);
		map.put(new Key("Maya"), 20);
		map.put(new Key("Shreeja"), 20);
		map.put(sachin, 50);

		map.put(null, 20);
		map.put(null, 22);

		map.get(new Key("Sachin"));
		System.out.println(map);
	}
}
