package com.driver;

import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        String s=this.tradeLicenseId;
        int n=s.length();
        int [] arr=new int [26];

        boolean flag=false;
        for(int i=0; i<s.length()-1; i++){
            char a=s.charAt(i);
            char b=s.charAt(i+1);

            if(a==b){
                flag=true;
            }
        }

        if(flag){
            rearrange();
        }




    }

    public void rearrange() throws Exception{
        String s=this.tradeLicenseId;
        int n=s.length();
        int [] arr=new int [26];


        for(char ele: s.toCharArray()){
            arr[ele-'A']++;
            if(arr[ele-'A']>(n+1)/2){
                throw new Exception("Valid License can not be generated");
            }
        }

        PriorityQueue<pairs> pq=new PriorityQueue<>((a, b)->{
            return  b.freq-a.freq;
        });

        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                pq.add(new pairs(arr[i], (char)(i+'A')));
            }
        }

        StringBuilder ans=new StringBuilder();

        while(pq.size()>1){
            pairs j=pq.remove();
            pairs k=pq.remove();
            ans.append(j.ch);
            ans.append(k.ch);
            if(j.freq>1){
                pq.add(new pairs(j.freq-1, j.ch));
            }

            if(k.freq>1){
                pq.add(new pairs(k.freq-1, k.ch));
            }
        }
        if(pq.size()>0){
            ans.append(pq.remove().ch);
        }

        this.tradeLicenseId= ans.toString();
    }


    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    class pairs{
        int freq;
        char ch;

        pairs(int a,char b){
            this.freq=a;
            this.ch=b;
        }
    }
}
