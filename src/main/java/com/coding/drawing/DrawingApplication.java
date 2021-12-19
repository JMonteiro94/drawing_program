package com.coding.drawing;

import java.util.Scanner;

public class DrawingApplication {

	private static CanvasUpdateService canvasUpdateService;

	public static void main(String[] args) {
		canvasUpdateService = new CanvasUpdateService();
		Scanner sc = new Scanner(System.in);
		System.out.print("enter command: ");
		while(sc.hasNextLine()){
			String command = sc.nextLine();
			if("Q".equals(command)) break;
			canvasUpdateService.newCommand(command);
			System.out.print("enter command: ");
		}
	}
}
