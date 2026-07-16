#設問5  
  次の選択肢のうち、コンソール出力が「ja_JP」となるもの選べ（２つ）  
  A.System.out.println(Locale.JAPAN);  
  
  B.System.out.println(Locale.ja_JP);  
  
  C.System.out.println(Locale.JAPANESE);  
  
  D.System.out.println(Locale.getInstance("ja_JP"));  
  
  E.System.out.println(new Locale.Builder().setLanguage("ja").setCountry("JP"));  
  
  F.System.out.println(new Locale.Builder().setLanguage("ja").setRegion("JP").build());    


  
  
#迷った部分(設問解き1回目）  
  5.わからない、説明できない.どれも正しくみえてしまう。

  
#迷った部分(設問解き2回目）

B,Fかと思った。
Eは、.buildないのでNG

DのgetInstanceという書き方はない、
Cの；Locale.JAPANESEとは無いような  

Aだと、JAPANだけだと、国名しか出ない、ja_JPとならない気がした


以下の勘違いをしている点：
`Locale.JAPAN` 
⇒国名「JP」しか出力されない
⇒正しくは、言語「ja」＋国「JP」が出力される

`Locale.JAPANESE`  
⇒言語「ja」しか出力されない
⇒はい、こちらは「ja」のみ

