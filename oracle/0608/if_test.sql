

-- if_test.sql
-- 두 수를 비교

declare
  su1 number;
  su2 number := 10;
  
begin
  su1 := 13;  -- PL/SQL내에서 대입,치환 연산자는  새우(:=)다!!

  if(su1 < su2)
     then dbms_output.put_line(su1||'은 '||su2||'보다 작다!!');
  end if;

  if su1 >= su2
   then  dbms_output.put_line(su1||'은 '||su2||'보다 크거나 같다!!');
  end if; 
  
end;
/



