//level 2 was attempted, with ordinals also being implemented
import java.util.InputMismatchException;
import java.util.Scanner;
public class DaysOfTheYear{

public static void main(String[] args) {
		daysOfTheYear(1, 1);

	}
	 static void daysOfTheYear(int day, int month) {
		
		//Initialise the variables outside of the while loop so they don't reset every loop
		
		String[] months = {
					"January", 
					"February", 
					"March", 
					"April", 
					"May", 
					"June", 
					"July", 
					"August", 
					"September", 
					"October", 
					"November", 
					"December"};
		
		int playerTurn = 4;
		int playerNum = 0;
		String ordinal = "";
		
		//while loop to keep the game running until the end date
		
		while (!((day == 31) && (month == 12))) {
			
			//if statement to select the correct ordinal for the date
			
			if ((day % 10 == 1) && (day != 11)) {
				ordinal = "st";
			}else if ((day % 10 == 2) && (day != 12)) {
				ordinal = "nd";
			}else if ((day % 10 == 3) && (day != 13)) {
				ordinal = "rd";
			}else { 
				ordinal = "th";
			
			}

			//equation to keep the player numbers alternating
			
			playerNum = ((playerTurn % 2) + 1);
			Scanner in = new Scanner(System.in);
			
			System.out.print("The current date is: " + day +  ordinal + " of " + months[month-1] +"\n");
			System.out.print("It is Player " + playerNum + "'s turn!\n");
			System.out.print("Do you want to increase the day or the month? (day or month): ");
			
			String whichPart = in.nextLine();
			
			//while loop to validate the user input
			
			while ((!(whichPart.equalsIgnoreCase("month"))) && (!(whichPart.equalsIgnoreCase("day"))) 
				|| (whichPart.equalsIgnoreCase("month")) && (month == 12) 
				|| ((whichPart.equalsIgnoreCase("day")) && (!isLegalDate((day + 1), month)))) {
				System.out.print("Input invalid, please try again!\n");
				whichPart = in.nextLine();
			}
			
			if ((whichPart.equalsIgnoreCase("month"))  && (month != 12)) {
				int monthCheck = 0;
				System.out.print("Which month do you want to pick: ");
				//while loop to determine whether input is of the correct type
				while (true) {
					try {
						monthCheck = in.nextInt();
						break;
					}catch(InputMismatchException e) {
						System.out.print("Input invalid, please try again!\n");
						in.nextLine();
						}
					}
				//while loop to determine the month selected is legal as a date as well as within the game
				while ((monthCheck <= month) || (!isLegalDate(day, monthCheck))) {
					System.out.print("Input invalid, please try again!\n");	
					while (true) {
						try {
							monthCheck = in.nextInt();
							break;
						}catch(InputMismatchException e) {
							System.out.print("Input invalid, please try again!\n");
							in.nextLine();
							}
					}
				}
				month = monthCheck;
				playerTurn++;
				//while loop to determine the day selected is legal as a date as well as within the game
				}else if ((whichPart.equalsIgnoreCase("day")) && (day !=31)) {
					int dayCheck = 0;
					System.out.print("Which day do you want to pick: ");
					while (true) {
						try {
							dayCheck = in.nextInt();
							break;
						}catch(InputMismatchException e) {
							System.out.print("Input invalid, please try again!\n");	
							in.nextLine();
						}
					}
					while ((!isLegalDate(dayCheck, month)) || (dayCheck <= day)) {		
						System.out.print("Input invalid, please try again!\n");
						while (true) {
						try {
							dayCheck= in.nextInt();
							break;
						}catch(InputMismatchException e) {
							System.out.print("Input invalid, please try again!\n");
							in.nextLine();
							}
						}
					
					}
					day = dayCheck;
					//increase the player turn integer so that the value will alternate
					playerTurn++;
				
					}
				
			}
		
		System.out.print("The current date is: " + day +  ordinal + " of " + months[month-1] +"\n");
		System.out.print("Player " + playerNum + " is the winner of the game!\n");	
	}

	

static boolean isLegalDate(int dayLegal, int monthLegal) {
	//boolean function to validate a given date to ensure that it is legal
	if (dayLegal > 31 || monthLegal > 12 || dayLegal < 1 || monthLegal < 1) {
		return false;
		
	} else if ((monthLegal == 2) & (dayLegal > 28)) {
		return false;
		
	} else if ((monthLegal == 4 || monthLegal == 6 || monthLegal == 9 || monthLegal == 11) & dayLegal <=30) {
		return true;
		
	} else if (monthLegal != 4 && monthLegal != 6 && monthLegal != 9 && monthLegal != 11) {
		return true;
		
	} 
		return false; 
	
	
	}

}
