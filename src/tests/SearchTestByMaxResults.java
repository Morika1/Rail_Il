package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import railIl.TrainStation;
import railIl.Travel;

public class SearchTestByMaxResults {
	
	// Assuring correct search of relevant travels by start and end station and
		// start time.
		// edge case check: check that returns up to 3 relevant results for search
	
	@Test
	public void showTravelListTest1() throws Exception {
		TrainStation trainStation = createTrainStation();
		StringBuffer expectedResult = new StringBuffer("Optional travels for you:\n");
		expectedResult.append("1 Travel details: ");
		expectedResult.append("Petah Tikva, 07:00, Tel Aviv, 08:00, Herzelia, 08:30\n");
		expectedResult.append("2 Travel details: ");
		expectedResult.append("Petah Tikva, 07:20, Tel Aviv, 08:00, Herzelia, 08:30, Haifa, 09:40\n");
		expectedResult.append("3 Travel details: ");
		expectedResult.append("Petah Tikva, 07:30, Herzelia, 08:30, Tel Aviv, 09:00\n");

		assertEquals(expectedResult.toString(), trainStation.searchTravel("Petah Tikva", "Tel Aviv", "7:00","\n"));
	}

	private TrainStation createTrainStation() throws Exception {
		TrainStation trainStation = new TrainStation();
		Travel travel1 = new Travel();
		travel1.addStation("Petah Tikva", "7:20");
		travel1.addStation("Tel Aviv", "8:00");
		travel1.addStation("Herzelia", "8:30");
		travel1.addStation("Haifa", "9:40");

		trainStation.addTravel(travel1);

		Travel travel2 = new Travel();
		travel2.addStation("Haifa", "6:00");
		travel2.addStation("Petah Tikva", "7:00");
		travel2.addStation("Tel Aviv", "8:00");
		travel2.addStation("Herzelia", "8:30");

		trainStation.addTravel(travel2);

		Travel travel3 = new Travel();
		travel3.addStation("Petah Tikva", "7:30");
		travel3.addStation("Herzelia", "8:30");
		travel3.addStation("Tel Aviv", "9:00");

		trainStation.addTravel(travel3);

		
		Travel travel4 = new Travel();
		travel4.addStation("Ramat Gan", "7:30");
		travel4.addStation("Petah Tikva", "8:00");
		travel4.addStation("Herzelia", "8:30");
		travel4.addStation("Tel Aviv", "9:00");

		trainStation.addTravel(travel4);
		
		return trainStation;
	}


}
