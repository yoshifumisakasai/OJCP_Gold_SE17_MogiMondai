 
  #設問2  
  `record Item(String name, int price){}`  
  
  ```
  @FunctionalInterface
  interface Test{
   String toString(Item employee);
  }
```

```  
  public class Sample{
   public static void main(String[] args){
   //insert code hire
   Item apple = new Item("Apple", 100);
   System.out.println(t.toString(apple));
   }
  }
  ```
  
  以下のような結果が出力されるために、insert code hereに入るコードで適切なものはどれか（１つ選べ）  
  Apple is 100 yen.  
  
  
  A. Test t= (String s) -> s.toString(e);    
  
  B. Test t= e-> {return e.toString();};  
  
  C. Test t = e-> e.getName()+"is"+e.getPrice()+"yen.";  
  
  D. Test t = str -> str.name+"is"+str.price+"yen.";  
  
  E. Test t =(Item e)->{return e.name()+"is"+e.price()+"yen.";};  
