import java.util.Scanner;
public class Studycase_1_2 {
    public static void main(String[] args){
        String perintah;
        Scanner input =  new Scanner(System.in);
        int n = 0;
        String[] pembeli = new String[0];
        double[] x = new double[0];
        double[] y = new double[0];

        while (n != 1) { 
            perintah = input.nextLine();
            if (perintah.equals("UPSERT_CUST")){
                // input nama
                String name = input.nextLine();
                String[] temp = new String[pembeli.length + 1];
                for(int i = 0; i <  pembeli.length; i++){
                    temp[i] = pembeli[i];
                }
                temp[temp.length-1] = name;
                pembeli = temp;
                // input x
                double x_ = input.nextDouble();
                double[] tempx = new double[x.length + 1];
                for(int i = 0; i <  x.length; i++){
                    tempx[i] = x[i];
                }
                tempx[tempx.length-1] = x_;
                x = tempx;
                // input y
                double y_ = input.nextDouble();
                double[] tempy = new double[y.length + 1];
                for(int i = 0; i <  y.length; i++){
                    tempy[i] = y[i];
                }
                tempy[tempy.length-1] = y_;
                y = tempy;
                input.nextLine();
            }else if (perintah.equals("PRINT_CUST")){
                break;
            }else if (perintah.equals("DEL_CUST")){

            }
        }
        System.out.println(n);
        for(int i = 0; i<pembeli.length+2; i++){
            System.out.print(pembeli[i]);
            System.out.print(x[i]);
            System.out.println(y[i]);
        }
    }   
}
