

-- for_test.sql  '���� SQL�� ���ƿ�!!'

declare

begin
  
  for i in 1..10
  loop
    dbms_output.put_line('���� SQL�� ���ƿ�!!==>'|| i);
  end loop;
  -- 10���� 1���� ȭ�����!!
  dbms_output.put_line('--------------------------');
  
  for i in reverse 1..10
  loop
    dbms_output.put_line(i);
  end loop;
  
  
end;
/



