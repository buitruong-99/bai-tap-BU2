package bai2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KhachHangManager dsHangDoi = new KhachHangManager();
        int choose;
        boolean exit = true;
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
                    dsHangDoi.themKhachHang();
                    break;
                case 2:
                    dsHangDoi.banVe();
                    break;
                case 3:
                    System.out.println("DANH SÁCH KHÁCH HÀNG CHỜ");
                    System.out.printf("%-20s %-20s %-20s %5s\n", "Số CMND", "Tên KH", "Ga đến", "Giá tiền");
                    dsHangDoi.hienThiDSKhachHang();
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("DANH SÁCH KHÁCH HÀNG ĐÃ MUA VÉ");
                    System.out.printf("%-20s %-20s %-20s %5s\n", "Số CMND", "Tên KH", "Ga đến", "Giá tiền");
                    dsHangDoi.dsKhachHangDaMuaVe();
                    System.out.println("---------------------------------------------------------------");
                    break;
                case 4:
                    dsHangDoi.xoaKhachHangDSCho();
                    break;
                case 5:
                    dsHangDoi.thongKe();
                    break;
                case 6:
                    dsHangDoi.saveKhachHang();
                    break;
                case 7:
                    System.out.printf("%3s %20s\n", "Số STT", "Ga đến");
                    dsHangDoi.dsGaChoMuaVe();
                    break;
                case 8:
                    System.out.printf("%3s %20s\n", "Số vé", "Ga đến");
                    dsHangDoi.dsGaChoVaSoVe();
                default:
                    System.out.println("kết thúc");
                    exit = false;
                    break;
            }
        } while (exit);
    }
}
