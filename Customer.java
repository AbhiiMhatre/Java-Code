package mycode;

import java.util.Scanner;
class Bank
{
    private double bal=10000;
    private int pwd;

    public void Deposit(double money) {
        System.out.print("Enter Password: ");
        Scanner s=new Scanner(System.in);
        pwd=s.nextInt();
    
        if(pwd == 0007) {
            bal=bal+money;
            System.out.println("Deposited Money: "+money);
            System.out.println("Total Balance: "+bal);
        }else {
            System.out.println("Incorrect Password: ");
        }
    
    }
    public void Withdraw(double money){
        System.out.print("Enter Password: ");
        Scanner s=new Scanner(System.in);
        pwd=s.nextInt();
    
        if(pwd==0007) {
            bal=bal-money;
            System.out.println("Withdraw Money: "+money);
            System.out.println("Total Balance: "+bal);
        } else {
            System.out.println("Incorrect Password: ");
        }
    
    }
    public void checkBal() {
        System.out.print("Enter Password: ");
        Scanner s=new Scanner(System.in);
        pwd=s.nextInt();
    
        if(pwd==0007) {
            System.out.println("Total Balance: "+bal);
        }
    
    }


}
class Customer{
    public static void main(String[] args) {
        Bank b=new Bank();

        int ch;

        System.out.println("1. Deposit: ");
        System.out.println("2. Withdraw: ");
        System.out.println("3. Checkbal: ");

        System.out.println("\nEnter your Choice: ");
        Scanner s2=new Scanner(System.in);
        ch=s2.nextInt();

        switch (ch){
            case 1:
            b.Deposit(1000);
            break;
            case 2:
            b.Withdraw(2000);
            break;
            case 3:
            b.checkBal();
            break;
            default:
            System.out.println("Invalid Choice");
        }
    }
}
