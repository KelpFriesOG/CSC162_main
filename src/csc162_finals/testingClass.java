package csc162_finals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class testingClass {

	static void bubbleSort(ArrayList<HospitalWorker> workers) {
		for (int i = 0; i < workers.size() - 1; i++) {
			for (int j = i + 1; j < workers.size(); j++) {
				if (workers.get(j).compareTo(workers.get(i)) < 0) {
					HospitalWorker temp = workers.get(i);
					workers.set(i, workers.get(j));
					workers.set(j, temp);
				}
			}
		}
	}

	public static void main(String[] args) {

		try (Scanner kbd = new Scanner(new File("src\\csc162_finals\\hospitalWrk.csv"))) {

			String errorLog = "";
			ArrayList<HospitalWorker> workers = new ArrayList<HospitalWorker>();

			int counter = 0;
			PrintWriter writer = new PrintWriter(new File("report.txt"));

			while (kbd.hasNext()) {

				String nextLine = kbd.nextLine();
				String[] values = nextLine.split(",");

				if (values[2].isEmpty()) {
					errorLog += "Entry " + (counter + 1) + " did not have a last name associated with it.";
					continue;
				}

				if (values[0] == "S") {
					Volunteer vol = new Volunteer(Integer.parseInt(values[1]), values[2], values[3],
							new PhoneNumber(Integer.parseInt(values[4]), Integer.parseInt(values[5]),
									Integer.parseInt(values[6])),
							values[7], values[8], Integer.parseInt(values[9]));
					workers.add(vol);

				} else {
					Staff stf = new Staff(Integer.parseInt(values[1]), values[2], values[3],
							new PhoneNumber(Integer.parseInt(values[4]), Integer.parseInt(values[5]),
									Integer.parseInt(values[6])),
							values[7], values[8], Integer.parseInt(values[9]));
					workers.add(stf);

				}

			}

			System.out.println(errorLog);

			bubbleSort(workers);

			writer.print(
					"Employee Number\t\t\t\t\tName\t\t\t\t\tPhone Number\t\t\t\t\tDepartment\t\t\t\t\tSkill/Position\n");

			for (HospitalWorker worker : workers) {
				writer.print(worker.toString() + "\n");
			}

			writer.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found!");
		} catch (Exception e) {
			System.out.println("An error occured!");
			e.printStackTrace();
		}

	}

}
