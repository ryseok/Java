package com.encore.j0524;

import java.io.Serializable;

public class Person implements Serializable{//��ü����ȭ ���� Ŭ����!!
   String name="�츮�浿";
   transient int age=13;//transient: ������ ���� ���� ���� ���� ����
   String job="�л�";
}
