import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;
    private int pin;
    private List<Account> accounts;
    public Customer(String firstName, String lastName, int pin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public int getPin() {
        return pin;
    }
    public void removeAccount(Account account) {
        accounts.remove(account);
    }
    public Account getAccountByNumber(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    public String getAllAccountsInfo() {
        StringBuilder sb = new StringBuilder();
        for (Account account : accounts) {
            sb.append(account.toString()).append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString() {
        return "Customer: " + firstName + " " + lastName + ", PIN: " + pin;
    }

}
