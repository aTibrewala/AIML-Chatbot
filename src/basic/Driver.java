package basic;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		KnowledgeBase kb = new KnowledgeBase();
		System.out.println("Please type your question and press Enter. To close type exit.");

		Scanner scan = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			String question = scan.nextLine();
			System.out.println("Human: "+question);
			kb.reply(question);
		}	System.out.println("Thank You!");
		
	}

}
