#Path.resolve の仕様

（resolve のルール2つ）  


`① 右側が相対パスなら「左側にくっつける」`  

`"/a".resolve("b/c")`
 → "/a/b/c"  



`② 右側が絶対パスなら「右側をそのまま返す」`  

`"/a".resolve("/x/y")`  
 → "/x/y"  