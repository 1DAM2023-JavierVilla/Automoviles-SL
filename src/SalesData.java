import java.util.ArrayList;

public class SalesData {
    private String salesCode;
    private String salesDate;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private String methodOfPayment;
    private String salePrice;

    public String getSalesCode() {
        return salesCode;
    }

    public void setSalesCode(String salesCode) {
        this.salesCode = salesCode;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public ArrayList<Customer> setCustomers() {
        return this.customers;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public ArrayList<Vehicle> setVehicles() {
        return this.vehicles;
    }

    public String getMethodOfPayment() {
        return methodOfPayment;
    }

    public void setMethodOfPayment(String methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }
}
