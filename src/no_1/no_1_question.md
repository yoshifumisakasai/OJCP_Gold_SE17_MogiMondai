#設問1    
  
  以下の定義に従い、module.yのmodule-info.javaとして最も適切なものを選べ（１つ）  
  module.xは、module-yに依存している  
  module.yは、com.foo.barパッケージをほかのモジュールに公開している  
  module.y自体は他のモジュールに依存していない  


  A. module module.y{
  exports com.foo.bar;
  }

  B. module module.y{
  requires module.x;
  exports com.foo.bar;
  }

  C. module module.y{
  exports com.foo.bar to module.x;
  }


  D. module module.y{
  requires module.x
  }
  
  
  
#判断に迷った部分は？  
 1.AかCで迷う
  B,Dはrequires記述していて、他のモジュールに依存しているので、選択肢としては除外
  Cは、exports構文が間違っている、exportx XXXXXXXXXX to YYYYYY
  toという書き方はしない
  なので正解はAと思った。


#試験観点は？（選択肢の正誤の判断材料）  
