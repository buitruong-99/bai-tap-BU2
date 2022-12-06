package bai2;

import java.io.Serializable;

public class KhachHang implements Serializable {
    private String soCmnd;
    private String tenKh;
    private String gaDen;
    private double giaTien;

    public KhachHang() {
    }

    public KhachHang(String soCmnd, String tenKh, String gaDen, double giaTien) {
        this.soCmnd = soCmnd;
        this.tenKh = tenKh;
        this.gaDen = gaDen;
        this.giaTien = giaTien;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getGaDen() {
        return gaDen;
    }

    public void setGaDen(String gaDen) {
        this.gaDen = gaDen;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }
    public void themKhachHang(){

    }
}
