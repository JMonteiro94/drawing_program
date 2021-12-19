package com.coding.drawing;

import java.util.Scanner;

public class DrawingApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter command: ");
		while(sc.hasNextLine()){
			String command = getCommand(sc);
			if("Q".equals(command)) break;

		}
	}

	private static String getCommand(Scanner scanner) {
		System.out.print("enter command: ");
		return scanner.nextLine();
	}
}
