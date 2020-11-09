package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import railIl.TrainStation;
import railIl.Travel;

public class TrainStationTest {
	// Assuring correct sorting by leaving time. checks both hour and minute.

	@Test
	public void showTravelListTest1() throws Exception {
		TrainStation trainStation = createTrainStation();
		StringBuffer expectedResult = new StringBuffer();
		expectedResult.append("1 Travel details:\n");
		expectedResult.append("Tel Aviv, 06:00, Raanana, 06:40, Haifa, 07:30, Rosh Pina, 09:00, \n");
		expectedResult.append("2 Travel details:\n");
		expectedResult.append("Petah Tikva, 06:30, Herzelia, 07:30, Tel Aviv, 08:30, \n");
		expectedResult.append("3 Travel details:\n");
		expectedResult.append("Petah Tikva, 07:00, Tel Aviv, 08:00, Herzelia, 08:30, Haifa, 09:40, \n");

		assertEquals(expectedResult.toString(), trainStation.showTravelList());
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
		travel3.addStation("Petah Tikva", "6:30");
		travel3.addStation("Herzelia", "7:30");
		travel3.addStation("Tel Aviv", "8:30");

		trainStation.addTravel(travel3);

		return trainStation;
	}

}
