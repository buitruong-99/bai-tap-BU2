package bai2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
    private static final String DANH_SACH_KHACH_HANG = "dskh.txt";

    public void saveKh(List<KhachHang> khachHangList) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(DANH_SACH_KHACH_HANG));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(khachHangList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeStream(fileOutputStream);
            closeStream(objectOutputStream);
        }
    }



    public List<KhachHang> read() {
        List<KhachHang> listKhachHang = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(DANH_SACH_KHACH_HANG));
            objectInputStream = new ObjectInputStream(fileInputStream);
            listKhachHang = (List<KhachHang>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fileInputStream);
            closeStream(objectInputStream);
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
