package user;

import java.io.File;

import railIl.TrainStation;

public class UsersMain {

	public static void main(String[] args) throws Exception {
		if (args.length > 0 && args[0].equalsIgnoreCase("html"))
			method(args, "<\br>");
		else
			method(args, "\n");

	}

	private static void method(String[] args, String type) throws Exception {
		File dailyTravelsRepository = new File("TravelList.txt");
		TrainStation trainStation = new TrainStation(dailyTravelsRepository);
		String time = args[3] + ":" + args[4];
		System.out.println(trainStation.searchTravel(args[1], args[2], time, type));
	}
}