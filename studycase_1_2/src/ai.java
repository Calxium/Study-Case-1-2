import java.util.Scanner;

public class ai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String perintah;
        int n = 0;

        String[] pembeli = new String[0];
        double[] x = new double[0];
        double[] y = new double[0];

        while (n != 1) {
            System.out.print("Masukkan perintah: ");
            perintah = input.nextLine().trim();

            if (perintah.equals("UPSERT_CUST")) {
                System.out.println("Masukkan data (format: Nama X Y): ");
                String line = input.nextLine();
                String[] parts = line.split("\\s+"); // pisahkan berdasarkan spasi

                if (parts.length < 3) {
                    System.out.println("Format salah! Harus: Nama X Y");
                    continue;
                }

                String name = parts[0];
                double x_ = Double.parseDouble(parts[1]);
                double y_ = Double.parseDouble(parts[2]);

                // tambah nama
                String[] temp = new String[pembeli.length + 1];
                for (int i = 0; i < pembeli.length; i++) {
                    temp[i] = pembeli[i];
                }
                temp[temp.length - 1] = name;
                pembeli = temp;

                // tambah x
                double[] tempx = new double[x.length + 1];
                for (int i = 0; i < x.length; i++) {
                    tempx[i] = x[i];
                }
                tempx[tempx.length - 1] = x_;
                x = tempx;

                // tambah y
                double[] tempy = new double[y.length + 1];
                for (int i = 0; i < y.length; i++) {
                    tempy[i] = y[i];
                }
                tempy[tempy.length - 1] = y_;
                y = tempy;

            } else if (perintah.equals("PRINT_CUST")) {
                n++;
            } else if (perintah.equals("DEL_CUST")) {
                // belum diisi
            }
        }

        System.out.println("\nDaftar Pembeli:");
        for (int i = 0; i < pembeli.length; i++) {
            System.out.println(pembeli[i] + " " + x[i] + " " + y[i]);
        }

        input.close();
    }
}
