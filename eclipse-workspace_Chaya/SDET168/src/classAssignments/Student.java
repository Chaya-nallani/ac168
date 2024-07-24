package classAssignments;

import java.util.Scanner;

public class Student {
	// variables
	int m1, m2, m3, m4;

	// methods
	public int totalMarks(int m1, int m2, int m3, int m4, String name) {

		int total = m1 + m2 + m3 + m4;
		System.out.printf("Total marks of the student %s are : %d", name, total);
		return total;
	}

	public void average(int total) {
		float avg = total / 4;
		System.out.println("\n Average Marks of the student : " + avg);

	}

	public static void main(String[] args) {
		Student student = new Student();
		Scanner sc = new Scanner(System.in);
		int math,science,social,english;
		
		for(int i = 1; i<=4; i++) {
			System.out.print("\n Enter Student Name :");
			String sname = sc.nextLine();
			System.out.printf("Enter the Math mark :");
			math = sc.nextInt();
			System.out.printf("Enter the science mark :");
			science = sc.nextInt();
			System.out.printf("Enter the social mark :");
			social = sc.nextInt();
			System.out.printf("Enter the english mark :");
			english = sc.nextInt();
			
			int sum = student.totalMarks(math,science,social,english,sname);
			student.average(sum);	
		}
	sc.close();	
	}
}
