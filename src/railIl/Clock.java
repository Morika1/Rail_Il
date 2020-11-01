package railIl;

public class Clock {

	private int minutes;
	private int hours;

	public Clock(int hours, int minutes) throws Exception {
		setHours(hours);
		setMinutes(minutes);
	}

	public Clock() throws Exception {
		this(0, 0);
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

	public boolean compareTime(Clock c1) {
		if (hours > c1.getHours())
			return true;

		else if (hours == c1.getHours()) {
			if (minutes >= c1.getMinutes())
				return true;

			else
				return false;
		} else
			return false;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) throws Exception {
		if (hours < 1 || hours > 23)
			throw new Exception("Hours can be between 1 to 23");

		else
			this.hours = hours;

	}

	public String toSring() {
		String time = new String();
		if (hours < 10)
			time += "0" + hours + ":";
		else
			time += hours + ":";
		if (minutes < 10)
			time += "0" + minutes;
		else
			time += minutes;
		return time;
	}

}


