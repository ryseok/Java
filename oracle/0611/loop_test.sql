


--loop_test.sql (1부터 10까지 출력)

declare
  i number := 0;
  j number := 3;
begin
  loop    
     i := i+1;
     dbms_output.put_line('안녕!!==>'|| i);
     exit when i=10;
  end loop;

  dbms_output.put_line('-------------------');
  -- 화면에 3, 6, 9 출력(loop사용)
  
  loop    
     dbms_output.put_line(j);
     j := j+3;
     
     if(j>9) 
       then exit; 
     end if;
     
  end loop;
  
  
end;
/
