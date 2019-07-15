public class Banker {

    private String accountName;
    private double funds;

    public String getAccountName(){
        return accountName;
    }

    public double getFunds(){
        return funds;
    }

    public void setAccountName(String newAccountName){
        accountName = newAccountName;
    }

    public void setFunds(double newFunds){
        funds = newFunds;
    }

    public double withdraw(double subtract){
        double total = this.funds - subtract;
        String str = String.format("%.2f", subtract);
        System.out.println(str + " has been withdrawn.");
        return total;
    }

    public double deposit(double add){
        double total = this.funds + add;
        String str = String.format("%.2f", add);
        System.out.println(str + " has been deposited");
        return total;
    }
}
