

-- for_test.sql  '나는 SQL이 좋아요!!'

declare

begin
  
  for i in 1..10
  loop
    dbms_output.put_line('나는 SQL이 좋아요!!==>'|| i);
  end loop;
  -- 10부터 1까지 화면출력!!
  dbms_output.put_line('--------------------------');
  
  for i in reverse 1..10
  loop
    dbms_output.put_line(i);
  end loop;
  
  
end;
/



