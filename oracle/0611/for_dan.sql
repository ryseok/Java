

-- for_dan.sql
/*
  <3��>
   3*1=3
   ...
   3*9=27
   <4��>
   4*1=4
   ...
 */
declare

begin
   -- for () 3~5
   for dan in 3..5  -- 3,4,5 (�ܼ�)
   loop
      --�������? 3��
      dbms_output.put_line('<'||dan||'��>');    
   
      -- for ()  1~9      
      for i in 1..9  --1,2,3,4,5,6,7,8,9 (���Ͽ����� ��)
      loop
          dbms_output.put_line(dan||'*'|| i|| '='|| dan*i); --����� ȭ�鿡 ���
          insert into gugudan (dan,i,result)
                       values (dan,i, dan*i); -- 3*9 = 27���� insert!!
                                              -- ����� ���̺� �Է�
      end loop;
   end loop;
   
   
end;
/





