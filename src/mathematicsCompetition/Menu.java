package mathematicsCompetition;

import java.util.*;

public class Menu {
	
	// declaration of all the required instance variables
	int cheapHouse, chosenHouse, medianHouse;
	int priceAvo;
	int numOfAvoWeek;
	int numOfAvo;
	
	
	// method to display the welcome message
	public void displayWelcomeMsg() {
		System.out.println("*********************************************************************************************");
		System.out.println("                                SAVE A HOUSE DEPOSIT CALCULATOR                              ");
		System.out.println("              Developed by Student, Student ID 30332807 for ITECH1000 Sem 2 2017             ");
		System.out.println("*********************************************************************************************");
	}
	
	// method to display the menu system in the console
	public void displayMenu(){
		System.out.println("Please select an option from the menu");
		System.out.println("1. Enter House Prices");
        System.out.println("2. Enter Avocado on Toast Price");
        System.out.println("3. Deposit Calculator");
        System.out.println("4. Exit System");
		
	}
	
	// Menu system using switch case 	
	public void startMenuSystem(){
		displayMenu();
		Scanner scan = new Scanner(System.in);
		int option = scan.nextInt();
		switch(option){
		case 1 :
			enterHousePrices();
			break;
			
		case 2 :
			enterAvoPrice();
			break;
			
		case 3 :
			calculateDeposit();
			break;
			
		case 4 :
			System.out.println("The House Deposit Calculator is now exiting,");
			System.exit(0);
            
			
		default:
			System.out.println("Invalid Option. Please enter the option from given menu");
			this.startMenuSystem();
			break;
		}
		while(option!=4);	
		scan.close();
		
	}
	
	
	

    // method to enter house prices
	private void enterHousePrices() {
		System.out.println("House Details:");
		
		System.out.println("Enter asking price for cheapest house listing: $");
		Scanner scan = new Scanner(System.in);
		if(!scan.hasNextInt()){
			System.out.println("Invalid input: please retry:");
			this.enterHousePrices();
		}else
		this.cheapHouse=scan.nextInt();
		
		System.out.println("Enter asking price for your chosen house: $");
		if(!scan.hasNextInt()){
			System.out.println("Invalid input: please retry:");
			this.enterHousePrices();
		}else
		this.chosenHouse=scan.nextInt();
		
		System.out.println("Enter the median house value for this area: $");
		if(!scan.hasNextInt()){
			System.out.println("Invalid input: please retry:");
			this.enterHousePrices();
		}else
		this.medianHouse=scan.nextInt();
		if(this.cheapHouse<this.chosenHouse && this.cheapHouse<this.medianHouse){
			this.startMenuSystem();
		}
		else 
			System.out.println("Please retry as the cheapest house is expensive than the other house!");
			this.enterHousePrices();
		
		
	}
	//method to enter the price of avacado
	private void enterAvoPrice() {
		System.out.println("Enter the price (in whole dollars) of avocado on toast from a local cafe or restaurant: $ ");
		Scanner scan = new Scanner(System.in);
		this.priceAvo = scan.nextInt();
		this.startMenuSystem();
	}
	
	//method to calculate the deposit amount
	private void calculateDeposit() {
		double depositOfCheap = 0.2*this.cheapHouse;
		double depositOfChosen = 0.2*this.chosenHouse;
		double depositOfMedian = 0.2*this.medianHouse;
		System.out.println("DEPOSIT SAVING CALCULATOR");
		System.out.println("*********************************************************************************************");
		System.out.println("You will need to NOT buy:");
		System.out.println(String.format( "%.2f",depositOfCheap/this.priceAvo)+" smashed avocados on toast to save a "+ String.format( "%.2f",depositOfCheap) + " deposit for the cheapest house");
		System.out.println(String.format( "%.2f",depositOfChosen/this.priceAvo)+" smashed avocados on toast to save a "+ String.format( "%.2f",depositOfChosen)+ " deposit for your chosen house");
		System.out.println(String.format( "%.2f",depositOfMedian/this.priceAvo)+" smashed avocados on toast to save a "+ String.format("%.2f",depositOfMedian) + " deposit for a house at the median price");
		System.out.println("*********************************************************************************************");
		System.out.println("How many times a week do you purchase avocado on toast?");
		this.numOfAvo = (int) (depositOfChosen/this.priceAvo);
		this.weekOfDeposit();		
		this.startMenuSystem();
	}
	
	// advanced functionality to calculate the date to save the calculated deposit amount
	private void weekOfDeposit(){
		Scanner scan = new Scanner(System.in);
		this.numOfAvoWeek = scan.nextInt();
		Calendar cal = GregorianCalendar.getInstance();
		cal.add(Calendar.DAY_OF_WEEK_IN_MONTH, this.numOfAvo/this.numOfAvoWeek);
		System.out.println("If you stop buying avocado on toast starting from today and save the money instead,");
		System.out.println("your deposit for a "+this.chosenHouse+" house will be saved in the week of "+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
	    //System.out.println("DD/MM/YYYY : "+ cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR));
		
	}
	
	

}
