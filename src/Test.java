import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
   public static void main(String[] args) throws IOException {
	  Scanner scan = new Scanner(System.in);//.useDelimiter("\\s+");
	  System.out.print("�μ� �Է�:");
	  int x = scan.nextInt();
	  int y = scan.nextInt();
	  System.out.println("x="+x);
	  System.out.println("y="+y);
  }
}
