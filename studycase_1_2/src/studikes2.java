import java.util.Scanner;
public class studikes2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[][] command = new String[999][4];
        String[][] Customer = new String[999][];
        String[][] Driver = new String[999][];
        int countCommand =0;
        int countCustomer =0;
        int countDriver =0;
        while(true){
            command[countCommand][0] = input.nextLine();
            if(command[countCommand][0].equals("UPSERT_CUST")){
                // input nama
                command[countCommand][1] = input.nextLine();
                // input x
                command[countCommand][2] = input.nextLine();
                // input y
                command[countCommand][3] = input.nextLine();
                countCommand++;
            }else if (command[countCommand][0].equals("UPSERT_DRIVER")){
                // input nama
                command[countCommand][1] = input.nextLine();
                // input x
                command[countCommand][2] = input.nextLine();
                // input y
                command[countCommand][3] = input.nextLine();
                countCommand++;
            }else if (command[countCommand][0].equals("DEL_CUST")){
                // input nama cust yang mau dihapus
                command[countCommand][1] = input.nextLine();
                countCommand++;
            }else if (command[countCommand][0].equals("DEL_DRIVER")){
                // input nama driver yang mau dihapus
                command[countCommand][1] = input.nextLine();
                countCommand++;
            }else if (command[countCommand][0].equals("exit")){
                break;
            }
            
        }

        for (int i = 0; i < countCommand; i++) {
            if (command[i][0].equals("UPSERT_CUST")) {
                System.out.println("CUSTOMER: " + command[i][1] + " DITAMBAH @ " + command[i][2] + ", " + command[i][3]);
            } else if (command[i][0].equals("UPSERT_DRIVER")) {
                System.out.println("DRIVER: " + command[i][1] + " DITAMBAH @ " + command[i][2] + ", " + command[i][3]);
            }
        }
    }
}
