package com.vinod.poker;

import java.util.Scanner;

public class KeyboardUtil {
	public static int getInt(String msg){
		Scanner scanner = new Scanner(System.in);
		System.out.print(msg);
		return scanner.nextInt();
	}
}
