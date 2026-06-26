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