import java.util.Scanner;
public class untitled6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap x");
        float x = sc.nextFloat();
        double sin = 0;
        double ts,ms,a,j;
        a=1;
        ts=1;
        ms=1;
        int i=1;
        while (Math.abs(a)>0.0001) {
            j = Math.pow((-1),i/2);
            ts = ts*Math.pow(x,i+1/2);
            ms = giaithua(i+1/2);
            a=j*ts/ms;
            sin+=a;
            i+=2;
        }
        System.out.println("sin(x) = "+(double)Math.round(sin*1000)/1000);
        System.out.println("Ham sin(x) = " + Math.sin(x));
    }
    public static double giaithua(double a){
        double gt = 1;
        for (int i =1;i<=a;i++){
            gt = gt*i;
        }
        return gt;
    }
}
