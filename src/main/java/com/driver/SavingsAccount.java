package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super("saving",balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        else if(this.getBalance()-amount<this.getMinBalance()){
            throw new Exception("Insufficient Balance");
        }
        else{
            double temp=this.getBalance()-amount;
            this.setBalance(temp);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
         double t=years;
         double simpleInt=this.getBalance()*this.rate* (t/100);
         return simpleInt;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        this.rate=this.rate/100.00;
        double y=years;
        double t=times;
        double c=this.getBalance();
       double A=(1+(rate/t));
       double B=t*y;
       double CI=c* Math.pow(A,B);
       return CI-c;
    }

}
