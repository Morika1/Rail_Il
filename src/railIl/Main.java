package railIl;

public class Main {

	
	public static void main(String[] args) {
		
		
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		final int EXIT = -1;
		int option;

		Clock clock;
		boolean isValidInput = false;

		while (!isValidInput) {
			System.out.println("Enter hours and minutes: ");
			try {
				clock = new Clock(scan.nextInt(), scan.nextInt());
				System.out.println("The time is " + clock);
				isValidInput = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		ManagmentSystem managmentSystem = new ManagmentSystem();
		do {
			System.out.println("Choose one of the following options: ");
			System.out.println("1) Typing travel information");
			System.out.println("2) Show the sorting travel list");
			System.out.println("9) " + EXIT);
			option = scan.nextInt();

			switch (option) {
			case 1:
				System.out.println("Please enter travel's details: start time, end time, start station, end station");
				Travel travel= new Travel(scan.next(), scan.next(), scan.next(), scan.next());
				break;
			case 2:
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
		


