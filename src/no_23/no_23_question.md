設問23

「令和07年01月01日水曜日」と出力するための日付のパターン文字列として正しいものを選べ（１つ）


A. GGyy年MM月dd日EE

B. Gyy年MM月dd日E

C. GGGGGyy年MM月edd日EE

D. GGGyy年dd日EEE


E. GGGGyy年MM月dd日EEEE



#所感  
23.チンプンカンプンわからない



#出題意図    
和暦（JapaneseImperialCalendar）のパターン文字を正しく理解しているか」 


#🧭 出題者の意図（試験観点）
この問題は以下を理解しているかを試す：

① G（元号） の使い方  
*G → 略称（例：R）*  
**GGGG → フル表記（例：令和）**  

※GGGGG → 長すぎて不正（存在しない）  




② y（和暦の年） の使い方  
yy → 2桁（07）  
y → 1桁（7）  

③ MM / dd（ゼロ埋め）  
MM → 01  
dd → 01  


`④ EEEE（曜日のフル表記）`  
E → 水  

EE → 水  

EEE → 水  

EEEE → 水曜日  
