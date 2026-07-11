package no_53;

import java.util.Set;

public class TreeSet {
	public static void main(String[] args) {
		//【コンパイルエラー】
		//型 TreeSet は総称ではありません。引数 <> でパラメーター化できません
		//（原因）
		//	[Java判断]
		//	「プロジェクト内に TreeSet という名前のクラス がある。
		//	でもそのクラスは ジェネリクス型ではない。
		//	new TreeSet<>() のように型引数を付けるのは間違い。」
		//	⇒Java が参照しているのは java.util.TreeSet ではなく、あなた自身の TreeSet クラス。
		// プロジェクト内のTreeSet クラスが java.util.TreeSet より優先
		
		//【NGコード】
		//Set<String> set = new TreeSet<>();
		
		Set<String> set = new java.util.TreeSet<>();
		//Setインタフェース（インタフェースSet<E>）
		//重複する要素を持たないことを保証するコレクション
		
		//HashSetクラス（Setインタフェースの実装）
		//要素の並び順の保証なし

		//TreeSetクラス（Setインタフェースの実装）クラスTreeSet<E>
		//自然順序で並び替え
		set.add("B");
		set.add("D");
		set.add("A");
		set.add("C");
		set.add("A");

		set.stream().forEach(System.out::println);
	}

}
