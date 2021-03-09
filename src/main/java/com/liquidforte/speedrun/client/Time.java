package com.liquidforte.speedrun.client;

public class Time implements Comparable<Time> {
	private int hours, minutes, seconds;

	public Time() {}

	public Time(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		return String.format("%dH %dM %dS", hours, minutes, seconds);
	}

	/**
	 * This is the implementation for Comparable. It first compares the hours, then minutes, then seconds.
	 * This is an example of how comparable can be implemented for a complex object.
	 * For strings, you can do str.compareTo(str2) and check if it's greater than, less than, or equal to zero.
	 * @param other the Time to compare to
	 * @return { -1 when this < other, 0 when this == other, 1 when this > other }
	 */
	@Override
	public int compareTo(Time other) {
		if (this.hours < other.hours) {
			// this < other
			return -1;
		} else if (this.hours > other.hours) {
			// this > other
			return 1;
		} else {
			if (this.minutes < other.minutes) {
				// this < other
				return -1;
			} else if (this.minutes > other.minutes) {
				// this > other
				return 1;
			} else {
				if (this.seconds < other.seconds) {
					// this < other
					return -1;
				} else if (this.seconds > other.seconds) {
					// this > other
					return 1;
				} else {
					// this == other
					return 0;
				}
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Time) {
			Time other = (Time) obj;

			return this.hours == other.hours && this.minutes == other.minutes && this.seconds == other.seconds;
		}
		return false;
	}
}