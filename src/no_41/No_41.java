package no_41;

import java.util.ArrayList;
import java.util.List;

public class No_41 {
	record Item (String name, int price) {
		
	};
	
	public static void main(String[] args) {
		List<Item> items = List.of(
				new Item("apple",100),
				new Item("banana",80),
				new Item("orange",120)
				);
		List<String> names = new ArrayList<String>();
		for(Item item:items) {
			names.add(item.name());
		}
		
		names.replaceAll(n->n.toUpperCase());
		System.out.println(names);
	}
}
