#コンパイルエラーの原因について

`Stream a が raw 型（非ジェネリクス）`  

→ **a.map(...) の戻り値も raw 型扱いになる**  
→ **raw 型の map は Function も raw 型になる**  

→ ラムダ式 n -> n + 1 の n は Object と推論される  



n は Object  

1 は int  

```
Object + int は不可能  
→ コンパイルエラー  
```

#整理まとめ

**raw 型 → ラムダの型推論が壊れる → コンパイルエラー**  