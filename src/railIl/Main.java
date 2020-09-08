package railIl;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		final int EXIT = 9;
		int option;


		ManagmentSystem managmentSystem = new ManagmentSystem();
		boolean isValidInput=false;
		
		
		do {
			System.out.println("Choose one of the following options: ");
			System.out.println("1) Typing travel information");
			System.out.println("2) Show the sorting travel list");
			System.out.println("9) Exit");
			option = scan.nextInt();

			switch (option) {
			case 1:
				
				
				
				
				
				
				while (!isValidInput) {
					System.out.println("Please enter travel's details: Start time");
					String startTime= scan.next();
					System.out.println("Start station");
					String startStation= scan.nextLine();
					System.out.println("Middle time");
					String middleTime=scan.next();
					System.out.println("Intermidate Station");
					String intermidateStation=scan.nextLine();
					System.out.println("End time");
					String endTime= scan.next();
					System.out.println("End station");
					String endStation=scan.nextLine();
					
					try {
						Travel travel = new Travel(startTime,middleTime,endTime, startStation,intermidateStation, endStation);
						isValidInput = true;
						managmentSystem.addTravel(travel);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case 2:
				managmentSystem.sortTravelsByStartTime();
				managmentSystem.showTravelList();
				break;
			case EXIT:
				System.out.println("Goodbye :-)");
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (option != EXIT);

	

	}

}
	


