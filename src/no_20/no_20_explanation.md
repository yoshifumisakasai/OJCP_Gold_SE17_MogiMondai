#解説


#❌ A. modb と modc はモジュール moda の public クラスにアクセスできる
NG理由
requires は
一方向

moda → modb, moda → modc の依存

modb → moda ではない

modc → moda でもない

つまり：

modb と modc は moda にアクセスできない





#✔ B. モジュール moda はモジュール modb の sample.b パッケージの public クラスにアクセスできる
OK理由
moda は modb を requires

modb は sample.b を exports

だから moda は sample.b にアクセスできる




#❌ C. モジュール modb はすべてのモジュールの sample.b パッケージにアクセスできる
NG理由
modb は exports しているだけ

**exports は「公開する」だけであり、アクセス権を得るわけではない**  

modb は誰も requires していないので、他モジュールにアクセスできない




#❌ D. モジュール modc はモジュールに含まれる public クラスをすべてのモジュールに対して暗黙的に exports できる
NG理由
暗黙的 exports は存在しない

exports を書かない限り、外部から見えない

modc は exports がないので、外部からアクセス不可




#❌ E. モジュール moda は、モジュール modc のすべてのクラスにアクセスできる
NG理由
modc は exports をしていない

exports がないパッケージは外部から見えない

**requires していても exports がなければアクセス不可**  

つまり：

**requires だけではアクセスできない。exports が必要。**  




