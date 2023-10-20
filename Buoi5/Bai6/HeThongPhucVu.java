import java.util.LinkedList;
import java.util.Queue;

class QuayGiaoDichVien {
    private int maGiaoDichVien;
    private String tenGiaoDichVien;
    private int soKhachPhucVu;
    private int tongThoiGianPhucVu;

    public QuayGiaoDichVien(int maGiaoDichVien, String tenGiaoDichVien) {
        this.maGiaoDichVien = maGiaoDichVien;
        this.tenGiaoDichVien = tenGiaoDichVien;
        this.soKhachPhucVu = 0;
        this.tongThoiGianPhucVu = 0;
    }

    public int getMaGiaoDichVien() {
        return maGiaoDichVien;
    }

    public String getTenGiaoDichVien() {
        return tenGiaoDichVien;
    }

    public int getSoKhachPhucVu() {
        return soKhachPhucVu;
    }

    public int getTongThoiGianPhucVu() {
        return tongThoiGianPhucVu;
    }

    public void phucVuKhach(KhachHang khachHang) {
        // Xử lý việc phục vụ khách hàng
        int thoiGianPhucVu = khachHang.getThoiGianPhucVu();
        System.out.println("Giao dich vien " + tenGiaoDichVien + " dang phuc vu khach hang " + khachHang.getMaKhachHang() + " trong " + thoiGianPhucVu + "s.");
        try {
            Thread.sleep(thoiGianPhucVu * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Giao dich vien " + tenGiaoDichVien + " da hoan thanh phuc vu khach hang " + khachHang.getMaKhachHang() + ".");
        soKhachPhucVu++;
        tongThoiGianPhucVu += thoiGianPhucVu;
    }
}

class KhachHang {
    private int maKhachHang;
    private int thoiGianPhucVu;

    public KhachHang(int maKhachHang, int thoiGianPhucVu) {
        this.maKhachHang = maKhachHang;
        this.thoiGianPhucVu = thoiGianPhucVu;
    }

    public int getMaKhachHang() {
        return maKhachHang;
    }

    public int getThoiGianPhucVu() {
        return thoiGianPhucVu;
    }
}

public class HeThongPhucVu{
    private Queue<KhachHang> hangCho;
    private QuayGiaoDichVien[] quayGiaoDichViens;
    public HeThongPhucVu(int soQuayGiaoDichVien) {
        this.hangCho = new LinkedList<KhachHang>();
        this.quayGiaoDichViens = new QuayGiaoDichVien[soQuayGiaoDichVien];
        for (int i = 0; i < soQuayGiaoDichVien; i++) {
            quayGiaoDichViens[i] = new QuayGiaoDichVien(i+1, "Quay " + (i+1));
        }
    }
    
    public void themKhachHang(KhachHang khachHang) {
        hangCho.add(khachHang);
        System.out.println("Khach hang " + khachHang.getMaKhachHang() + " da duoc them vao hang cho.");
    }
    
    public void phucVuKhachHang() {
        while (!hangCho.isEmpty()) {
            KhachHang khachHang = hangCho.peek();
            QuayGiaoDichVien giaoDichVienTrong = timGiaoDichVienTrong();
            if (giaoDichVienTrong != null) {
                hangCho.remove();
                giaoDichVienTrong.phucVuKhach(khachHang);
            }
        }
    }
    
    public QuayGiaoDichVien timGiaoDichVienTrong() {
        QuayGiaoDichVien giaoDichVienTrong = null;
        for (int i = 0; i < quayGiaoDichViens.length; i++) {
            if (giaoDichVienTrong == null || quayGiaoDichViens[i].getSoKhachPhucVu() < giaoDichVienTrong.getSoKhachPhucVu()) {
                giaoDichVienTrong = quayGiaoDichViens[i];
            }
        }
        return giaoDichVienTrong;
    }
    
    public int getTongSoKhachDaPhucVu() {
        int tongSoKhachDaPhucVu = 0;
        for (int i = 0; i < quayGiaoDichViens.length; i++) {
            tongSoKhachDaPhucVu += quayGiaoDichViens[i].getSoKhachPhucVu();
        }
        return tongSoKhachDaPhucVu;
    }
    
    public void thongKeSoKhachVaThoiGianPhucVu() {
        for (int i = 0; i < quayGiaoDichViens.length; i++) {
            System.out.println("Giao dich vien " + quayGiaoDichViens[i].getTenGiaoDichVien() + " da phuc vu " + quayGiaoDichViens[i].getSoKhachPhucVu() + " khach hang trong tong thoi gian " + quayGiaoDichViens[i].getTongThoiGianPhucVu() + "s.");
        }
    }
    
    public static void main(String[] args) {
        HeThongPhucVu heThongPhucVu = new HeThongPhucVu(3);
        heThongPhucVu.themKhachHang(new KhachHang(1, 3));
        heThongPhucVu.themKhachHang(new KhachHang(2, 2));
        heThongPhucVu.themKhachHang(new KhachHang(3, 4));
        heThongPhucVu.themKhachHang(new KhachHang(4, 1));
        heThongPhucVu.themKhachHang(new KhachHang(5, 5));
        heThongPhucVu.phucVuKhachHang();
        heThongPhucVu.thongKeSoKhachVaThoiGianPhucVu();
        System.out.println("Tong so khach da phuc vu: " + heThongPhucVu.getTongSoKhachDaPhucVu());
        }
}
    
