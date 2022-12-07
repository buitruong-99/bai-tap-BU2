package bai1;

import java.text.NumberFormat;
import java.util.Scanner;

public class Account {
    private long numberAccount;
    private String nameAccount;
    private double balance;

    private final double RATE = 0.035;

    public Account() {
    }

    public Account(long numberAccount, String nameAccount, double balance) {
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.balance = balance;
    }

    public Account(long numberAccount, String nameAccount) {
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.balance = 50;
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

    public double getRATE() {
        return RATE;
    }

    static Scanner scanner = new Scanner(System.in);

    //Nạp tiền
    public double napTien() {
        double soTienNap;
        System.out.print("Nhập số tiền bạn cần nạp: ");
        soTienNap = scanner.nextDouble();
        if (soTienNap >= 0) {
            balance = soTienNap + balance;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String formatBalance = currencyEN.format(soTienNap);
            System.out.println("bạn vừa nạp " + formatBalance + " vào tài khoản.");
        } else {
            System.out.println("Số tiền nạp vào không hợp lệ!");
        }
        return soTienNap;
    }

    //Rut tien
    public double rutTien() {
        double phiRut = 5;
        double rutTien;
        System.out.print("Nhập số tiền cần rút: ");
        rutTien = scanner.nextDouble();
        if (rutTien <= (balance - phiRut)) {
            balance = balance - (rutTien + phiRut);
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
            String balanceFormat = currencyInstance.format(rutTien);
            System.out.println("Thuc hien rut " + balanceFormat + "VND thanh cong. Phi rut tien " + phiRut);
        } else System.out.println("Số dư không đủ rút.");
        return rutTien;
    }
     // đáo hạn
     public double daoHan() {
         balance = balance + (balance * RATE);
         NumberFormat instance = NumberFormat.getCurrencyInstance();
         String balanceFormat = instance.format(balance);
         System.out.println("Nhận số tiền: " + balanceFormat + " từ đáo hạn.");
         return balance;
     }


    //Danh sách tài khoản
    public void displayAccount() {
        NumberFormat instance = NumberFormat.getCurrencyInstance();
        String balnaceFormat = instance.format(balance);
        System.out.printf("%-10d %-20s %-20s\n", numberAccount, nameAccount, balnaceFormat);
    }
}
