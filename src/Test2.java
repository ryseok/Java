import java.util.Scanner;

public class Test2 {
   public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
	   
	   int cnt=0;
	   while(true) {
		  System.out.print("x:");
		  int x = scan.nextInt();
		  scan.skip("\r\n");
		  System.out.print("line:");
		  String str = scan.nextLine();
		  System.out.print("y:");
		  int y = scan.nextInt();
		  System.out.println("x="+x);
		  System.out.println("y="+y);
		  System.out.println("str="+str);
	   }
   }
}
