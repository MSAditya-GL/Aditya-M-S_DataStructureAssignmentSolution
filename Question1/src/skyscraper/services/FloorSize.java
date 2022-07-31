package skyscraper.services;

import java.util.Arrays;
import java.util.Stack;

public class FloorSize {

	public boolean largestNo;

	public void floorSize(int[] array) {

		Stack<Integer> s = new Stack<Integer>();

		int n = array.length; // size of array
		for (int i = 0; i < n; i++) {
			largestNo = true;
			int input = array[i];
			for (int j = i; j < n; j++) {
				if (j == i) {
					continue;
				} else {
					int tempIn = array[j];
					if (input >= tempIn) {
						largestNo = true;

					} else {
						largestNo = false;
						s.push(input);
						break;
					}
				}
			}

			if (largestNo == true) {
				try {
					Stack<Integer> sTemp = floorOutput(s, input, i, array);
					s.clear();
					s = (Stack<Integer>) sTemp.clone();
					sTemp.clear();
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Day: " + (i + 1) + '\n');
			}
		}
	}

	public static Stack<Integer> floorOutput(Stack<Integer> s1, int currentFloor, int recursion, int[] temp) {
		int size = temp.length;
		int[] floorPop = new int[size];
		int count = 0;

		System.out.println("Day: " + (recursion + 1));
		System.out.print(currentFloor);

		Stack<Integer> sTemp = new Stack<Integer>();
		boolean max;
		if (recursion == size - 1) {
			while (!s1.empty()) {
				int popFloor = s1.pop();
				floorPop[count++] = popFloor;
			}
			if (floorPop != null) {
				Arrays.sort(floorPop);
				for (int k = size - 1; k > 0; k--) {
					if (floorPop[k] != 0) {
						System.out.print(" " + floorPop[k]);
					}
				}
			}
			return sTemp;
		} else {
			if (!s1.empty()) {
				while (!s1.empty()) {
					max = true;
					int popFloor = s1.pop();
					for (int l = recursion; l < size; l++) {
						if (l == recursion) {
							continue;
						}
						if (popFloor < temp[l]) {
							sTemp.push(popFloor);
							max = false;
							break;

						} else {
							max = true;

						}
					}
					if (max == true) {
						floorPop[count++] = popFloor;
					}
				}
			}
			if (floorPop != null) {
				Arrays.sort(floorPop);
				for (int k = size - 1; k > 0; k--) {
					if (floorPop[k] != 0) {
						System.out.print(" " + floorPop[k]);
					}
				}
			}
			return sTemp;
		}
	}
}
