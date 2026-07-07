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
