import java.util.InputMismatchException;
import java.util.Scanner;

public class BankerRun {

    public static void main(String[] args){

        Banker bank = new Banker();
        bank.setAccountName("Alex");
        bank.setFunds(500.00);

        boolean flag = true;

        System.out.println("Welcome " + bank.getAccountName());

        do{
            System.out.println("Type V to view your funds. Type W to withdraw. Type D to deposit. Type E to exit");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next().toLowerCase();

            switch(input){
                case "v":
                    //Viewing funds
                    String str = String.format("%.2f", bank.getFunds());
                    System.out.println(bank.getAccountName() + " has " + str + " in their account.");
                    break;

                case "w":
                    //Withdraw transaction
                    try {
                        System.out.println("How much do you want to withdraw?");
                        double cashWithdraw = scanner.nextDouble();

                        if(cashWithdraw <= bank.getFunds() && cashWithdraw > 0){
                            bank.setFunds(bank.withdraw(cashWithdraw));
                            str = String.format("%.2f", bank.getFunds());
                            System.out.println(bank.getAccountName() + " has " + str + " in their account.");
                        } else if(cashWithdraw < 0) {
                            System.out.println("Cannot withdraw a negative number.");
                        } else {
                            System.out.println("Not enough funds to withdraw.");
                        }

                    } catch(InputMismatchException e) {
                        System.out.println("Invalid input. " + e);
                    }
                    break;

                case "d":
                    //Deposit transaction
                    try {
                        System.out.println("How much do you want to deposit?");
                        double cashDeposit = scanner.nextDouble();

                        if(cashDeposit > 0) {
                            bank.setFunds(bank.deposit(cashDeposit));
                            str = String.format("%.2f", bank.getFunds());
                            System.out.println(bank.getAccountName() + " has " + str + " in their account.");
                        } else {
                            System.out.println("Cannot deposit a negative number.");
                        }

                    }catch(InputMismatchException e){
                        System.out.println("Invalid input");
                    }
                    break;

                case "e":
                    System.out.println("Goodbye");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid input.");
            }

        }while(flag);

    }

}
