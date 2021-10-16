package com.greatlearning.dsa.assignment.problem1solution;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class FloorConstruction {
	Queue<Integer> queue = new LinkedList<>();
	Queue<Integer> q1 = new LinkedList<>();
	Scanner sc = new Scanner(System.in);

	int floors;
	int day = 1;
	int flr;

	public void floorConstruct() {

		System.out.println("Enter the total no of floors in the building: ");
		floors = sc.nextInt();
		flr = floors;
		int it = 1;
		do {
			System.out.println("enter the floor size given on day : " + it);
			int x = sc.nextInt();
			if (x >= 1 && x <= floors && !queue.contains(x)) {
				it++;
				queue.add(x);
			} else {
				System.out.println(x + " is not a valid floor size or floor size is already exist");
			}
		} while (it <= floors);
	}

	public void assemble() {
		int count = floors;
		System.out.println("The order of construction is as follows:");

		do {
			System.out.println(" ");
			System.out.println("Day: " + day);
			construct();
			count--;
		} while (count > 0);
	}

	public void construct() {
		while (queue.peek() != null && queue.peek() == floors) {
			System.out.print(queue.remove() + "  ");
			floors--;
			day++;
			break;
		}

		if (q1.peek() != null) {
			while (q1.peek() != null) {
				if (q1.peek() == floors) {
					System.out.print(q1.remove() + "  ");
					floors--;
				} else {
					day++;
					return;
				}

			}
		}

		if (queue.peek() == null && q1.peek() != null) {
			for (int i = 0; i < floors; i++) {
				queue.add(q1.remove());
			}

		}
		if (queue.peek() != null && queue.peek() != floors) {
			q1.add(queue.remove());
			day++;
		}
		while (floors > 0 && q1.peek() != null && queue.peek() == null) {
			while (floors != 0) {
				if (q1.peek() == floors) {
					System.out.print(q1.remove() + "  ");
					floors--;
				} else {
					q1.add(q1.remove());
				}
			}

		}
	}
}
