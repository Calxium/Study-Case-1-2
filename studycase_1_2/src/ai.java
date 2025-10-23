import java.util.Scanner;

public class ai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] command = new String[999][4];
        String[][] dataCustomer = new String[999][3];
        String[][] dataDriver = new String[999][3];
        int countCommand = 0;
        int countCustomer = 0;
        int countDriver = 0;

        while (true) {
            String line = input.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            // Pisahkan input berdasarkan spasi
            String[] bagian = line.split(" ");

            // Pastikan input tidak kosong
            if (bagian.length == 0) continue;
            
            String perintah = bagian[0];

            if (perintah.equals("UPSERT_CUST") && bagian.length == 4) {
                command[countCommand][0] = bagian[0];
                command[countCommand][1] = bagian[1];
                command[countCommand][2] = bagian[2];
                command[countCommand][3] = bagian[3];
                countCommand++;
            } else if (perintah.equals("UPSERT_DRIVER") && bagian.length == 4) {
                command[countCommand][0] = bagian[0];
                command[countCommand][1] = bagian[1];
                command[countCommand][2] = bagian[2];
                command[countCommand][3] = bagian[3];
                countCommand++;
            } else if (perintah.equals("PRINT_CUST") && bagian.length == 1) {
                command[countCommand][0] = bagian[0];
                countCommand++;
            } else if (perintah.equals("PRINT_DRIVER") && bagian.length == 1) {
                command[countCommand][0] = bagian[0];
                countCommand++;
            } else if (perintah.equals("DEL_CUST") && bagian.length == 2) {
                command[countCommand][0] = bagian[0];
                command[countCommand][1] = bagian[1];
                countCommand++;
            } else if (perintah.equals("DEL_DRIVER") && bagian.length == 2) {
                command[countCommand][0] = bagian[0];
                command[countCommand][1] = bagian[1];
                countCommand++;
            }
        }

        // Output hasil UPSERT_CUST
        for (int i = 0; i < countCommand; i++) {
            if (command[i][0].equals("UPSERT_CUST")) {
                boolean sama_= false;
                for(int sama = 0; sama < countCustomer; sama++){
                    if(dataCustomer[sama][0] != null && command[i][1].equalsIgnoreCase(dataCustomer[sama][0])){
                        dataCustomer[sama][1] = command[i][2];
                        dataCustomer[sama][2] = command[i][3];
                        System.out.println("CUSTOMER: " + command[i][1] + " SUDAH ADA, LOKASI BARU @  " + command[i][2] + ", " + command[i][3]);
                        sama_ = true;
                        break;
                    }else {
                        sama_ = false;
                    }
                }
                if(sama_ == false){
                    dataCustomer[countCustomer][0] = command[i][1];
                    dataCustomer[countCustomer][1] = command[i][2];
                    dataCustomer[countCustomer][2] = command[i][3];
                    countCustomer++;
                    System.out.println("CUSTOMER: " + command[i][1] + " DITAMBAH @ " + command[i][2] + ", " + command[i][3]);
                }
            } else if (command[i][0].equals("UPSERT_DRIVER")) {
                boolean sama_= false;
                for(int sama = 0; sama < countDriver; sama++){
                    if(dataDriver[sama][0] != null && command[i][1].equalsIgnoreCase(dataDriver[sama][0])){
                        dataDriver[sama][1] = command[i][2];
                        dataDriver[sama][2] = command[i][3];
                        System.out.println("DRIVER: " + command[i][1] + " SUDAH ADA, LOKASI BARU @  " + command[i][2] + ", " + command[i][3]);
                        sama_ = true;
                        break;
                    }else {
                        sama_ = false;
                    }
                }
                if(sama_ == false){
                    dataDriver[countDriver][0] = command[i][1];
                    dataDriver[countDriver][1] = command[i][2];
                    dataDriver[countDriver][2] = command[i][3];
                    countDriver++;
                    System.out.println("DRIVER: " + command[i][1] + " DITAMBAH @ " + command[i][2] + ", " + command[i][3]);
                }
            }else if (command[i][0].equals("DEL_CUST")){
                boolean print = true;
                for(int j = 0; j < countCustomer ; j++){
                    if(command[i][1].equals(dataCustomer[j][0]) && dataCustomer[j][0] != null){
                        dataCustomer[j][0] = null;
                        print = true;
                        break;
                    }else if(!command[i][1].equals(dataCustomer[j][0])){
                        print = false;
                    }
                }
                    if(print == true){
                        System.out.println("CUSTOMER: " + command[i][1] + " BERHASIL DIHAPUS");
                    }else{
                        System.out.println("CUSTOMER: " + command[i][1] + " TIDAK DITEMUKAN");
                    }
            } else if (command[i][0].equals("DEL_DRIVER")) {
                boolean print = true;
                for(int j = 0; j < countDriver ; j++){
                    if(command[i][1].equals(dataDriver[j][0])){
                        dataDriver[j][0] = null;
                        print = true;
                        break;
                    }else if(!command[i][1].equals(dataDriver[j][0])){
                        print = false;
                    }else{

                    }
                }
                    if(print == true){
                        System.out.println("DRIVER: " + command[i][1] + " BERHASIL DIHAPUS");
                    }else{
                        System.out.println("DRIVER: " + command[i][1] + " TIDAK DITEMUKAN");
                    }
            }  else if (command[i][0].equals("PRINT_CUST")) {
                for(int a = 0; a<countCustomer-1; a++){
                    for(int b =  a + 1; b<countCustomer; b++){
                        if (dataCustomer[a][0] != null && dataCustomer[b][0] != null) {
                            if(dataCustomer[a][0].compareToIgnoreCase(dataCustomer[b][0])> 0){
                                // tukar nama
                                String tempCustomer = dataCustomer[a][0];
                                dataCustomer[a][0] = dataCustomer [b][0];
                                dataCustomer[b][0] = tempCustomer;
                                // tukar x
                                String tempX = dataCustomer[a][1];
                                dataCustomer[a][1] = dataCustomer [b][1];
                                dataCustomer[b][1] = tempX;
                                // tukar y
                                String tempY = dataCustomer[a][2];
                                dataCustomer[a][2] = dataCustomer [b][2];
                                dataCustomer[b][2] = tempY;
                            }
                        }
                    }
                }
                    for(int print = 0; print<countCustomer; print++){
                    if (dataCustomer[print][0] != null)
                    System.out.println(dataCustomer[print][0] + " @ " + dataCustomer[print][1] + ", " + dataCustomer[print][2]);
                }
            }  else if (command[i][0].equals("PRINT_DRIVER")) {
                for(int a = 0; a<countDriver-1; a++){
                    for(int b =  a + 1; b<countDriver; b++){
                        if (dataDriver[a][0] != null && dataDriver[b][0] != null) {
                            if(dataDriver[a][0].compareToIgnoreCase(dataDriver[b][0])> 0){
                                // tukar nama
                                String tempDriver = dataDriver[a][0];
                                dataDriver[a][0] = dataDriver [b][0];
                                dataDriver[b][0] = tempDriver;
                                // tukar x
                                String tempX = dataDriver[a][1];
                                dataDriver[a][1] = dataDriver [b][1];
                                dataDriver[b][1] = tempX;
                                // tukar y
                                String tempY = dataDriver[a][2];
                                dataDriver[a][2] = dataDriver [b][2];
                                dataDriver[b][2] = tempY;
                            }
                        }
                    }
                }
                    for(int print = 0; print<countDriver; print++){
                        if (dataDriver[print][0] != null)
                            System.out.println(dataDriver[print][0] + " @ " + dataDriver[print][1] + ", " + dataDriver[print][2]);
                }
            }
        }
    }
}
