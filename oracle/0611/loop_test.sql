


--loop_test.sql (1���� 10���� ���)

declare
  i number := 0;
  j number := 3;
begin
  loop    
     i := i+1;
     dbms_output.put_line('�ȳ�!!==>'|| i);
     exit when i=10;
  end loop;

  dbms_output.put_line('-------------------');
  -- ȭ�鿡 3, 6, 9 ���(loop���)
  
  loop    
     dbms_output.put_line(j);
     j := j+3;
     
     if(j>9) 
       then exit; 
     end if;
     
  end loop;
  
  
end;
/
