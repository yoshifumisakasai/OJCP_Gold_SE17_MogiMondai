#Localeについて  
`Java の java.util.Locale は final クラスであり、インタフェースではない。`  

**「言語＋国（地域）を表すための不変オブジェクト」**  
＝ “日本語（ja）＋日本（JP）” のような文化圏情報をまとめた 値オブジェクト。  


■ Locale の正体：final class  
JavaDoc ：  
パッケージ：java.util
*修飾子：public final class Locale*  
親クラス：Object
*インタフェース実装：なし*  

クラスの仕様：  
`・継承できない（final）`  
`・インタフェースではない`    
`・ただの値を持つクラス`  



A.正しい  
**Locale.JAPAN** 
⇒Java が提供する 定数 Locale("ja", "JP")  
**language = "ja"**  
**country = "JP"**  



B.間違い  
❌ B. Locale.ja_JP → そもそも存在しない（コンパイルエラー）
*Locale.ja_JP という定数は Java には存在しない。*  

`Locale.JAPAN はある`    

`Locale.JAPANESE はある`    

**でも Locale.ja_JP は無い**  

試験では「存在しない定数」を選ばせる罠。


C.間違い  
❌ C. Locale.JAPANESE → 出力は「ja」  
Locale.JAPANESE ：  

language = "ja"

**country = ""（空）**  

つまり toString() ：  
`ja`  
**「ja_JP」にはならない。**  


D.間違い
`❌ D. Locale.getInstance("ja_JP") → これは存在しないメソッド`  
`Locale.getInstance(String) は Java に存在しない。`  

正しいのは：
**Locale.forLanguageTag("ja-JP")**  

**new Locale("ja", "JP")**  



E.間違い  
`❌ E. new Locale.Builder().setLanguage("ja").setCountry("JP") → build() が無いのでコンパイルエラー`  
`Locale.Builder は build() を呼ばないと Locale にならない。`  

つまり：  
**new Locale.Builder().setLanguage("ja").setCountry("JP")**  
**これは Locale ではなく Builder のまま。**  
**println() に渡せないので コンパイルエラー。**  


F.正しい  
✅ F. new Locale.Builder().setLanguage("ja").setRegion("JP").build() → 正しく「ja_JP」  
Builder の正しい使い方。  

language = "ja"  

region = "JP"  