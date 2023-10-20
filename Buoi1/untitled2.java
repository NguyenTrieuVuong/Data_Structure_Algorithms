import java.util.Scanner;

class Sophuc {
  public float thuc;
  public float ao;
}

public class untitled2 {
  public static Sophuc Nhap() {
    Sophuc so = new Sophuc();
    Scanner nhap = new Scanner(System.in);
    System.out.println("Nhap phan thuc");
    so.thuc = nhap.nextFloat();
    System.out.println("Nhap phan ao");
    so.ao = nhap.nextFloat();
    return so;
  }

  public static void Tong(Sophuc a, Sophuc b) {
    Sophuc tong = new Sophuc();
    tong.thuc = a.thuc + b.thuc;
    tong.ao = a.ao + b.ao;
    System.out.println("Tong :" + tong.thuc + " + " + tong.ao + "i");
  }

  public static void Hieu(Sophuc a, Sophuc b) {
    Sophuc hieu = new Sophuc();
    hieu.thuc = a.thuc - b.thuc;
    hieu.ao = a.ao - b.ao;
    System.out.println("Hieu :" + hieu.thuc + " + " + hieu.ao + "i");
  }

  public static void Tich(Sophuc a, Sophuc b) {
    Sophuc tich = new Sophuc();
    tich.thuc = a.thuc * b.thuc - a.ao * b.ao;
    tich.ao = a.thuc * b.ao + a.ao * b.thuc;
    System.out.println("Tich :" + tich.thuc + " + " + tich.ao + "i");
  }

  public static void main(String[] args) {
    Sophuc a = new Sophuc();
    Sophuc b = new Sophuc();
    int kt = 0;
    while (kt == 0) {
      try {
        a = Nhap();
        b = Nhap();
        Tong(a, b);
        Hieu(a, b);
        Tich(a, b);
        kt = 1;
      } catch (Exception e1) {
        System.out.println("Nhap sai! Ban phai nhap so!");
      }
    }
  }
}