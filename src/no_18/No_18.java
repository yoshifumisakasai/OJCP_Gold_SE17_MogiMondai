package no_18;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// flatMap 使い方
//List<List<Integer>> を1本の Stream に平坦化する検証クラス
public class No_18 {

	public static void main(String[] args) {
		List<Integer> a = List.of(50, 60, 70, 80);
		List<Integer> b = List.of(40, 50, 60, 70);

		//【A】
		//Stream#flatMap(Stream, Stream)は存在しない
		//Stream#flatMapメソッド：単一のストリームに対して使用するメソッド
		//2つの引数を取るオーバーロードはされていない
		dobule avg_z = Stream.flatMap(a.stream(), b.stream()).mapToInt(i -> i).average().agetAsDouble;

		//【B】処理分解して解説↓↓
		
		//(1)Stream#ofメソッド
		//2つのリストをストリーム化
		//a と b の 2つの List<Integer> を 1 本の Stream に合体
		//全要素（50,60,70,80,40,50,60,70）の 平均値を計算
		
		//(1)-1
		//List::stream
		//List<Integer> を受け取って Stream<Integer> を返すメソッド参照
		
		//(2)flatMap()
		//2つのリストの中身（Integer型）を展開

		//(3)Collectors#averagingDouble
		//各要素をdouble型に変換しながら平均値を計算
		double avg = Stream.of(a, b).flatMap(List::stream).collect(Collectors.averagingDouble(d -> d));
		System.out.println(avg);

		//【C】
		//（コンパイルエラー）
		//
		double avg1 = List.of(a, b).stream().flatMap(s -> s.stream()).map(d -> d).average().orElse(0.0);

		//【D】
		//コンパイルエラー
		//型の不一致: OptionalDouble から double には変換できません
		//Stream#mapToIntメソッド：int型に変換
		double avg2 = Stream.of(a, b).flatMap(s -> s.stream()).mapToInt(i -> i).average();
		//mapToInt() の結果は IntStreamインタフェース型 になり、average() は double ではなく OptionalDouble型を返す。

		//【E】
		//コンパイルエラー
		//型 Stream のメソッド concat(Stream<? extends T>, Stream<? extends T>) は引数 
		//(List<Integer>, List<Integer>) に適用できません
		//Stream#concat
		//2つのStremを受け取る静的メソッド、引数としてList型を渡せない
		double avg_y = Stream.concat(a, b).strem().collect(Collectors.averagingDouble(Integer::doubleValue));
	}

}
