設問20

次のモジュールの説明として、正しいものを選べ（１つ）

```
module moda {
   requires modb;
   requires modc;
}


module modb {
   exports sample.b;
}


module modc {
}
```



A. modbとmodcはモジュールmodaのpublicクラスにアクセスできる


B. モジュールmodaはモジュールmodbのsample.bパッケージのpublicクラスにアクセスできる


C. モジュールmodbはすべてのモジュールのsample.bパッケージにアクセスできる


D. モジュールmodcはモジュールに含まれるpublicクラスをすべてのモジュールに対して暗黙的にexportsできる


E. モジュールmodaは、モジュールmodcのすべてのクラスjにアクセスできる




#解いたときの所感(1回目）    
20.B
  Cの回答：間違っている理由を説明できない
  Aの回答、NG理由わからない
  Dの回答、暗黙Exportsはされないはず
  E回答NG理由は？、exportsしているパッケージに対してアクセスできる


#観点、意図
🧭 出題者の意図（試験観点）  
この問題は以下を理解しているかを試す。  

##①  
requires は「依存関係を宣言するだけ」  
**requires した側が 依存先の exports されたパッケージにアクセスできる**  

*requires された側は 逆方向にはアクセスできない*  


##②  
exports は「公開するパッケージを宣言するだけ」
**exports されたパッケージの public クラスだけが外部から見える**  

*exports していないパッケージは外部から見えない*  


##③  
exports されていないモジュールのクラスは外部からアクセス不可  
modc は exports がない  
→ modc のクラスは外部から見えない  
→ moda は modc のクラスにアクセスできない  

##④  
requires transitive がない限り、依存関係は伝播しない  
この問題では transitive がない  
→ modb → modc → moda のような連鎖アクセスは起きない  





#この問題の最短暗記セット  
・requires → 依存宣言（アクセス権は exports が必要）  

・exports → 公開宣言（public クラスだけ見える）  

・exports がないモジュールは外部から見えない  

・依存は一方向（requires された側は逆方向にアクセスできない）  

・暗黙的 exports は存在しない  




#解いたときの所感(2回目）    
以下の、１か２、どちらの意図の出題なのかわからなかった
**（１）この設問20が、Exports/Requiresの関係性を問う出題**
**（２）「名前付きモジュール vs 無名モジュール vs 自動モジュール」の話の理解を問う出題か**  

↓

```
module-info.java がある時点で すべて名前付きモジュール  
無名モジュールや自動モジュールは module-info.java が無い場合にのみ発生する   
```
