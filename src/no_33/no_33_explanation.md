#raw 型（非ジェネリクス）
`List list_x = new ArrayList<Integer>();`  
**左辺が raw 型（非ジェネリクス）List**    
*右辺は ArrayList<Integer> だが、左辺が raw 型なので 右辺も raw 型として扱われる*  


〇コンパイラ解釈：  

1. raw 型扱いコード    
List list_x = new ArrayList();  

※「raw 型（非ジェネリクス）List を使った瞬間に、ジェネリクスの型情報が消える」という Java の仕様


左辺は List 型なんだから、List<Integer> のように扱われても良いのでは？

`Java のジェネリクス：raw 型を使った時点で型安全性が完全に失われる`  
`左辺が raw 型 List の時点で、右辺の ArrayList<Integer> の型情報は消滅し、コンパイラは「List<Object>」として扱う`  
その結果、ラムダ式の n は Object 型になり、 n.x() がコンパイルエラーになる。  


2. raw 型の List に対する forEach
`list_x.forEach(n -> System.out.println(n.x()));`  

※raw 型の List の forEach は次のように解釈：

void forEach(Consumer<Object> action)
**つまりラムダ式の n は Object 型 と推論される。**  


3. Object に x() メソッドは存在しない  
n.x()  
コンパイルエラー    
（NoSuchMethodException ではなく、実行以前の問題）  



#本質
この設問コードでは、
**raw 型でも、ジェネリクス指定でも、このコードは必ずコンパイルエラーになる**  
*理由は「Integer に x() メソッドが存在しない」ためで、raw 型かどうかは関係ない*  

`ただし、エラーの“種類”が違う`  



■①  
**raw 型 List list_x → ラムダの型推論が Object になり、Object に x() がないのでエラー**  

```
この行に複数マーカーがあります
	- 型の安全性: メソッド forEach(Consumer) は raw 型 Iterable に属しています。総称型 Iterable<T> への参照はパラメーター化される必要があります
	- メソッド x() は型 Object で未定義です
```

■②  
**ジェネリクス List<Integer> list_y → ラムダの型推論が Integer になり、Integer に x() がないのでエラー`**  


`メソッド x() は型 Integer で未定義です`  
 
 

**どちらも x() が存在しないためコンパイルエラーだが、エラーの原因が違う**  
**エラーの“理由”が異なる点が Java Gold の重要ポイント**  
