package bai1;

import java.text.NumberFormat;
import java.util.Scanner;

public class Account {
    private long numberAccount;
    private String nameAccount;
    private double balance;
    Scanner scanner = new Scanner(System.in);

    public Account() {
    }

    public Account(long numberAccount, String nameAccount, double balance) {
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.balance = balance;
    }

    public long getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(long numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        String balanceFormat = currencyInstance.format(balance);
        return "Account{" +
                "numberAccount=" + numberAccount +
                ", nameAccount='" + nameAccount + '\'' +
                ", balance=" + balanceFormat +
                '}';
    }
    public double napTien(){
        double naptien;
        System.out.print("Nhập số tiền cần nạp: ");
        naptien = scanner.nextDouble();
        if (naptien > 0){
            balance = balance + naptien;
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            String balanceFormat = currencyInstance.format(naptien);
            System.out.println("Nap " +balanceFormat +"VND thành công");
        }
        else System.out.println("Số tiền không hợp lệ, nhập lại.");

        return naptien;
    }
    public double rutTien(){
        double phiRut = 5;
        double rutTien;
        System.out.print("Nhập số tiền cần rút: ");
        rutTien = scanner.nextDouble();
        if (rutTien <= (balance-phiRut)){
            balance = balance - (rutTien+phiRut);
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            String balanceFormat = currencyInstance.format(rutTien);
            System.out.println("Thuc hien rut "+balanceFormat +"VND thanh cong. Phi rut tien "+phiRut);
        }
        else System.out.println("Số dư không đủ rút.");
        return rutTien;
    }
    public double daoHan(){
        double laiSuat = 0.035;
        balance = balance + (balance * laiSuat);
        NumberFormat instance = NumberFormat.getCurrencyInstance();
        String balanceFormat = instance.format(balance);
        System.out.println("Nhận số tiền: "+balanceFormat +" từ đáo hạn.");
        return balance;
    }
    public void displayAccount(){
        NumberFormat instance = NumberFormat.getCurrencyInstance();
        String balnaceFormat = instance.format(balance);
        System.out.printf("%-10d %-20s %-20s\n", numberAccount ,nameAccount ,balnaceFormat);
    }

}
