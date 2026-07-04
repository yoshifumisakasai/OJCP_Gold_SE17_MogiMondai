package no_14;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_14 {
	public static void main(String[] args) {
		//ArraysクラスのasListメソッドで固定サイズのリストを生成
		List<String> list = Arrays.asList("C", "B", "A", "D");
		
		//コード1
		list.sort((a, b) -> a.compareTo(b));
		list.forEach(e -> System.out.printf("%s", e));
		

		//コード2
		Collections.sort(list);;
		list.forEach(e -> System.out.printf("%s", e));
	}
}