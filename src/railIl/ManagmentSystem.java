package railIl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManagmentSystem {

	private ArrayList<Travel> allTravels;

	public ManagmentSystem() {
		allTravels = new ArrayList<Travel>();
	}

	public void showTravelList() {
		for (int i = 0; i < allTravels.size(); i++) {
			allTravels.get(i).showTravelDetails();
		}
	}

	public void addTravel(Travel travel) {
		allTravels.add(travel);

	}

	public void sortTravelsByStartTime() {
		Collections.sort(allTravels);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Travels today are:\n");
		for (int i = 0; i < allTravels.size(); i++) {
			sb.append((i + 1) + " " + allTravels.get(i).toString() + "/n");
		}
		return sb.toString();
	}

}
