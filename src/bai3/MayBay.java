package bai3;

public class MayBay extends PhuongTienDiChuyen{
    private String tenLoaiNhienLieu;

    public MayBay(String tenLoaiNhienLieu, HangSanXuat sanXuat){
        super("May bay", sanXuat);
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
        return 800;
    }


}
