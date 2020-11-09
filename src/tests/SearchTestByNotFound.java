package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import railIl.TrainStation;
import railIl.Travel;

public class SearchTestByNotFound {

	// Assuring correct search of relevant travels by start and end station and
	// start time.
	// edge case check: check that not relevant travel was found in case there
	// is no match

	@Test
	public void showTravelListTest1() throws Exception {
		TrainStation trainStation = createTrainStation();
		StringBuffer expectedResult = new StringBuffer();
		expectedResult.append("There are no relevant travels for you");

		assertEquals(expectedResult.toString(), trainStation.searchTravel("Petah Tikva", "Tel Aviv", "10:00","\n"));
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
		travel2.addStation("Tel Aviv", "6:00");
		travel2.addStation("Raanana", "6:40");
		travel2.addStation("Haifa", "7:30");
		travel2.addStation("Rosh Pina", "9:00");

		trainStation.addTravel(travel2);

		Travel travel3 = new Travel();
		travel3.addStation("Petah Tikva", "7:30");
		travel3.addStation("Herzelia", "8:30");
		travel3.addStation("Tel Aviv", "9:00");

		trainStation.addTravel(travel3);

		return trainStation;
	}

}
