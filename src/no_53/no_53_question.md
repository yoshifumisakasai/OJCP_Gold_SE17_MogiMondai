
設問53


```
package Generics;

import java.util.Set;

public class TreeSet {
	public static void main(String[] args) {
	
		Set<String> set = new java.util.TreeSet<>();
		

		set.add("B");
		set.add("D");
		set.add("A");
		set.add("C");
		set.add("A");

		set.stream().forEach(System.out::println);
	}

}
```


#設問といたきの所感

53.Aかあ
   TreeSetクラスは自動昇順へ並び替えなので


#設問を限定するための前提知識

・「TreeSet の並び順を理解しているか」を問う典型的な Silver 問題で、昇順（自然順序）で並ぶ   

<HashSet と TreeSet の違い>  

HashSet → 順序保証なし  

TreeSet → 自然順序（昇順）  


#試験観点  
今回の設問は TreeSet の自然順序を知っているか を問うだけ  

