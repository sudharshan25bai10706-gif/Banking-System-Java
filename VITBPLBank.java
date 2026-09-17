import java.util.ArrayList;
import java.util.Scanner;

public class VITBPLBank {

    static Scanner sc = new Scanner(System.in);

    // ================= ACCOUNT DATA =================
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Integer> pins = new ArrayList<>();
    static ArrayList<Double> minDeposits = new ArrayList<>();

    // ================= DEPOSIT DATA =================
    static ArrayList<String> depNames = new ArrayList<>();
    static ArrayList<String> depDates = new ArrayList<>();
    static ArrayList<Double> depAmounts = new ArrayList<>();

    // ================= WITHDRAWAL DATA =================
    static ArrayList<String> withNames = new ArrayList<>();
    static ArrayList<String> withDates = new ArrayList<>();
    static ArrayList<Double> withAmounts = new ArrayList<>();


    // ================= CREATE ACCOUNT =================
    static void createAccount() {

        System.out.println("\n===== Create Account =====");

        System.out.print("Full name: ");
        String name = sc.nextLine();

        System.out.print("Enter a 4digit pin:");
        int pin = sc.nextInt();

        int pinLength = String.valueOf(pin).length();

        if (pinLength != 4) {
            System.out.println("invalid pin");
        }

        System.out.print("Enter the min balance:");
        int minDeposit = sc.nextInt();
        sc.nextLine();

        if (minDeposit < 500) {
            System.out.println("Insufficient deposit");
        } else {
            addAccount(name, pin, minDeposit);
            System.out.println("SUCCESSFULLY ADDED");
        }

        // Display accounts
        System.out.println("\nName\t\tPin\t\tMin_deposit");

        for (int i = 0; i < names.size(); i++) {
            System.out.println(
                    names.get(i) + "\t\t" +
                    pins.get(i) + "\t\t" +
                    minDeposits.get(i)
            );
        }
    }


    // ================= ADD ACCOUNT =================
    static void addAccount(String name, int pin, double minDeposit) {

        names.add(name);
        pins.add(pin);
        minDeposits.add(minDeposit);
    }


    // ================= DEPOSIT =================
    static void deposit() {

        System.out.println("===== The Deposited Amount =====");

        System.out.print("Enter Account Name: ");
        String name = sc.nextLine();

        System.out.print(" Enter The Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter The Deposit Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        depNames.add(name);
        depDates.add(date);
        depAmounts.add(amount);

        System.out.println("SUCCESSFULLY DEPOSITED");

        // Display deposit table
        System.out.println("\nName\t\tDep_Date\tDep_amt");

        for (int i = 0; i < depNames.size(); i++) {

            System.out.println(
                    depNames.get(i) + "\t\t" +
                    depDates.get(i) + "\t" +
                    depAmounts.get(i)
            );
        }
    }


    // ================= WITHDRAW =================
    static void withdraw() {

        System.out.println("===== The Withdrawn Amount =====");

        System.out.print("Enter Account Name: ");
        String name = sc.nextLine();

        System.out.print(" Enter The Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter The Withdraw Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        withNames.add(name);
        withDates.add(date);
        withAmounts.add(amount);

        System.out.println("SUCCESSFULLY WITHDRAWN ");

        // Display withdrawal table
        System.out.println("\nName\t\tWth_Date\tWth_amt");

        for (int i = 0; i < withNames.size(); i++) {

            System.out.println(
                    withNames.get(i) + "\t\t" +
                    withDates.get(i) + "\t" +
                    withAmounts.get(i)
            );
        }
    }


    // ================= CHECK BALANCE =================
    static void balance() {

        System.out.println("===== Your Balance =====");

        System.out.print("Enter Account Name: ");
        String name = sc.nextLine();

        int accountIndex = -1;

        // Find account
        for (int i = 0; i < names.size(); i++) {

            if (names.get(i).equals(name)) {
                accountIndex = i;
                break;
            }
        }

        // Account not found
        if (accountIndex == -1) {
            System.out.println("Account not found.");
            return;
        }

        // Display account details
        System.out.println("\nName\t\tPin\t\tMin_deposit");

        System.out.println(
                names.get(accountIndex) + "\t\t" +
                pins.get(accountIndex) + "\t\t" +
                minDeposits.get(accountIndex)
        );


        // ================= TOTAL DEPOSIT =================

        double depSum = 0;

        for (int i = 0; i < depNames.size(); i++) {

            if (depNames.get(i).equals(name)) {
                depSum = depSum + depAmounts.get(i);
            }
        }

        System.out.println("Total Deposited: " + depSum);


        // ================= TOTAL WITHDRAWAL =================

        double wthSum = 0;

        for (int i = 0; i < withNames.size(); i++) {

            if (withNames.get(i).equals(name)) {
                wthSum = wthSum + withAmounts.get(i);
            }
        }

        System.out.println("Total Withdrawn: " + wthSum);


        // ================= CURRENT BALANCE =================

        double minDeposit = minDeposits.get(accountIndex);

        double balanceAmount = minDeposit + depSum - wthSum;

        System.out.println("Current Balance: " + balanceAmount);
    }


    // ================= LIST ACCOUNTS =================
    static void listAccounts() {

        System.out.println("=====All Bank Accounts=====");

        if (names.size() == 0) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\nName\t\tPin\t\tMin_deposit");

        for (int i = 0; i < names.size(); i++) {

            System.out.println(
                    names.get(i) + "\t\t" +
                    pins.get(i) + "\t\t" +
                    minDeposits.get(i)
            );
        }
    }


    // ================= MAIN MENU =================
    static void mainMenu() {

        while (true) {

            System.out.println("\nWelcome to vit bpl bank");
            System.out.println("1) Create account");
            System.out.println("2) Deposit");
            System.out.println("3) Withdraw");
            System.out.println("4) Check balance");
            System.out.println("5) List all accounts ");
            System.out.println("0) Exit");

            System.out.print("Select an option: ");

            String choice = sc.nextLine();

            if (choice.equals("1")) {

                createAccount();

            } else if (choice.equals("2")) {

                deposit();

            } else if (choice.equals("3")) {

                withdraw();

            } else if (choice.equals("4")) {

                balance();

            } else if (choice.equals("5")) {

                listAccounts();

            } else if (choice.equals("0")) {

                System.out.println("Goodbye!");
                break;

            } else {

                System.out.println("Invalid option");
            }
        }
    }


    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        System.out.println("\n===== WELCOME TO VIT BPL BANK ====\n");

        mainMenu();
    }
}