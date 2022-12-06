package bai1;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void nhapTaikhoan(Account account) {
        System.out.print("Nhập số tài khoản: ");
        account.setNumberAccount(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Nhập tên tài khỏan: ");
        account.setNameAccount(scanner.nextLine());
        account.setBalance(50);
    }

    public static void main(String[] args) {
        Account[] account = null;
        int menu, nhap = 0;
        long stkNap, stkRut,stk, stkSc, stkC, stkN;
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng");
            System.out.println("1. Nhập thông tin tài khoản\n" +
                    "2. Nạp tiền\n" +
                    "3. Rút tiền\n" +
                    "4. Chuyển tiền\n" +
                    "5. Đáo hạn\n" +
                    "6. Thông tin tài khoản\n" +
                    "Phím bất kỳ để thoát");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Số lượng account cần nhập: ");
                    nhap = scanner.nextInt();
                    account = new Account[nhap];
                    for (int i = 0; i < nhap; i++) {
                        System.out.println("Account số " + (i + 1));
                        account[i] = new Account();
                        nhapTaikhoan(account[i]);
                    }
                    break;
                case 2:
                    System.out.print("Số tài khoản nạp tiền: ");
                    stkNap = scanner.nextLong();
                    for (int i = 0; i < nhap; i++) {
                        stk = account[i].getNumberAccount();
                        if (stkNap == stk) {
                            account[i].napTien();
                            System.out.println("Thực hiện nạp tiền vào số tài khoản " + stkNap);
                        } else System.out.println("Số tài khoản không tồn tại.");
                    }
                    break;
                case 3:
                    System.out.print("Số tài khoản rút tiền ");
                    stkRut = scanner.nextLong();
                    for (int i = 0; i < nhap; i++) {
                        stk = account[i].getNumberAccount();
                        if (stkRut == stk) {
                            account[i].rutTien();
                            System.out.println("Thực hiện rút tiền từ số tài khoản " + stkRut);
                        } else System.out.println("Số tài khoản không tồn tại.");
                    }
                    break;
                case 4:
                    double chuyen, nhan, soTienChuyen;
                    long stkChuyen;
                    System.out.print("Nhập số tài khoản chuyển: ");
                    stkC = scanner.nextLong();
                    System.out.print("Nhập số tài khoản nhận: ");
                    stkN = scanner.nextLong();
                    for (int i =0; i <nhap; i++){
                        stkChuyen = account[i].getNumberAccount();
                        if (stkChuyen == stkC){
                            chuyen = account[i].getBalance();
                            for (int j = 0; j < nhap; j ++){
                                nhan = account[j].getBalance();
                                System.out.print("Nhập số tiền cần chuyển: ");
                                soTienChuyen = scanner.nextDouble();
                                if(soTienChuyen <= chuyen){
                                    chuyen = chuyen - soTienChuyen;
                                    nhan = nhan + soTienChuyen;
                                    account[i].setBalance(chuyen);
                                    account[j].setBalance(nhan);
                                    System.out.println("STK "+stkC +" chuyển tiền thành công tới "+stkN +" số tiền"+soTienChuyen);
                                    System.out.println("STK "+stkN +" nhận tiền từ "+stkC +" số tiền"+nhan);
                                }
                                else System.out.println("Số dư không đủ");
                            }
                        } else System.out.println("Sai số tài khoản");
                    }
                    break;

                case 5:
                    System.out.print("Nhập số tài khoản cần đáo hạn: ");
                    stkSc = scanner.nextLong();
                    for (int i =0; i < nhap; i++){
                        stk = account[i].getNumberAccount();
                        if (stkSc == stk){
                            account[i].daoHan();
                        }
                    }
                    break;

                case 6:
                    System.out.printf("%-10s %-20s %-20s\n", "Số TK", "Tên TK", "Số tiền trong TK");
                    for (int i = 0; i < nhap; i++) {
                        account[i].displayAccount();
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