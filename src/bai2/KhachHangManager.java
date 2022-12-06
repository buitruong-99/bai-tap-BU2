package bai2;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class KhachHangManager {
    static Scanner scanner = new Scanner(System.in);
    private KhachHangDAO khachHangDAO;
    private List<KhachHang> khachHangList;

    public KhachHangManager() {
        khachHangDAO = new KhachHangDAO();
        khachHangList = khachHangDAO.read();
    }

    public void add() {
        String soCmnd;
        String tenKh;
        String gaDen;
        double giaTien;
        System.out.print("Nhập số CMND: ");
        soCmnd = scanner.nextLine();
        System.out.print("Nhập tên KS: ");
        tenKh = scanner.nextLine();
        System.out.print("Nhập ga đến: ");
        gaDen = scanner.nextLine();
        System.out.print("Nhập giá tiền: ");
        giaTien = scanner.nextDouble();
        KhachHang khachHang = new KhachHang(soCmnd, tenKh, gaDen, giaTien);
        khachHangList.add(khachHang);
        khachHangDAO.saveKh(khachHangList);
    }

    public void dsKhachHang() {
        for (KhachHang khachHang : khachHangList) {
            System.out.printf("%-20s %-20s %-20s %,.2f\n", khachHang.getSoCmnd(),
                    khachHang.getTenKh(), khachHang.getGaDen(), khachHang.getGiaTien());
        }
    }

    public void banve(){
        KhachHang khachHang = null;
        System.out.println("Nhập số CMND mua vé đã đăng ký trước");
        String soCmndMuaVe = scanner.nextLine();
        int size = khachHangList.size();
        for (int i = 0; i < size; i++) {
            if (khachHangList.get(i).getSoCmnd() == soCmndMuaVe) {
                khachHang = khachHangList.get(i);
                System.out.println("Bán vé cho khách hàng có số CMND "+soCmndMuaVe +" thành công");
                break;
            }
        }
        if (khachHang != null){
            khachHangList.remove(khachHang);
            khachHangDAO.saveKh(khachHangList);
        }
        else {
            System.out.printf("Không tìm thấy số CMND ", soCmndMuaVe);
        }
    }
    public void deleteKH(){
        KhachHang khachHang = null;
        System.out.print("Nhập số CMND KH cần xóa ");
        String soCMNDXoa = scanner.nextLine();
        int size = khachHangList.size();
        for (int i = 0; i < size; i++) {
            if (khachHangList.get(i).getSoCmnd() == soCMNDXoa) {
                khachHang = khachHangList.get(i);
                System.out.println("Bán vé cho khách hàng có số CMND "+soCMNDXoa +" thành công");
                break;
            }
        }
        if (khachHang != null){
            khachHangList.remove(khachHang);
            khachHangDAO.saveKh(khachHangList);
        }
        else {
            System.out.printf("Không tìm thấy số CMND ", soCMNDXoa);
        }
    }

}
