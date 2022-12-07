package bai2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DanhSachHangDoi {
    private ArrayList<KhachHang> danhSach;
    private ArrayList<KhachHang> danhsachMuave;
    private FileDanhSachKH fileDanhSachKH;
    static Scanner scanner = new Scanner(System.in);

    public DanhSachHangDoi() {
        this.danhSach = new ArrayList<>();
        this.danhsachMuave = new ArrayList<>();
        fileDanhSachKH = new FileDanhSachKH();
        danhSach = (ArrayList<KhachHang>) fileDanhSachKH.read();

    }



    public DanhSachHangDoi(ArrayList<KhachHang> danhSach) {
        this.danhSach = danhSach;
    }

    //Thêm 1 khách hàng vào hàng đợi mua vé
    public void themKhachHang(KhachHang khachHang) {
        this.danhSach.add(khachHang);
    }

    //Hiển thị danh sách khách hàng
    public void hienThiDSKhachHang() {
        for (KhachHang khachHang : danhSach) {
            System.out.printf("%-20s %-20s %-20s %,.2f\n", khachHang.getSoCmnd(),
                    khachHang.getTenKh(), khachHang.getGaDen(), khachHang.getGiaTien());
        }
    }

    //Bán vé cho KH ở trong hàng đợi bằng số CMND khách hàng
    public void banVe() {
        KhachHang khachHang = null;
        System.out.println("Nhập số CMND khách hàng mua vé đã đăng ký trước: ");
        String soCMNDMuave = scanner.nextLine();
        int size = danhSach.size();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(danhSach.get(i).getSoCmnd(), soCMNDMuave)) {
                khachHang = danhSach.get(i);
            }
        }
        if (khachHang != null) {
            danhsachMuave.add(khachHang);
            danhSach.remove(khachHang);
            System.out.println("Khách hàng số CMND " + soCMNDMuave + " mua vé thành công.");
        } else System.out.println("Số CMND khách hàng không tồn tại.");
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
        System.out.println("Tổng số tiền bán vé đã thu về là: "+TongSoTienBanVe);
    }


    public void saveDs(){
        fileDanhSachKH.writeFile(danhSach);
    }

    //Danh sách các gaddangg chờ mua vé
    public void dsGaChoMuaVe(){
        int i=0;
        for (KhachHang khachHang : danhSach) {
            i++;
            System.out.printf("%3d %-20s\n",i, khachHang.getGaDen());
        }
    }

    //Danh sách ga chờ và số vé tương ứng
    public void dsGaChoVaSoVe(){
       int size = danhSach.size();
       int i;
       for (i=0; i<size; i++){
           String geden = danhSach.get(i).getGaDen();
           long countDS = danhSach.stream().filter(x -> x.getGaDen().equals(geden)).count();
           System.out.printf("%3d %-20s\n",countDS, geden );
       }


    }



}
