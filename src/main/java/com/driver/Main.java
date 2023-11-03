package com.driver;

public class Main {
    public static void main(String[] args) {
//        SavingsAccount Akash=new SavingsAccount("saving",10000.00,2000.00,5.00);
//        try {
//            String str=Akash.generateAccountNumber(2,30);
//            System.out.println(str);
//        } catch (Exception e) {
//            System.out.println(e);
//            //throw new RuntimeException(e);
//        }
//        System.out.println("got it");
//       double si= Akash.getSimpleInterest(1);
//        System.out.println(si);
//        double ci= Akash.getCompoundInterest(4,1);
//        System.out.println(ci);
//        try {
//            CurrentAccount Akash=new CurrentAccount("current", 6000,"RRRRH");
//            Akash.validateLicenseId();
//            System.out.print(Akash.getTradeLicenseId());
//        } catch (Exception e) {
//            System.out.print("can not crreat");
//
//            throw new RuntimeException(e);
//        }

        StudentAccount Akash=new StudentAccount("Akash",100,"gavali satara");
        String str=Akash.getInstitutionName();
        try {
            String ssr= Akash.generateAccountNumber(10,99);
            System.out.println(ssr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.print(str);
    }
}