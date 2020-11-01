package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import railIl.TrainStation;
import railIl.Travel;

public class SearchTestByLocStation {

	// Assuring correct search of relevant travels by start and end station and
	// start time.
	// edge case check: search stations by name and time( start station) and end
	// station by name. in each travel check all stations until it found && if
	// start station was found in last index it wont consider it ass relevant or
	// if start station appears after end station

	@Test
	public void showTravelListTest1() throws Exception {
		TrainStation trainStation = createTrainStation();
		StringBuffer expectedResult = new StringBuffer();
		expectedResult.append("There are no relevant travels for you");

		assertEquals(expectedResult.toString(), trainStation.searchTravel("Petah Tikva", "Tel Aviv", "10:00", "\n"));
	}

	private TrainStation createTrainStation() throws Exception {
		TrainStation trainStation = new TrainStation();
		Travel travel1 = new Travel();
		travel1.addStation("Petah Tikva", "7:00");
		travel1.addStation("Tel Aviv", "8:00");
		travel1.addStation("Herzelia", "8:30");
		travel1.addStation("Haifa", "9:40");

		trainStation.addTravel(travel1);

		Travel travel2 = new Travel();
		travel2.addStation("Herzelia", "7:00");
		travel2.addStation("Raanana", "7:30");
		travel2.addStation("Tel Aviv", "8:30");
		travel2.addStation("Petah Tikva", "10:00");
		travel2.addStation("Ramat Gan", "11:00");

		trainStation.addTravel(travel2);

		Travel travel3 = new Travel();
		travel3.addStation("Petah Tikva", "7:30");
		travel3.addStation("Herzelia", "8:30");
		travel3.addStation("Tel Aviv", "9:00");

		trainStation.addTravel(travel3);

		Travel travel4 = new Travel();
		travel4.addStation("Herzelia", "7:30");
		travel4.addStation("Raanana", "8:00");
		travel4.addStation("Tel Aviv", "8:40");
		travel4.addStation("Petah Tikva", "10:00");

		trainStation.addTravel(travel4);

		return trainStation;
	}

}
