
public class Test4 extends Thread{
	
   @Override
	public void run() {
	   System.out.println("run");
	}	
	
   public static void main(String[] args) {
	   Test4 t4 = new Test4();//������ ��ü!!
	   
	   t4.start();
	   
	   new Test4().start();
   }
}
