package bai3;

public class HangSanXuat {
    private String tenHangSanXuat, tenQuocGia;
    
    public HangSanXuat(String tenHang, String tenQuocGia){
        this.tenHangSanXuat = tenHang;
        this.tenQuocGia = tenQuocGia;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(String tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }

    public void setTenQuocGia(String tenQuocGia) {
        this.tenQuocGia = tenQuocGia;
    }
}
