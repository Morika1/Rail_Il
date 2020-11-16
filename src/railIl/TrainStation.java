package railIl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TrainStation {

	private ArrayList<Travel> allTravels;

	public TrainStation() {
		allTravels = new ArrayList<Travel>();
	}

	public TrainStation(File file) throws Exception {
		allTravels = new ArrayList<Travel>();
		Scanner fileScan = new Scanner(file);
		if (fileScan.hasNext()) {
			int numOfTravels = Integer.parseInt(fileScan.nextLine());
			for (int i = 0; i < numOfTravels; i++) {
				this.addTravel(new Travel());
				int numOfStations = Integer.parseInt(fileScan.nextLine());
				for (int j = 0; j < numOfStations; j++) {
					String stationName = fileScan.nextLine();
					String time = fileScan.nextLine();
					this.allTravels.get(i).addStation(stationName, time);

				}

			}
		}
		fileScan.close();

	}

	public String showTravelList() {
		sortTravelsByStartTime();
		if (allTravels.size() == 0)
			return "No travels yet";

		return this.toString();
	}

	public void addTravel(Travel travel) {
		allTravels.add(travel);

	}

	public int getNumOfDailyTravels() {
		return allTravels.size();
	}

	Comparator<Travel> compareByTime = new Comparator<Travel>() {

		public int compare(Travel travel1, Travel travel2) {
			if (travel1.getStations().get(0).getLeavingTime().getHours() < travel2.getStations().get(0).getLeavingTime()
					.getHours())
				return -1;

			else if (travel1.getStations().get(0).getLeavingTime().getHours() == travel2.getStations().get(0)
					.getLeavingTime().getHours()) {
				if (travel1.getStations().get(0).getLeavingTime().getMinutes() < travel2.getStations().get(0)
						.getLeavingTime().getMinutes())
					return -1;

				if (travel1.getStations().get(0).getLeavingTime().getMinutes() > travel2.getStations().get(0)
						.getLeavingTime().getMinutes())
					return 1;

				else
					return 0;

			} else
				return 1;
		}
	};

	public void sortTravelsByStartTime() {
		Collections.sort(allTravels, compareByTime);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < allTravels.size(); i++) {
			sb.append((i + 1) + " " + allTravels.get(i).toString() + "\n");
		}
		return sb.toString();
	}

	public void save(PrintWriter pw) throws IOException {
		StringBuffer sb = new StringBuffer(getNumOfDailyTravels() + "\n");
		for (int i = 0; i < allTravels.size(); i++) {
			allTravels.get(i).save(sb);
			System.out.println();
		}
		pw.println(sb);

		pw.close();

	}

	private String printArray(ArrayList<Travel> array, String type) {
		StringBuffer sb = new StringBuffer("Optional travels for you:" + type);
		for (int i = 0; i < array.size(); i++) {
			sb.append((i + 1) + " " + array.get(i).toString() + type);

		}
		return sb.toString();

	}

	public String searchTravel(String startStation, String endStation, String startTime, String type) throws Exception {
		if (allTravels.size() == 0) {
			return "Travel list is empty";
		}

		Travel travel = new Travel(startStation, endStation, startTime);
		ArrayList<Travel> selectedTravels = new ArrayList<Travel>();
		final int MAX_NUM_OF_RES = 3;
		for (int i = 0; i < allTravels.size() && selectedTravels.size() < MAX_NUM_OF_RES; i++) {
			if (allTravels.get(i).SearchTravel(travel)) {
				selectedTravels.add(new Travel(allTravels.get(i).getStations()));
			}

		}
		removeUnrelevantStations(selectedTravels, startStation);

		if (selectedTravels.size() == 0)
			return "There are no relevant travels for you";

		Collections.sort(selectedTravels, compareByTime);
		return printArray(selectedTravels, type);

	}

	private void removeUnrelevantStations(ArrayList<Travel> selectedTravels, String startStation) {
		for (int i = 0; i < selectedTravels.size(); i++) {
			if (selectedTravels.get(i).checkRelevantIndex(startStation) != 0) {
				int index = selectedTravels.get(i).checkRelevantIndex(startStation);
				selectedTravels.get(i).removeUnNeededStations(index);

			}

		}

	}

}
