package railIl;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner scan = new Scanner(System.in);

		final int EXIT = 9;
		int option;

		File file = new File("TravelList.txt");
		PrintWriter pw = new PrintWriter(file);

		TrainStation trainStation = new TrainStation();

		do {
			System.out.println(
					"Choose one of the following options:\n1) Typing travel information\n2) Show the sorting travel list\n3)Search travel\n4) Save data\n9) Exit ");
			option = scan.nextInt();

			switch (option) {
			case 1:

				boolean isValidInput = false;
				while (!isValidInput) {

					System.out.println("How many stations in total there are in the travel?");
					int numOfTotalStations = scan.nextInt();
					try {
						trainStation.addTravel(new Travel(numOfTotalStations, scan));

						isValidInput = true;

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				break;
			case 2:
				System.out.println(trainStation.showTravelList());
				break;
			case 3:
				System.out.println("What is your start station?");
				scan.nextLine();
				String startStation = scan.nextLine();
				System.out.println("What is your final station?");
				String endStation = scan.nextLine();
				System.out.println("What is leaving time?");
				String time = scan.nextLine();

				System.out.println(trainStation.searchTravel(startStation, endStation, time, "\n"));
				break;
			case 4:
				trainStation.save(pw);

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
