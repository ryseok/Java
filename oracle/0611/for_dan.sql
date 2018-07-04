

-- for_dan.sql
/*
  <3단>
   3*1=3
   ...
   3*9=27
   <4단>
   4*1=4
   ...
 */
declare

begin
   -- for () 3~5
   for dan in 3..5  -- 3,4,5 (단수)
   loop
      --몇번실행? 3번
      dbms_output.put_line('<'||dan||'단>');    
   
      -- for ()  1~9      
      for i in 1..9  --1,2,3,4,5,6,7,8,9 (곱하여지는 수)
      loop
          dbms_output.put_line(dan||'*'|| i|| '='|| dan*i); --결과를 화면에 출력
          insert into gugudan (dan,i,result)
                       values (dan,i, dan*i); -- 3*9 = 27행의 insert!!
                                              -- 결과를 테이블에 입력
      end loop;
   end loop;
   
   
end;
/





