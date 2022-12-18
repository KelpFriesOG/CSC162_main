package csc162_finals;

public class PhoneNumber {
	String state;
	int areaCode;
	int exchange;
	int number;

	public PhoneNumber(int areaCode, int exchange, int number) {

		this.state = "NJ";
		this.areaCode = areaCode;
		this.exchange = exchange;
		this.number = number;

	}

	public String toString() {
		return areaCode + "-" + number;
	}

}
