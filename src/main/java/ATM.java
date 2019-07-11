import java.util.Scanner;

public class ATM {

    private static Scanner in;
    private static float balance = 0;
    private static int anotherTransaction;

    public static void main(String args[]) {
        in = new Scanner(System.in);
        System.out.println("Welcome!");
        getBalance();
        transaction();
    }

    private static void transaction() {
        int choice;

        System.out.println("Please select an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");
        System.out.println("4. Cancel");

        choice = in.nextInt();

        switch (choice) {
            case 1:
                int amount;
                System.out.println("Please enter amount to withdraw: ");

                amount = in.nextInt();

                if (amount < 0) {
                    System.out.println("Enter a natural number!");
                    anotherTransaction();
                } else if (amount > balance || amount == 0) {
                    System.out.println("You have insufficient funds!!\n");
                    anotherTransaction();
                } else {
                    balance = balance - amount;
                    System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + ".\n");
                    numberOfBanknotes(amount);
                    anotherTransaction();
                }
                break;

            case 2:
                float deposit;
                System.out.println("Please enter amount you would wish to deposit: ");
                deposit = in.nextFloat();
                if (deposit > 0) {
                    balance = deposit + balance;
                    System.out.println("You have deposited " + deposit + "! New balance is " + balance + ".\n");
                    anotherTransaction();
                } else {
                    System.out.println("Enter a natural number!");
                    anotherTransaction();
                }
                break;

            case 3:
                System.out.println("Your balance is " + balance + ".\n");
                anotherTransaction();
                break;

            case 4:
                System.out.println("Have a nice day. Good Bye!");
                break;

            default:
                System.out.println("Invalid option:\n\n");
                anotherTransaction();
                break;
        }

    }

    private static void anotherTransaction() {
        System.out.println("Do you want another transaction?\n\nPress: \n1. For another transaction\n2. To exit");
        anotherTransaction = in.nextInt();
        if (anotherTransaction == 1) {
            transaction();
        } else if (anotherTransaction == 2) {
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }

    private static void getBalance() {
        int tip1 = 100, tip5 = 100, tip10 = 100, tip50 = 50, tip100 = 50;
        balance = tip1 + tip5 * 5 + tip10 * 10 + tip50 * 50 + tip100 * 100;
    }

    private static void updateBalance(int one, int five, int ten, int fifty, int hundred) {
        int tip1 = 100, tip5 = 100, tip10 = 100, tip50 = 50, tip100 = 50;

        balance = (tip1 - one) + (tip5 - five) * 5 + (tip10 - ten) * 10 + (tip50 - fifty) * 50 + (tip100 - hundred) * 100;

        //System.out.println("New balance: " + balance);
        /*
        System.out.println("Banknotes of 100 left: " + (tip100 - hundred));
        System.out.println("Banknotes of 50: " + (tip50 - fifty));
        System.out.println("Banknotes of 10: " + tip10);
        System.out.println("Banknotes of 5: " + tip5);
        System.out.println("Banknotes of 1: " + tip1);
         */
    }

    private static void numberOfBanknotes(int amount) {

        int one = 0, five = 0, ten = 0, fifty = 0, hundred = 0;

        hundred = amount / 100;
        System.out.println("Banknotes of 100: " + hundred);
        fifty = (amount % 100) / 50;
        System.out.println("Banknotes of 50: " + fifty);
        ten = ((amount % 100) % 50) / 10;
        System.out.println("Banknotes of 10: " + ten);
        five = (((amount % 100) % 50) % 10) / 5;
        System.out.println("Banknotes of 5: " + five);
        one = (((amount % 100) % 50) % 10) % 5;
        System.out.println("Banknotes of 1: " + one);

        //updateBalance(one, five, ten, fifty, hundred);
    }
}
