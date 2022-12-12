package bai3;

public class OTo extends PhuongTienDiChuyen {
    private String tenLoaiNhienLieu;
    
    public OTo(String tenLoaiNhienLieu, HangSanXuat sanXuat) {
        super("O to", sanXuat);
        this.tenLoaiNhienLieu = tenLoaiNhienLieu;
    }

    public String getTenLoaiNhienLieu() {
        return tenLoaiNhienLieu;
    }

    public void setTenLoaiNhienLieu(String tenLoaiNhienLieu) {
        this.tenLoaiNhienLieu = tenLoaiNhienLieu;
    }

    @Override
    public double layVanToc(){
        return 500;
    }
}