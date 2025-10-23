import java.util.Scanner;

public class studikes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] pembeli = new String[999];
        double[] x = new double[999];
        double[] y = new double[999];
        int j = 0;

        while (true) {
            String line = input.nextLine();
            String[] bagian = line.split(" ");

            if (bagian[0].equals("UPSERT_CUST")) {
                // format: UPSERT_CUST NAMA X Y
                pembeli[j] = bagian[1];
                x[j] = Double.parseDouble(bagian[2]);
                y[j] = Double.parseDouble(bagian[3]);
                System.out.println("CUSTOMER: " + pembeli[j] + "  " + x[j] + ", " + y[j]);
                j++;
            } else if (bagian[0].equals("PRINT_CUST")) {
                for(int i = 0; i<j-1; i++){
                    for(int k = i + 1; k<j; k++){
                        if (pembeli[i].compareToIgnoreCase(pembeli[k])> 0){
                            String tempPembeli = pembeli[i];
                            pembeli[i] = pembeli[k];
                            pembeli[k] = tempPembeli;
                            // Tukar x
                            double tempX = x[i];
                            x[i] = x[k];
                            x[k] = tempX;
                            // Tukar y
                            double tempY = y[i];
                            y[i] = y[k];
                            y[k] = tempY;
                            }
                
                        }
                    }
                for (int i = 0; i < j; i++){
                    System.out.println(pembeli[i] + " @ " + x[i] + ", " + y[i]);
                }
            } else if (bagian[0].equals("DEL_CUST")) {
                break;
            }
        }

    }
}
