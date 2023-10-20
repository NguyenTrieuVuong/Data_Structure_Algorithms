import java.util.Scanner;;

public class untitled3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sphere hc1 = new Sphere();
        Sphere hc2 = new Sphere();
        System.out.println("Hinh cau thu nhat: ");
        hc1.nhapSphere(sc);
        hc2.nhapSphere(sc);
        hc1.Area();
        hc1.Volume();
        hc1.checkPosition(hc2);
    }
}

class Sphere {
    private double r, x, y, z;
    double pi = 3.14;

    public Sphere() {
        r = 0;
        x = 0;
        y = 0;
        z = 0;
    }

    public Sphere(double radius, double x, double y, double z) {
        this.r = radius;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void nhapSphere(Scanner sc) {
        System.out.print("Nhap ban kinh hinh cau: ");
        r = sc.nextInt();
        System.out.print("Nhap vi tri tam hinh cau : ");
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
    }

    public void hienSphere() {
        System.out.printf("Tam hinh cau: {%f.3, %f.3, %f.3}, radius = %f.3", x, y, z, r);
    }

    public void Area() {
        System.out.println("Dien tich xung quanh: " + 4 * pi * r * r);
    }

    public void Volume() {
        System.out.println("Dien tich xung quanh: " + 4 * pi * Math.pow(r, 3));
    }

    public void checkPosition(Sphere c2) {
        if (Math.sqrt(Math.pow((x - c2.x), 2) + Math.pow((y - c2.y), 2) + Math.pow((z - c2.z), 2) + c2.r) <= r || Math
                .sqrt(Math.pow((x - c2.x), 2) + Math.pow((y - c2.y), 2) + Math.pow((z - c2.z), 2) + r) <= r + c2.r) {
            System.out.println("Hai hinh cau bao nhau");
        } else if (Math.sqrt(Math.pow((x - c2.x), 2) + Math.pow((y - c2.y), 2) + Math.pow((z - c2.z), 2) + c2.r) > r
                + c2.r) {
            System.out.println("Hai hinh cau giao nhau");
        } else {
            System.out.println("Hai hinh cau cach xa nhau");
        }
    }
}