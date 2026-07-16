package no_11;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collect_group {

	//「3つのフィールドを持つ不変データキャリア（レコード）を定義しているコード」
	//record は Java 16 以降で導入された 不変データクラス。
	record Item(String name, int price, Category_X category) {
	}

	public static void main(String[] args) {

		//4つのItem作成
		Item a = new Item("apple", 100, Category_X.FRUITS);
		Item b = new Item("banana", 80, Category_X.FRUITS);
		Item c = new Item("cucanva", 120, Category_X.VEGITABLE);
		Item d = new Item("tomato", 150, Category_X.VEGITABLE);

		//List#ofメソッドで不変リスト生成
		List<Item> items = List.of(a, b, c, d);

		//カテゴリごとにグループ化した上で、各グループ内のアイテムから価格が最大のものを1つだけ抽出する処理
		Map<Object, Optional<Item>> maxPriceItemByCategory = items.stream().collect(Collectors
				.groupingBy(i -> i.category(), Collectors.reducing((i1, i2) -> i1.price() > i2.price() ? i1 : i2)));
		//reducing は グループ内の要素を1つに絞る Collector
		// 2つの Item を比較して、価格が高い方を返す。
		maxPriceItemByCategory.forEach((k, v) -> System.out.println(k + ": " + v.orElse(null)));
		//値が存在すればそれを返し、無ければnullを返す
		//Optiona.<Item>の中身があればそのItemを返し、なければnullを返す

	}

}
