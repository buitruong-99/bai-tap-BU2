package bai2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDanhSachKH {
    private static final String FILE_DS_KHACH_HANG_CHO_MUA_VE = "ds_ks_cho_mua_ve.txt";

    //Lưu danh sách vào file
    public void writeFile(List<KhachHang> khachHangList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(FILE_DS_KHACH_HANG_CHO_MUA_VE));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(khachHangList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    public List<KhachHang> read() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(FILE_DS_KHACH_HANG_CHO_MUA_VE));
            ois = new ObjectInputStream(fis);
            listKhachHang = (List<KhachHang>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return listKhachHang;
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

