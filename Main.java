import java.util.Scanner;
import java.io.*; 

public class Main {

	public static void main(String[] args) {
		long e1, e2;
		boolean exit = false;
		Scanner stdin = new Scanner(System.in);
		System.out.print("Enter order of the polynom: ");
		int ord = stdin.nextInt();
		PBF p1 = new PBF(ord,false);
		PBF p2 = new PBF(ord,false);
		long startTime = System.nanoTime();
		PBF p3 = p1.Mx(p2);
		e1 = System.nanoTime() - startTime;
		PDnC p4 = new PDnC(p1);
		PDnC p5 = new PDnC(p2);
		startTime = System.nanoTime();
		PDnC p6 = p4.Mx(p4,p5);
		e2 = System.nanoTime() - startTime;
		System.out.println();
		System.out.println("========================================");
		System.out.println("= Choose (with number):                =");
		System.out.println("========================================");
		System.out.println("= 1. Show Polynoms                     =");
		System.out.println("= 2. Show Result with Brute Force      =");
		System.out.println("= 3. Show Result with Divide n Conquer =");
		System.out.println("= 4. Exit                              =");
		System.out.println("========================================");
		while (!exit) {
			System.out.print("Input the number choice : ");
			switch(stdin.nextInt()) {
				case 1:
					System.out.println("Polynom 1: "); p1.ShowPoly();
					System.out.println();
					System.out.println("Polynom 2: "); p2.ShowPoly();
					break;
				case 2:
					p3.ShowM();
					System.out.println("Multiplication with Brute Force : "); p3.ShowPoly();
					System.out.println("Execution Time with BruteForce     : "+e1/1000+" microseconds");
					break;
				case 3:
					p6.ShowM();
					System.out.println("Multiplication with Divide n Conquer : "); p6.ShowPoly();
					System.out.println("Execution Time with Divide and Conquer  : "+e2/1000+" microseconds");
					break;
				case 4:
					exit = true;
					break;
				default:
					System.out.println("Bad Input!");
			}
			System.out.println();
		}
	}
}