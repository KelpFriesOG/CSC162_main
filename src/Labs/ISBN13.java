package labs;

public class ISBN13 {

    public String calculateISBN(String value) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {

        int[] numbers = new int[12];
        int formula = 0;

        for (int i = 0; i < 12; i++) {
            numbers[i] = Character.getNumericValue(value.charAt(i));
            // .charAt will automatically throw StringIndexOutOfBoundsException if the
            // string (value) is too short.
            if (numbers[i] == -1) {
                // if the output of Character.getNumericValue() is -1, then the
                // value we worked on was not a number! We need to throw an
                // exception to let the main method know
                // that we do not want this!
                throw new IllegalArgumentException();
            }
        }

        formula = 10 - (numbers[0] + 3 * numbers[1] + numbers[2] + 3 * numbers[3]
                + numbers[4] + 3 * numbers[5] + numbers[6] + 3 * numbers[7] + numbers[8] +
                3 * numbers[9] + numbers[10] + 3 * numbers[11]) % 10;

        return value + String.valueOf(formula);
    }

}
