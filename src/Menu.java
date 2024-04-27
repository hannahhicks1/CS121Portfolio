import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Bank bank;
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.bank = new Bank();
    }
    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    openNewAccount();
                    break;
                case 2:
                    accessAccount();
                    break;
                case 3:
                    closeAllAccounts();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the BSU Banking App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid entry. Try again.");
                    break;
            }
        }
        scanner.close();
    }
    private void displayMainMenu() {
        System.out.println("Main Menu: ");
        System.out.println("1. Open a new account");
        System.out.println("2. Access an existing account");
        System.out.println("3. Close all accounts");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    private void accessAccount() {
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        Customer customer = bank.getCustomerByPin(pin);
        if (customer == null) {
            System.out.println("PIN not valid.");
            return;
        }
        System.out.println("Accounts Active:\n " + customer);
        System.out.println(customer.getAllAccountsInfo());
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        Account account = customer.getAccountByNumber(accountNumber);
        if (account == null) {
            System.out.println("Account number invalid.");
            return;
        }
    }
    private void openNewAccount() {
        System.out.print("Are you a new customer? (yes/no): ");
        String isNewCustomer = scanner.nextLine();
        Customer customer;
        if (isNewCustomer.equalsIgnoreCase("yes")) {
            customer = createNewCustomer();
            if (customer == null) {
                System.out.println("Failed to create a new customer.");
                return;
            }
        } else if (isNewCustomer.equalsIgnoreCase("no")) {
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            scanner.nextLine();
            customer = bank.getCustomerByPin(pin);
            if (customer == null) {
                System.out.println("PIN not valid.");
                return;
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }
        System.out.print("Enter deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();
        Account account = new Account(initialDeposit);
        customer.addAccount(account);
        System.out.println("New Account Opened: " + account);
    }
    private Customer createNewCustomer() {
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your 4-digit PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        Customer customer = new Customer(firstName, lastName, pin);
        bank.addCustomer(customer);
        System.out.println("New customer created: " + customer);
        return customer;
    }
    private void closeAllAccounts() {
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        Customer customer = bank.getCustomerByPin(pin);
        if (customer == null) {
            System.out.println("PIN not valid.");
            return;
        }
        bank.removeCustomer(customer);
        System.out.println("Customer removed.");
    }
}