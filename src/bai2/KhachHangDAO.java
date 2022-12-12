package bai2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO {
//    private static final String DANH_SACH_KHACH_HANG = "dskh.txt";
//
//    public void write(List<KhachHang> studentList) {
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(DANH_SACH_KHACH_HANG);
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(studentList);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fos);
//            closeStream(oos);
//        }
//    }
//
//    public ArrayList<KhachHang> read() {
//        ArrayList<KhachHang> khachHangList = new ArrayList<>();
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(DANH_SACH_KHACH_HANG);
//            ois = new ObjectInputStream(fis);
//            khachHangList = (ArrayList<KhachHang>) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fis);
//            closeStream(ois);
//        }
//        return khachHangList;
//    }
//
//
//    private void closeStream(InputStream is) {
//        if (is != null) {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * close output stream
//     *
//     * @param os: output stream
//     */
//    private void closeStream(OutputStream os) {
//        if (os != null) {
//            try {
//                os.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
