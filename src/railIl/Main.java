package railIl;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		final int EXIT = 9;
		int option;

		ManagmentSystem managmentSystem = new ManagmentSystem();

		do {
			System.out.println("Choose one of the following options: ");
			System.out.println("1) Typing travel information");
			System.out.println("2) Show the sorting travel list");
			System.out.println("9) Exit");
			option = scan.nextInt();

			switch (option) {
			case 1:

				boolean isValidInput = false;
				while (!isValidInput) {

					System.out.println("How mant stations in total there are in the travel?");
					int numOfTotalStations = scan.nextInt();
					try {
						managmentSystem.addTravel(new Travel(numOfTotalStations, scan));

						isValidInput = true;

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
