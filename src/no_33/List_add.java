package no_33;

import java.util.ArrayList;
import java.util.List;

public class List_add {

	public static void main(String[] args) {
		List list_x = new ArrayList<Integer>();
		List<Integer> list_y = new ArrayList<Integer>();
		//ArrayListのインスタンス（実体）を生成、<Integer> はジェネリクス（型パラメータ）
		//		左側 → インターフェース（List）
		//		右側 → 実装クラス（ArrayList）

		list_x.add(Integer.valueOf(1));
		list_x.add(Integer.valueOf(2));
		list_x.add(Integer.valueOf(3));
		//		この行に複数マーカーがあります
		//		- 型の安全性: メソッド forEach(Consumer) は raw 型 Iterable に属しています。総称型 Iterable<T> への参
		//	照はパラメーター化される必要があります
		//		- メソッド x() は型 Object で未定義です
		list_x.forEach(n -> System.out.println(n.x()));

		list_y.add(Integer.valueOf(1));
		list_y.add(Integer.valueOf(2));
		list_y.add(Integer.valueOf(3));

		//コンパイルエラー「しかし前回のようなジェネリクス型に関するエラーではない」
		//	この行に複数マーカーがあります
		//	- メソッド x() は型 Integer で未定義です
		//	- 'list_x' の出現箇所
		list_y.forEach(n -> System.out.println(n.x()));

	}

}
