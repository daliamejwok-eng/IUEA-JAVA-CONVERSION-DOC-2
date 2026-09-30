import java.util.Scanner;

/**
 * Program: Microfinance Bank Savings Interest Calculator
 * Course Code: BIT2115
 * Description: Demonstrates implicit (widening) and explicit (narrowing)
 *              data conversion and potential precision loss in Java.
 */
public class MicrofinanceInterest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- 1. USER INPUT (Whole Number Deposit) ---
        System.out.print("Enter Customer Deposit Amount (UGX): ");
        int depositWhole = scanner.nextInt();

        System.out.print("Enter Annual Interest Rate (%): ");
        double interestRate = scanner.nextDouble();

        // --- 2. IMPLICIT (AUTOMATIC / WIDENING) CONVERSION ---
        // int depositWhole is automatically promoted to double during calculation
        double depositAsDouble = depositWhole; // Safe widening conversion (int to double)
        double calculatedInterest = depositAsDouble * (interestRate / 100.0);
        double totalBalanceWithInterest = depositAsDouble + calculatedInterest;

        // --- 3. EXPLICIT (MANUAL / NARROWING) CONVERSION ---
        // Manual casting from double to long/int required for accounting report
        long roundedInterestAccounting = (long) calculatedInterest;
        long roundedFinalBalanceAccounting = (long) totalBalanceWithInterest;

        // --- 4. ACCURACY LOSS ANALYSIS ---
        double truncationLoss = calculatedInterest - roundedInterestAccounting;

        // --- 5. GENERATE SUMMARY REPORT ---
        System.out.println("\n==================================================");
        System.out.println("       MICROFINANCE INTEREST REPORT               ");
        System.out.println("==================================================");
        System.out.println("Original Deposit (int):              UGX " + depositWhole);
        System.out.println("Implicitly Converted Deposit (double): UGX " + depositAsDouble);
        System.out.println("Interest Rate:                       " + interestRate + "%");
        System.out.println("Calculated Exact Interest (double):  UGX " + calculatedInterest);
        System.out.println("Exact Total Balance (double):        UGX " + totalBalanceWithInterest);
        System.out.println("--------------------------------------------------");
        System.out.println("ACCOUNTING REPORT (Explicitly Cast to Whole Numbers):");
        System.out.println("Management Rounded Interest (long):   UGX " + roundedInterestAccounting);
        System.out.println("Management Final Balance (long):     UGX " + roundedFinalBalanceAccounting);
        System.out.println("--------------------------------------------------");
        System.out.println("Data Accuracy Analysis:");
        System.out.println("Truncated Fractional Loss:           UGX " + truncationLoss);
        System.out.println("==================================================");

        scanner.close();
    }
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    IO.println(String.format("Hello and welcome!"));

    for (int i = 1; i <= 5; i++) {
        //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
        // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        IO.println("i = " + i);
    }
}
