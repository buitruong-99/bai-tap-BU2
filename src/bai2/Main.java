package bai2;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        boolean exit = true;
        String soCMNDMuaVe;
        KhachHangManager manager = new KhachHangManager();
        System.out.println("Chọn chức năng");
        System.out.println("1. Thêm một khách hàng mới vào hàng đợi mua vé\n" +
                "2. Bán 1 vé cho khách hàng. Chỉ bán cho người đăng ký trước\n" +
                "3. Hiển thị danh sách khách hàng\n" +
                "4. Hủy 1 khách hàng ra khỏi danh sách\n" +
                "5. Thống kê tình hình bán vé\n" +
                "6. Lưu danh sách vào file\n" +
                "7. Hiển thị danh sách các ga đang chờ mua vé\n" +
                "8. Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga\n" +
                "Số bất kỳ để thoát.\n");
        do {
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    manager.add();
                    break;
                case 2:
                    manager.banve();
                    break;
                case 3:
                    System.out.printf("%-20s %-20s %-20s %20s\n", "Số CMND", "Tên KH", "Ga đến", "Giá tiền");
                    manager.dsKhachHang();
                    break;
                case 4:
                    manager.deleteKH();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Kết thúc");
                    exit = false;
                    break;
            }
        }while (exit);
    }
}
