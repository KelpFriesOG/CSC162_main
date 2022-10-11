package labs;

public class Loan {

    private double annualInterestRate; // Has to be greater than 0
    private int numberOfYears; // Has to be greater than 0
    private double loanAmount; // Has to be greater than 0
    private java.util.Date loanDate;

    /** Default constructor */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate,
     * number of years and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
            double loanAmount) {
        setAnnualInterestRate(annualInterestRate);
        // this.annualInterestRate = annualInterestRate ()
        setLoanAmount(loanAmount);
        // this.loanAmount = loanAmount (if loanAmount > 0)
        setNumberOfYears(numberOfYears);
        // this.numberOfYears = numberOfYears (if numberOfYears > 0)
        loanDate = new java.util.Date();
    }

    /** Return annualInterestRate */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /** Set a new annualInterestRate */
    public void setAnnualInterestRate(double annualInterestRate)
            throws IllegalArgumentException {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.annualInterestRate = annualInterestRate; //
        }
    }

    /** Return numberOfYears */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /** Set a new numberOfYears */
    public void setNumberOfYears(int numberOfYears)
            throws IllegalArgumentException {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.numberOfYears = numberOfYears;
        }
    }

    /** Return loanAmount */
    public double getLoanAmount() {
        return loanAmount;
    }

    /** Set a newloanAmount */
    public void setLoanAmount(double loanAmount)
            throws IllegalArgumentException {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.loanAmount = loanAmount;
        }
    }

    /** Find monthly payment */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
        return monthlyPayment;
    }

    /** Find total payment */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /** Return loan date */
    public java.util.Date getLoanDate() {
        return loanDate;
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        try {
            Loan loan = new Loan(0.05, -5, 10000);
        } catch (IllegalArgumentException e) {
            System.out.println("Ran into an error!");
        }

    }

}
