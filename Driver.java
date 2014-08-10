//Dailyprogrammer hard challenge Week 1
//Guessing game.
//Pick a number and the computer will guess it.
//Features: Game modes.  PC picks random, binary search, other.
//Features: Pick (y) Yes, (h) Higher, (l) lower.

import java.util.Scanner;
import java.util.Random;

public class Driver{
	int max = 100,
	    min = 0;

	int randGuess(int min, int max){
		Random rand = new Random();
		return (rand.nextInt(max+1-min)+min);
	}

	int binGuess(int min, int max){
		return ((max+1-min)/2+min);
	}

	void allMenu(int min, int max, int guess){
		System.out.println("Current guess (" + min + "-"
			       + max + "): " + guess);
		System.out.println("(h) Higher, (l) Lower, or (c)"
				+ "Correct?");

	}

	String errHandle(String input,int min,int max){
		if(min==max){
			input="c";
			System.out.println("Invalid Range!");
		}
		return input;
	}

	void randMenu(Scanner in){
		String input = "";
		for(int gNum=1;!input.equals("c");gNum++){
			int guess=randGuess(min,max);
			allMenu(min,max,guess);
			input=in.nextLine();
			if(input.equals("h")){
				min=guess;
				input=errHandle(input,min,max);
			}
			else if(input.equals("l")){
				max=guess;
				input=errHandle(input,min,max);
			}
			else if(input.equals("c")){
				System.out.println("Guessed in "
					+ gNum + " tries!");
			}
		}
	}

	void binMenu(Scanner in){
		String input = "";
		for(int gNum=1;!input.equals("c");gNum++){
			int guess=binGuess(min,max);
			allMenu(min,max,guess);
			input=in.nextLine();
			if(input.equals("h")){
				min=guess;
				input=errHandle(input,min,max);
			}
			else if(input.equals("l")){
				max=guess;
				input=errHandle(input,min,max);
			}
			else if(input.equals("c")){
				System.out.println("Guessed in "
					+ gNum + " tries!");
			}
		}
	}

	void menu(Scanner in){
		System.out.println("Select an option:\n1)Random");
		System.out.println("2)Binary");
		int opt = Integer.parseInt(in.nextLine());
		if(opt == 1){
			randMenu(in);
		}
		else if(opt == 2){
			binMenu(in);
		}
		else{

		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Driver drive = new Driver();
		drive.menu(in);
	}
}
