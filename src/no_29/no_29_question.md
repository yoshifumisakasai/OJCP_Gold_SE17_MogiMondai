設問29


モジュールsample.aのSampleインタフェースを実装するクラスを定義するには、モジュールsample.bのmodule-info.javaにどのように記述すればよいか。正しいものを選べ（１つ）


A. implements api.impl.SampleImpl;


B. opens api.impl.SampleImpl to api.Sample;


C. services api.imple.SampleImpl for api.Sample


D. provides api.Sample with api.impl.SampleImpl;


E. uses api.Sample;




#設問のポイントについて  

設問のポイントは：

モジュール sample.a の Sample インタフェース をモジュール sample.b が 実装クラスを提供するにはを理解する

〇サービスプロバイダ機構（Service Provider Mechanism）
**Java の JPMS では、サービスを提供する側（実装クラスを持つモジュール）は、module-info.java に provides ... with ... を書く**  



〇利用者側はどうコードを書くか？  
`uses api.Sample;`  
これは サービス利用側（consumer）が書くもの  
