package bai1;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void nhapTaikhoan(Account account) {
        System.out.print("Nhập số tài khoản: ");
        account.setNumberAccount(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Nhập tên tài khỏan: ");
        account.setNameAccount(scanner.nextLine());
    }

    public static void main(String[] args) {
        int choose;
        int k, b, n = 0;
        long stk, numberAccountCheck;
        boolean flag = true;
        Account[] account = null;
        ArrayList<Account> list = new ArrayList<>();
        do {
            System.out.println("Chọn chức năng");
            System.out.println("1. Nhập thông tin tài khoản\n" +
                    "2. Nạp tiền\n" +
                    "3. Rút tiền\n" +
                    "4. Chuyển tiền\n" +
                    "5. Đáo hạn\n" +
                    "6. Thông tin tài khoản\n" +
                    "Phím bất kỳ để thoát");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    String nameAccount = "";
                    long numberAccount = 0;
                    System.out.print("Số lượng account cần nhập: ");
                    n = scanner.nextInt();
                    account = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Account " + (i + 1));
                        account[i] = new Account(numberAccount, nameAccount);
                        nhapTaikhoan(account[i]);
                        list.add(account[i]);
                    }
                    break;
                case 2:
                    System.out.println("Nhập số tài khoản khách hàng cần nạp tiền: ");
                    stk = scanner.nextLong();
                    for (int i = 0; i < list.size(); i++) {
                        numberAccountCheck = list.get(i).getNumberAccount();
                        System.out.println();
                        if (stk == numberAccountCheck) {
                            System.out.println("Bạn chọn tài khoản: " + numberAccountCheck);
                            list.get(i).napTien();
                        }
                    }
                    break;
                case 3:
                    System.out.print("Số tài khoản rút tiền ");
                    stk = scanner.nextLong();
                    for (int i = 0; i < list.size(); i++) {
                        numberAccountCheck = list.get(i).getNumberAccount();
                        if (stk == numberAccountCheck) {
                            list.get(i).rutTien();
                            System.out.println("Thực hiện rút tiền từ số tài khoản " + stk);
                        }
                    }
                    break;
                case 4:
                    long stkC, stkN;
                    double chuyen, nhan, soTienChuyen;
                    long stkChuyen, stkNhan;
                    System.out.print("Nhập số tài khoản chuyển: ");
                    stkC = scanner.nextLong();
                    System.out.print("Nhập số tài khoản nhận: ");
                    stkN = scanner.nextLong();
                    int a = list.size();
                    for (int i = 0; i < a; i++) {
                        stkChuyen = list.get(i).getNumberAccount();
                        if (stkChuyen == stkC) {
                            chuyen = list.get(i).getBalance();
                            for (int j = 0; j < a; j++) {
                                stkNhan = list.get(j).getNumberAccount();
                                if (stkN == stkNhan) {
                                    nhan = list.get(j).getBalance();
                                    System.out.print("Nhập số tiền cần chuyển: ");
                                    soTienChuyen = scanner.nextDouble();
                                    if (soTienChuyen <= chuyen) {
                                        chuyen = chuyen - soTienChuyen;
                                        nhan = nhan + soTienChuyen;
                                        list.get(i).setBalance(chuyen);
                                        list.get(j).setBalance(nhan);
                                        System.out.println("STK " + stkC + " chuyển tiền thành công tới " + stkN + " số tiền $" + soTienChuyen);
                                        System.out.println("STK " + stkN + " nhận tiền từ " + stkC + " số tiền $" + soTienChuyen);
                                        break;
                                    } else System.out.println("Số dư không đủ");
                                }
                            }
                            break;
                        }else System.out.println("Sai số tài khoản");
                    }
                    break;
                case 5:
                    System.out.print("Nhập số tài khoản cần đáo hạn: ");
                    long stkDaoHan = scanner.nextLong();
                    for (int i = 0; i < list.size(); i++) {
                        stk = list.get(i).getNumberAccount();
                        if (stkDaoHan == stk) {
                            list.get(i).daoHan();
                        }
                    }
                    break;
                case 6:
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).displayAccount();
                    }
                    break;

                default:
                    System.out.println("Kết thúc");
                    flag = false;
                    break;
            }

        } while (flag);

    }

}