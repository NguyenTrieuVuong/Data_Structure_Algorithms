import java.util.Scanner;

public class untitled7 {
    static int N = 3;

    public static void main(String[] args) {
        int[][] arr = { { 9, 16, 7 }, { 5, 6, 2 }, { 12, 7, 3 }, };
        float[][] inv = new float[N][N];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("Nhap so a: ");
        int a = sc.nextInt();
        dem_so_chan_lon_hon_a(a, arr);
        tim_so_gan_a_nhat(a, arr);
        tim_so_lon_thu_2(arr);
        tim_diem_yen_ngua(arr);
        System.out.println("Dinh thuc ma tran la: " + determinant(arr));
        System.out.print("Ma tran nghich dao la :\n");
        if (inverse(arr, inv))
            display(inv);
    }

    public static void dem_so_chan_lon_hon_a(int a, int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > a && arr[i][j] % 2 == 0) {
                    count++;
                }
            }
        }
        System.out.println("Co " + count + " so chan lon hon a");
    }

    public static void tim_so_gan_a_nhat(int a, int[][] arr) {
        int saiso = Math.abs(arr[0][0] - a);
        int x = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (saiso > Math.abs(arr[i][j] - a)) {
                    saiso = Math.abs(arr[i][j] - a);
                    x = arr[i][j];
                }
            }
        }
        System.out.println("So gan a nhat la: " + x);
    }

    public static void tim_so_lon_thu_2(int[][] arr) {
        int b1 = 1;
        int b2 = 0;
        int i, j;
        for (i = 0; i < arr.length; ++i) {
            for (j = 0; j < arr[i].length; ++j) {
                if (arr[i][j] > b1)
                    b1 = arr[i][j];
            }
        }
        for (i = 0; i < arr.length; ++i) {
            for (j = 0; j < arr[i].length; ++j) {
                if (arr[i][j] > b2 && arr[i][j] < b1)
                    b2 = arr[i][j];
            }
        }
        System.out.println("So lon thu 2 ma tran la: " + b2);
    }

    public static void tim_diem_yen_ngua(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            boolean isSadlePointExist = true;
            int minimum = matrix[i][0];
            int colIndexOfRowMinimum = 0;
            // finds minimum in row
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] < minimum) {
                    minimum = matrix[i][j];
                    colIndexOfRowMinimum = j;
                }
            }
            // find maximum in same column
            for (int j = 0; j < matrix.length; j++) {
                if (minimum < matrix[j][colIndexOfRowMinimum]) {
                    // if the above condition becomes true set saddle point to false
                    isSadlePointExist = false;
                    break;
                }
            }
            if (isSadlePointExist) {
                // prints the saddle point
                System.out.println("Diem yen ngua cua ma tran la: " + minimum);
            }
        }
    }

    public static int determinant(int[][] arr) {
        int result = 0;
        if (arr.length == 1) {
            result = arr[0][0];
            return result;
        }
        if (arr.length == 2) {
            result = arr[0][0] * arr[1][1] - arr[0][1] * arr[1][0];
            return result;
        }
        for (int i = 0; i < arr[0].length; i++) {
            int temp[][] = new int[arr.length - 1][arr[0].length - 1];

            for (int j = 1; j < arr.length; j++) {
                for (int k = 0; k < arr[0].length; k++) {

                    if (k < i) {
                        temp[j - 1][k] = arr[j][k];
                    } else if (k > i) {
                        temp[j - 1][k - 1] = arr[j][k];
                    }
                }
            }
            result += arr[0][i] * Math.pow(-1, (int) i) * determinant(temp);
        }
        return result;
    }

    public static void getCofactor(int A[][], int temp[][], int p, int q, int n) {
        int i = 0, j = 0;

        // Looping for each element of the matrix
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                // Copying into temporary matrix only those element
                // which are not in given row and column
                if (row != p && col != q) {
                    temp[i][j++] = A[row][col];

                    // Row is filled, so increase row index and
                    // reset col index
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /*
     * Recursive function for finding determinant of matrix.
     * n is current dimension of A[][].
     */
    public static int determinant(int A[][], int n) {
        int D = 0; // Initialize result

        // Base case : if matrix contains single element
        if (n == 1)
            return A[0][0];

        int[][] temp = new int[N][N]; // To store cofactors

        int sign = 1; // To store sign multiplier

        // Iterate for each element of first row
        for (int f = 0; f < n; f++) {
            // Getting Cofactor of A[0][f]
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);

            // terms are to be added with alternate sign
            sign = -sign;
        }

        return D;
    }

    // Function to get adjoint of A[N][N] in adj[N][N].
    public static void adjoint(int A[][], int[][] adj) {
        if (N == 1) {
            adj[0][0] = 1;
            return;
        }

        // temp is used to store cofactors of A[][]
        int sign = 1;
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // Get cofactor of A[i][j]
                getCofactor(A, temp, i, j, N);

                // sign of adj[j][i] positive if sum of row
                // and column indexes is even.
                sign = ((i + j) % 2 == 0) ? 1 : -1;

                // Interchanging rows and columns to get the
                // transpose of the cofactor matrix
                adj[j][i] = (sign) * (determinant(temp, N - 1));
            }
        }
    }

    // Function to calculate and store inverse, returns false if
    // matrix is singular
    public static boolean inverse(int A[][], float[][] inverse) {
        // Find determinant of A[][]
        int det = determinant(A, N);
        if (det == 0) {
            System.out.print("Singular matrix, can't find its inverse");
            return false;
        }

        // Find adjoint
        int[][] adj = new int[N][N];
        adjoint(A, adj);

        // Find Inverse using formula "inverse(A) = adj(A)/det(A)"
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                inverse[i][j] = adj[i][j] / (float) det;

        return true;
    }

    // Generic function to display the matrix. We use it to display
    // both adjoin and inverse. adjoin is integer matrix and inverse
    // is a float.

    public static void display(int A[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(A[i][j] + " ");
            System.out.println();
        }
    }

    public static void display(float A[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.printf("%.6f ", A[i][j]);
            System.out.println();
        }
    }
}
