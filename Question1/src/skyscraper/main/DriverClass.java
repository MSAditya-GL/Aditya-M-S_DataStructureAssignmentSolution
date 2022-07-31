package skyscraper.main;

import skyscraper.services.FloorSize;

import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		System.out.println("Enter the total No of floors in the building");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];

		System.out.println('\n' + "Note: While entering the floor size, Please Enter the Distinct Floor size" + '\n');
		for (int i = 0; i < size; i++) {
			System.out.println("Enter the floor size given on the day : " + (i + 1));
			arr[i] = sc.nextInt();
		}

		System.out.println();

		FloorSize obj = new FloorSize();
		obj.floorSize(arr);

		sc.close();
	}
}
