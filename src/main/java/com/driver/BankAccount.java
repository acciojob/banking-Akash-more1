package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
         this.name=name;
         this.balance=balance;
         this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        StringBuilder ano=new StringBuilder();
        while(digits>0){
            ano.append('0');
            digits--;
        }
        int i=0;
        while(sum>0 && i<ano.length()){
            if(sum>=9 && i<ano.length()){
                sum-=9;
                ano.setCharAt(i,'9');
                i++;
            }
           else if(sum>=8 && i<ano.length()){
                sum-=8;
                ano.setCharAt(i,'8');
                i++;
            }
            else if(sum>=7 && i<ano.length()){
                sum-=7;
                ano.setCharAt(i,'7');
                i++;
            }
            else if(sum>=6 && i<ano.length()){
                sum-=6;
                ano.setCharAt(i,'6');
                i++;
            }
            else if(sum>=5 && i<ano.length()){
                sum-=5;
                ano.setCharAt(i,'5');
                i++;
            }
            else if(sum>=4 && i<ano.length()){
                sum-=4;
                ano.setCharAt(i,'4');
                i++;
            }
            else if(sum>=3 && i<ano.length()){
                sum-=3;
                ano.setCharAt(i,'3');
                i++;
            }
            else if(sum>=2 && i<ano.length()){
                sum-=2;
                ano.setCharAt(i,'2');
                i++;
            }
            else if(sum>=1 && i<ano.length()){
                sum-=1;
                ano.setCharAt(i,'1');
                i++;
            }
        }
         if(sum>0){
             throw new Exception("Account Number can not be generated");
         }
         else{
             return ano.toString();
         }

    }

    public void deposit(double amount) {
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
         if(this.balance-amount<this.minBalance){
             throw new Exception("Insufficient Balance");
         }
         else{
             this.balance-=amount;
         }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}