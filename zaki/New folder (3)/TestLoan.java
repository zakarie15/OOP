import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // Default constructor
    public Loan() {
        this(2.5, 1, 1000);
    }

    // Constructor
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    // Getters
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    // Setters
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Calculate monthly payment
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        int numberOfPayments = numberOfYears * 12;

        return loanAmount * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfPayments));
    }

    // Calculate total payment
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}

public class TestLoan {

    public static void main(String[] args) {

        // Create Loan object
        Loan loan = new Loan();

        // Display loan information
        System.out.println("Annual Interest Rate: "
                + loan.getAnnualInterestRate() + "%");

        System.out.println("Number of Years: "
                + loan.getNumberOfYears());

        System.out.println("Loan Amount: $"
                + loan.getLoanAmount());

        System.out.println("Loan Date: "
                + loan.getLoanDate());

        System.out.println("Monthly Payment: $"
                + loan.getMonthlyPayment());

        System.out.println("Total Payment: $"
                + loan.getTotalPayment());
    }
}