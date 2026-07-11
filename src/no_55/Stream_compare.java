package no_55;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_compare {

	record Item(String name, int price) {

	}

	public static void main(String[] args) {
		List<Item> items = List.of(
				new Item("mango", 150),
				new Item("banana", 80),
				new Item("orange", 120),
				new Item("apple", 100),
				new Item("melon", 1000));
		//Stream API 用コード
		// Item の price を基準に降順ソート → name だけ取り出す → カンマ区切りで "[ ]" に包んで結合 という処理
		String result = items.stream().sorted(Comparator.comparing(Item::price).reversed()).map(Item::name)
				.collect(Collectors.joining(",", "[", "]"));
		System.out.println(result);
	}

}
