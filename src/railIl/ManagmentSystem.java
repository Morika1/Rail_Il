package rail_IL;

public class ManagmentSystem {

	private Travel[] allTravels;
	private int numberOfTravels;
	private final int MAX_NUMBER_OF_TRAVELS=100;
	
	public ManagmentSystem() {
		allTravels=new Travel[MAX_NUMBER_OF_TRAVELS];
		numberOfTravels=0;
	}



	public void showTravelList() {
		for (int i = 0; i < numberOfTravels; i++) {
			allTravels[i].showTravelDetails();
		}
		
	}
}
