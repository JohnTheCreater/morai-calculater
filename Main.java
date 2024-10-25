import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
        MoraiFinder finder=new MoraiFinder();
        do{
            System.out.println("MORAI CALCULATER!");
            System.out.println("1.add details");
            System.out.println("2.find morai");
            System.out.println("3.exit");
            int option=scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    System.out.print("how many inputs: ");
                    int n=scan.nextInt();
                    scan.nextLine();
                    for(int i=0;i<n;i++)
                    {
                        String info=scan.nextLine();
                        finder.addDetails(info);
                    }
                    break;
                case 2:
                    System.out.print("enter name: ");
                    String personName=scan.nextLine();
                    finder.findMorai(personName);
                    break;
                case 3:
                    return;
            
                default:
                    System.out.println("invalid option!");
                    break;
            }


        }while(true);
    }
    
}
