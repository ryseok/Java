
public class Test4 extends Thread{
	
   @Override
	public void run() {
	   System.out.println("run");
	}	
	
   public static void main(String[] args) {
	   Test4 t4 = new Test4();//½º·¹µå °´Ã¼!!
	   
	   t4.start();
	   
	   new Test4().start();
   }
}
