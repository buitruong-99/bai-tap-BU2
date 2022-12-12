package bai2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class KhachHangManager {
    private final ArrayList<KhachHang> danhSach;
    private ArrayList<KhachHang> danhsachMuave;
    Scanner scanner = new Scanner(System.in);

    private KhachHangDAO khachHangDAO;

    public KhachHangManager() {
        this.danhSach = new ArrayList<>();
        this.danhsachMuave = new ArrayList<>();
    }
//    public KhachHangManager(){
//        khachHangDAO = new KhachHangDAO();
//        danhSach = khachHangDAO.read();
//    }


    public KhachHangManager(ArrayList<KhachHang> danhSach) {
        this.danhSach = danhSach;
    }

    //Thêm 1 khách hàng vào hàng đợi mua vé
    public void themKhachHang() {
        Scanner scanner = new Scanner(System.in);
        KhachHang khachHang = new KhachHang();
        System.out.print("Nhập số CMND: ");
        khachHang.setSoCmnd(scanner.nextLine());

        System.out.print("Nhập tên khách hàng: ");
        khachHang.setTenKh(scanner.nextLine());
        System.out.print("Nhập ga đến: ");
        khachHang.setGaDen(scanner.nextLine());
        System.out.print("Nhập giá vé: ");
        khachHang.setGiaTien(scanner.nextDouble());
        danhSach.add(khachHang);

    }

    //Hiển thị danh sách khách hàng
    public void hienThiDSKhachHang() {
        for (KhachHang khachHang : danhSach) {
            System.out.printf("%-20s %-20s %-20s %,.2f\n", khachHang.getSoCmnd(),
                    khachHang.getTenKh(), khachHang.getGaDen(), khachHang.getGiaTien());
        }
    }

    public void dsKhachHangDaMuaVe() {
        for (KhachHang khachHang : danhsachMuave) {
            System.out.printf("%-20s %-20s %-20s %,.2f\n", khachHang.getSoCmnd(),
                    khachHang.getTenKh(), khachHang.getGaDen(), khachHang.getGiaTien());
        }
    }

    //Bán vé cho 1 KH đặt vé trước trong danh sách hàng chờ
    public void banVe() {
        if (danhSach.size() > 0) {
            KhachHang nguoiMuaVe = danhSach.get(0);
            danhsachMuave.add(danhSach.get(0));
            danhSach.remove(danhSach.get(0));
            System.out.println("Khách hàng số CMND " + nguoiMuaVe.getSoCmnd() + " mua vé thành công.");
        } else {
            System.out.println("Danh sách chờ mua vé trống.");
        }

    }

    //Xóa 1 khách hàng ra khỏi hàng chờ bằng số CMND khách hàng
    public void xoaKhachHangDSCho() {
        KhachHang khachHang = null;
        System.out.print("Nhập số CMND KH cần xóa ");
        String soCMNDXoa = scanner.nextLine();
        int size = danhSach.size();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(danhSach.get(i).getSoCmnd(), soCMNDXoa)) {
                khachHang = danhSach.get(i);
                System.out.println("Xóa khách hàng có số CMND " + soCMNDXoa);
                break;
            }
        }
        if (khachHang != null) {
            danhSach.remove(khachHang);
        } else {
            System.out.printf("Không tìm thấy số CMND ", soCMNDXoa);
        }
    }

    //Thông kê bao nhiêu khách hàng chờ, đã nhận và tổng số tiền đã thu về
    public void thongKe() {
        System.out.println("Số khách hàng đang chờ mua vé: " + danhSach.size() + " khách hàng.");
        System.out.println("Số khách hàng đã mua vé: " + danhsachMuave.size() + " khách hàng.");
        double TongSoTienBanVe = 0;
        double soTienMotVe;
        int size = danhsachMuave.size();
        for (int i = 0; i < size; i++) {
            soTienMotVe = danhsachMuave.get(i).getGiaTien();
            TongSoTienBanVe += soTienMotVe;
        }
        System.out.println("Tổng số tiền bán vé đã thu về là: " + TongSoTienBanVe);
    }

    // Lưu danh sách vào file
    public void saveKhachHang() {
        KhachHangManager khachHangManager = new KhachHangManager();
        KhachHang khachHang = new KhachHang();
        khachHang.setSoCmnd("123");
        khachHang.setTenKh("Truong");
        khachHang.setGaDen("Ha Noi");
        khachHang.setGiaTien(123.5);
        khachHangManager.serializeKhachHang(khachHang);
    }

    public void serializeKhachHang(KhachHang khachHang) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\BnK\\Desktop\\bai-tap-BU2\\dskh.bin");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(khachHang);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Danh sách các gaddangg chờ mua vé
    public void dsGaChoMuaVe() {
        int i = 0;
        for (KhachHang khachHang : danhSach) {
            i++;
            System.out.printf("%3d %20s\n", i, khachHang.getGaDen());
        }
    }

    //Danh sách ga chờ và số vé tương ứng
    public void dsGaChoVaSoVe() {
        int size = danhSach.size();
        int i;
        long countDS;
        for (i = 0; i < size; i++) {
            String gaden = danhSach.get(i).getGaDen();
            countDS = danhSach.stream().filter(x -> x.getGaDen().equals(gaden)).count();
            countDS++;
            System.out.printf("%3d %20s\n", countDS, gaden);
        }

    }


}
