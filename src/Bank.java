import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;
    public Bank() {
        this.customers = new ArrayList<>();
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    public Customer getCustomerByPin(int pin) {
        for (Customer customer : customers) {
            if (customer.getPin() == pin) {
                return customer;
            }
        }
        return null;
    }
    public String getAllCustomersInfo() {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : customers) {
            sb.append(customer.toString()).append("\n");
        }
        return sb.toString();
    }
}
