package Logic.Users;

import Logic.Users.User;
import java.io.File;
import java.util.Scanner;

public class UsersManager {

    public static void main(String[] args) {
        User Usuario;
        Scanner Leer = new Scanner(System.in);
        String Name, Pass;
        String[] Cuentas;
        
        File Accounts = new File("Accounts\\Cuentas");
        do {
            System.out.println("Ingrese el nombre del usuario: ");
            Name = Leer.nextLine();
            
            System.out.println("Ingrese la contra: ");
            Pass = Leer.nextLine();
            
            Usuario = new User(Name, Pass, null);
            try {
                Usuario.SaveData(Usuario.getName());

                Cuentas = Accounts.list();
                System.out.println("Cuentas: ");
                for (String cuenta : Cuentas){
                    System.out.println(cuenta);
                }
                
                System.out.println("Ingrese la cuenta que desea buscar");
                Name = Leer.nextLine();
                System.out.println("Contra: "+User.LoadFile(Name).getPassword());
            } catch (Exception Ex){
                System.out.println("Ha ocurrido un error!");
            }
        } while (true);
    }

}