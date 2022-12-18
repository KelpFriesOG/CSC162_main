
package csc162_finals;

public class Staff extends HospitalWorker {

	String position;
	int yearHired;

	public Staff(int keycode, String lname, String fname, PhoneNumber phone, String department, String position,
			int yearHired) {
		super(keycode, lname, fname, phone, department);
		this.position = position;
		this.yearHired = yearHired;
	}

	public String toString() {
		return super.toString() + "\t\t\t\t\t" + position;
	}

}
