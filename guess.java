import java.util.Scanner;
import java.util.Random;
public class guess{
	void binGuess(int min, int max, Scanner in,int go){
		if(min>=max){
			System.out.println("Choice out of range.");
			System.exit(1);
		}
		int guess=(max+1-min)/2+min;
		System.out.println("Guess:"+guess+"\n"+
				"Correct?\n(y)es,(h)igher,(l)ower");
		switch(in.nextLine()){
			case "y":System.out.println("Right in "+go);break;
			case "h":binGuess(guess,max,in,go+1);break;
			case "l":binGuess(min,guess,in,go+1);break;
			default:System.out.println("Wrong!");
				binGuess(min,max,in,go);break;
		}
	}
	void randGuess(int min, int max, Scanner in,int go,Random rd){
		if(min>=max){
			System.out.println("Choice out of range.");
			System.exit(1);
		}
		int guess = rd.nextInt(max+1-min)+min;
		System.out.println("Guess:"+guess+"\n"+
				"Correct?\n(y)es,(h)igher,(l)ower");
		switch(in.nextLine()){
			case "y":System.out.println("Right in "+go);break;
			case "h":randGuess(guess,max,in,go+1,rd);break;
			case "l":randGuess(min,guess,in,go+1,rd);break;
			default:System.out.println("Wrong!");
				randGuess(min,max,in,go,rd);break;
		}
	}
	public static void main(String args[]){
		int min=0,max=100, go=1;
		Scanner in = new Scanner(System.in);
		guess gu=new guess();
		Random rd = new Random();
		System.out.println("Guess 1-100 method:\n1:binary\n2:random");
		switch(Integer.parseInt(in.nextLine())){
			case 1:gu.binGuess(min,max,in,go);break;
			case 2:gu.randGuess(min,max,in,go,rd);break;
			default:
			System.out.println("Invalid Selection.\nAbort.");break;
		}
	}
}
