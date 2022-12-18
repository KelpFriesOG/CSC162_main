package csc162_finals;

public class HospitalWorker implements Comparable<HospitalWorker> {

	int keycode;
	String lname;
	String fname;
	PhoneNumber phone;
	String department;

	public HospitalWorker(int keycode, String lname, String fname, PhoneNumber phone, String department) {
		this.keycode = keycode;
		this.lname = lname;
		this.fname = fname;
		this.phone = phone;
		this.department = department;
	}

	public int compareTo(HospitalWorker worker) {
		return worker.lname == this.lname ? 0 : this.lname.compareTo(worker.lname) > 0 ? 1 : -1;
	}

	public String toString() {
		String value = keycode + "\t\t\t\t\t" + lname + ", " + fname + "\t\t\t\t\t" + phone.toString() + "\t\t\t\t\t"
				+ department;
		return value;
	}

}
