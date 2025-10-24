import java.util.Scanner;

public class livy {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String[][] inputan = new String[999][4];
        String[][] dataCustomer = new String[999][3];
        String[][] dataDriver = new String[999][3];
        String xcor = "";
        String ycor = "";
        String nama = "";
        int countInputan = 0;
        int countCustomer = 0;
        int countDriver = 0;
        boolean statusCustomer = true;
        boolean statusDriver = true;

        while (true) {
            String line = input.nextLine().trim();
            if (line.isEmpty()) {
                break; 
            }

            String[] parts = line.split(" ");
            for (int j = 0; j < parts.length; j++) {
                inputan[countInputan][j] = parts[j];
            }
            countInputan++;
        }

        for (int i = 0; i < inputan.length; i++){
            if (inputan[i][0] == null){
                break;
            }

            else if (inputan[i][0].equals("UPSERT_CUST")){

                for (int j = 0; j < dataCustomer.length; j++){
                    if (dataCustomer[j][0] != null && dataCustomer[j][0].equalsIgnoreCase(inputan[i][1])){
                        dataCustomer[j][0] = inputan[i][1];
                        dataCustomer[j][1] = inputan[i][2];
                        dataCustomer[j][2] = inputan[i][3];
                        System.out.println("CUSTOMER: " + dataCustomer[j][0] + " SUDAH ADA, LOKASI BARU @ " + dataCustomer[j][1] + " " + dataCustomer[j][2]);
                        statusCustomer = true;
                        break;
                    }
                    else{
                        statusCustomer = false;
                    }  
                }
                if (statusCustomer == false){
                    dataCustomer[countCustomer][0] = inputan[i][1];
                    dataCustomer[countCustomer][1] = inputan[i][2];
                    dataCustomer[countCustomer][2] = inputan[i][3];
                    System.out.println("CUSTOMER: " + dataCustomer[countCustomer][0] + " DITAMBAH @ " + dataCustomer[countCustomer][1] + " " + dataCustomer[countCustomer][2]);
                    countCustomer += 1;
                }   
            } 
            
            else if (inputan[i][0].equals("DEL_CUST")){
                boolean statusCust = true;
                for (int j = 0; j < dataCustomer.length; j++){
                    if (dataCustomer[j][0] != null && dataCustomer[j][0].equalsIgnoreCase(inputan[i][1])){
                        System.out.println("CUSTOMER: " + dataCustomer[j][0] + " BERHASIL DIHAPUS");
                        dataCustomer[j][0] = null;
                        dataCustomer[j][1] = null;
                        dataCustomer[j][2] = null;  
                        break;  
                    }
                    else{
                        statusCust = false;
                    }
                }
                if (statusCust == false){
                    System.out.println("CUSTOMER: " + inputan[i][1] + " TIDAK DITEMUKAN");
                }

            } 

            else if (inputan[i][0].equals("PRINT_CUST")){
                String[] namaCustomer = new String[999];
                int count = 0;

                for (int j = 0; j < dataCustomer.length; j++){
                    if (dataCustomer[j][0] != null){
                        namaCustomer[count] = dataCustomer[j][0];
                        count+=1;
                    }
                }
                for (int j = 0; j < namaCustomer.length - 1; j++){
                    for (int k = 0; k < namaCustomer.length - j - 1; k++){
                        if ((namaCustomer[k] != null && namaCustomer[k + 1] != null) && (namaCustomer[k].compareTo(namaCustomer[k + 1]) > 0)){
                            nama = namaCustomer[k];
                            namaCustomer[k] = namaCustomer[k + 1];
                            namaCustomer[k + 1] = nama;
                        }
                    }
                }

                for (int j = 0; j < namaCustomer.length; j++){
                    if (namaCustomer[j] != null){
                        for (int k = 0; k < dataCustomer.length; k++){
                            if (dataCustomer[k][0] != null && namaCustomer[j].equals(dataCustomer[k][0])){
                                xcor = dataCustomer[k][1];
                                ycor = dataCustomer[k][2];
                                System.out.println(namaCustomer[j] + " @ " + xcor + " " + ycor);
                            }
                        }
                        
                    }
                    
                }   

            }
            
            else if (inputan[i][0].equals("UPSERT_DRIVER")){
                for (int j = 0; j < dataDriver.length; j++){
                    if (dataDriver[j][0] != null && dataDriver[j][0].equalsIgnoreCase(inputan[i][1])){
                        dataDriver[j][0] = inputan[i][1];
                        dataDriver[j][1] = inputan[i][2];
                        dataDriver[j][2] = inputan[i][3];
                        System.out.println("DRIVER: " + dataDriver[j][0] + " SUDAH ADA, LOKASI BARU @ " + dataDriver[j][1] + " " + dataDriver[j][2]);
                        statusDriver = true;
                        break;
                    }
                    else{
                        statusDriver = false;
                    }  
                }
                if (statusDriver == false){
                    dataDriver[countDriver][0] = inputan[i][1];
                    dataDriver[countDriver][1] = inputan[i][2];
                    dataDriver[countDriver][2] = inputan[i][3];
                    System.out.println("DRIVER: " + dataDriver[countDriver][0] + " DITAMBAH @ " + dataDriver[countDriver][1] + " " + dataDriver[countDriver][2]);
                    countDriver += 1;
                }   
            } 
            
            else if (inputan[i][0].equals("DEL_DRIVER")){
                boolean statusDri = true;
                for (int j = 0; j < dataDriver.length; j++){
                    if (dataDriver[j][0] != null && dataDriver[j][0].equalsIgnoreCase(inputan[i][1])){
                        System.out.println("DRIVER: " + dataDriver[j][0] + " BERHASIL DIHAPUS");
                        dataDriver[j][0] = null;
                        dataDriver[j][1] = null;
                        dataDriver[j][2] = null;  
                        break;  
                    }
                    else{
                        statusDri = false;
                    }
                }
                if (statusDri == false){
                    System.out.println("CUSTOMER: " + inputan[i][1] + " TIDAK DITEMUKAN");
                }

            }

            else if (inputan[i][0].equals("CALCULATE_DISTANCE")){
                for (int j = 0; j < dataCustomer.length; j++){
                    if (dataCustomer[j][0] != null && dataCustomer[j][0].equalsIgnoreCase(inputan[i][1])){
                        nama = dataCustomer[j][0];
                        xcor = dataCustomer[j][1];
                        ycor = dataCustomer[j][2];
                        break; 
                    }
                }
                System.out.println("DISTANCE " + nama + " @ " + xcor + ", " + ycor);

                String[][] driver = new String[99][4];
                int count = 0;
                for (int j = 0; j < dataDriver.length; j++){
                    if (dataDriver[j][0] != null){
                        double xCustomer = Double.parseDouble(xcor);
                        double yCustomer = Double.parseDouble(ycor);
                        double xDriver = Double.parseDouble(dataDriver[j][1]);
                        double yDriver = Double.parseDouble(dataDriver[j][2]);
                        
                        double jarak = Math.sqrt(Math.pow(xCustomer - xDriver, 2) + Math.pow(yCustomer - yDriver, 2));

                        driver[count][0] = dataDriver[j][0];  
                        driver[count][1] = dataDriver[j][1];  
                        driver[count][2] = dataDriver[j][2];  
                        driver[count][3] = String.format("%.2f", jarak); 
                        count += 1;

                    }
                }

                for (int j = 0; j < count - 1; j++){
                    for (int k = 0; k < count - j - 1; k++){
                        double jarak1 = Double.parseDouble(driver[k][3]);
                        double jarak2 = Double.parseDouble(driver[k + 1][3]);

                        if (jarak1 > jarak2){
                            String[] temp = driver[k];
                            driver[k] = driver[k + 1];
                            driver[k + 1] = temp;
                        }
                    }
                }

                for (int j = 0; j < driver.length; j++){
                    if (driver[j][0] != null){
                        System.out.println(driver[j][0] + " @ " + driver[j][1] + ", " + driver[j][2] + " = " + driver[j][3]);
                    }
                }
            }

            else if (inputan[i][0].equals("PRINT_DISTANCE_MATRIX")){
                for (int j = 0; j < dataCustomer.length; j++){
                    if (dataCustomer[j][0] != null){
                        for (int k = 0; k < dataDriver.length; k++){
                            if (dataDriver[k][0] != null){
                                String customer = dataCustomer[j][0];
                                String driver = dataDriver[k][0];
                                double xCustomer = Double.parseDouble(dataCustomer[j][1]);
                                double yCustomer = Double.parseDouble(dataCustomer[j][2]);
                                double xDriver = Double.parseDouble(dataDriver[k][1]);
                                double yDriver = Double.parseDouble(dataDriver[k][2]);
                                double jarak = Math.sqrt(Math.pow(xCustomer - xDriver, 2) + Math.pow(yCustomer - yDriver, 2));
                                String hasil = String.format("%.2f", jarak);
                                System.out.printf("[%s][%s][%s]\n", customer, driver, hasil);
                            }
                        }
                    }
                }
            }

            else if (inputan[i][0].equals("CALCULATE_COST")){
                for (int j = 0; j < dataCustomer.length; j++){
                    if (dataCustomer[j][0] != null && dataCustomer[j][0].equalsIgnoreCase(inputan[i][1])){
                        nama = dataCustomer[j][0];
                        xcor = dataCustomer[j][1];
                        ycor = dataCustomer[j][2];
                        System.out.println("DISTANCE " + nama + " @ " + xcor + ", " + ycor);
                        break; 
                    }
                }

                String[][] driver = new String[99][5];
                int count = 0;
                double harga = 0;

                for (int j = 0; j < dataDriver.length; j++){
                    if (dataDriver[j][0] != null){
                        double xCustomer = Double.parseDouble(xcor);
                        double yCustomer = Double.parseDouble(ycor);
                        double xDriver = Double.parseDouble(dataDriver[j][1]);
                        double yDriver = Double.parseDouble(dataDriver[j][2]);
                        double jarak = Math.ceil(Math.sqrt(Math.pow(xCustomer - xDriver, 2) + Math.pow(yCustomer - yDriver, 2)));

                        if (jarak <= 1){
                            harga = 7000;
                        }
                        else if (jarak > 1 && jarak <= 5){
                            if (jarak == 5){
                                harga  = 7000 + (4 * 2000);
                            }
                            else {  
                                harga = 7000 + (((jarak - 1)) * 2000);
                            }
                        }
                        else if (jarak > 5 && jarak <= 10){
                            if (jarak == 10){
                                harga  = 7000 + (9 * 2500);
                            }
                            else {
                                harga = 7000 + (((jarak - 1)) * 2500);
                            }
                        }
                         
                        driver[count][0] = dataDriver[j][0];  
                        driver[count][1] = dataDriver[j][1];  
                        driver[count][2] = dataDriver[j][2];  
                        driver[count][3] = String.format("%.2f", jarak);
                        driver[count][4] = String.format("%.0f", harga);
                        count += 1;
                    }
                }

                for (int j = 0; j < count - 1; j++){
                    for (int k = 0; k < count - j - 1; k++){
                        double jarak1 = Double.parseDouble(driver[k][3]);
                        double jarak2 = Double.parseDouble(driver[k + 1][3]);

                        if (jarak1 > jarak2){
                            String[] temp = driver[k];
                            driver[k] = driver[k + 1];
                            driver[k + 1] = temp;
                        }
                    }
                }

                for (int j = 0; j < count; j++){
                    if (driver[j][0] != null){
                        System.out.println(driver[j][0] + " @ " + driver[j][1] + ", " + driver[j][2] + " = " + driver[j][4]);
                    }
                }
            }
        }
    }
}