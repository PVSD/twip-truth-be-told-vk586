package com.company;
import java.util.Scanner;
import java.io.*;
import javax.script.ScriptException;

public class Main {

    public static void main(String[] args) throws IOException, ScriptException {
		System.out.println("User, please input the amount of boolean operations you will add to the table.");
		Scanner in = new Scanner(System.in);
		int index = in.nextInt();

    	String[] operations = new String[index + 2];
		operations[0] = "A";
		operations[1] = "B";

		int [] spaceL = new int[operations.length];
		spaceL[0] = 1;
		spaceL[1] = 1;

		int tracker = index;
		for (int i = 2; i < operations.length; i++) {
			System.out.println("Please input your boolean expression. " + tracker + " to go.");
			Scanner sc = new Scanner(System.in);
			operations[i] = sc.nextLine();
			spaceL[i] = operations[i].length();
			tracker--;
		}


		ftTable table = new ftTable(operations);

		PrintWriter writer = new PrintWriter("outputTable.txt", "UTF-8");
		String row = "";
		for (int k = 0; k < operations.length; k++) {
			row = row + operations[k] + " ";
		}
		row = row + "\n";
		String space = "";

		for (int f = 0; f < operations.length; f++) {
			for (int s = 0; s <= spaceL[f]; s++) {
				space = space + " ";
			}
			row = row + table.constructTable(table.tt)[f] + space;
			space = "";
		}
		writer.println(row);
		writer.close();

    }
}
