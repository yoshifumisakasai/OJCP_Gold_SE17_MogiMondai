package no_56;

import java.util.stream.Stream;

public class Stream_gen {

	public static void main(String[] args) {
		Stream a = Stream.of(1, 2, 3);
		Stream<Integer> b = a.map(n -> n + 1);
//【コンパイルエラー】
//		この行に複数マーカーがあります
//		- 演算子 + は引数の型 Object, int で未定義です
//		- 型の安全性: 型 Stream の式は、未検査の型変換を使用して Stream<Integer> に準拠するようにする必要があります
//		- 型の安全性: メソッド map(Function) は raw 型 Stream に属しています。総称型 Stream<T> への参照はパラメーター化され
//	る必要があります
		b.forEach(n -> System.out.println(n));
	}

}
