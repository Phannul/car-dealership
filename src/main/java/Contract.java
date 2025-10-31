public abstract class Contract {
    protected String date;
    protected String customerName;
    protected String getCustomerEmail;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String date, String customerName, String getCustomerEmail, Vehicle vehicleSold,double totalPrice, double monthlyPayment){
        this.date = date;
        this.customerName = customerName;
        this.getCustomerEmail = getCustomerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }
    //getters
    public String getDate(){
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getGetCustomerEmail() {
        return getCustomerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }
    //setters

    public void setDate(String date) {
        this.date = date;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setGetCustomerEmail(String getCustomerEmail) {
        this.getCustomerEmail = getCustomerEmail;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
