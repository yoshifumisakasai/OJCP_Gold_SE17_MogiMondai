#map(Item::name)の出力の形式は？
Item → name（String）に変換  

戻り値の生成ストリーム：
"melon", "mango", "orange", "apple", "banana"



#Collectors.joining(",", "[", "]")とはどういうコードか？
joining の仕様：

区切り文字：,

先頭：[

末尾：]

出力の形式結果：  
[melon,mango,orange,apple,banana]  

※joining の内部仕様（Collector としての動作）  
`joining は Collector<CharSequence, StringBuilder, String> を返す`  

**（戻り値型のCollectorインタフェース型）**                                                   

T = CharSequence（ストリームの要素）  

A = StringBuilder（中間バッファ）  

R = String  




〇メソッド仕様：  
`public static Collector<CharSequence,?,String> joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)`  
                                                       


パラメータ:  
delimiter - 各要素間で使用される区切り文字  
prefix - 連結結果の先頭で使用される文字シーケンス  
suffix - 連結結果の末尾で使用される文字シーケンス  

戻り値:  
CharSequence要素を検出順に指定された区切り文字で区切りながら連結するCollector  




□joining(",", "[", "]") の動作を具体的に説明  
ストリーム要素：

<Listのデータ情報>
melon, mango, orange, apple, banana


`joining(",", "[", "]")`  
↓↓  
先頭に [ を付ける  

要素を , で連結  

最後に ] を付ける  



#Collectors.joining は 3 つのオーバーロードを持つ  


`① joining()`  
区切りなしで連結
例：["a","b","c"] → "abc"


`② joining(CharSequence delimiter)`  
区切り文字を挟んで連結
例：joining(",") → "a,b,c"


`③ joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix)`  
区切り＋先頭＋末尾
例：joining(",", "[", "]") → "[a,b,c]"

