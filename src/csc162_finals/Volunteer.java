package csc162_finals;

public class Volunteer extends HospitalWorker {
	String skill;
	int age;

	public Volunteer(int keycode, String lname, String fname, PhoneNumber phone, String department, String skill,
			int age) {
		super(keycode, lname, fname, phone, department);
		this.skill = skill;
		this.age = age;
	}

	public String toString() {
		return super.toString() + "\t\t\t\t\t" + skill;
	}

}
