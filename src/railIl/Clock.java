package railIl;

public class Clock {

	private int minutes;
	private int hours;

	public Clock(int hours, int minutes) throws Exception {
		setHours(hours);
		setMinutes(minutes);
	}
	
	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) throws Exception {
		if (minutes < 0 || minutes > 59)
			throw new Exception("Minutes can be between 0 to 59");

		else
			this.minutes = minutes;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) throws Exception {
		if (hours < 1 || hours > 24)
			throw new Exception("Hours can be between 1 to 24");

		else
			this.hours = hours;
	}

	public void show() {
		if (hours < 10)
			System.out.print("0");

		System.out.print(hours + ":");

		if (minutes < 10)
			System.out.print("0");

		System.out.print("minutes");
	}

}
