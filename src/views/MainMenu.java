package views;
import controllers.ClientesController;

import java.util.Scanner;
/**
 * Created by daviv on 19/06/2017.
 */
public class MainMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ClientesController cadastro;
        System.out.print("O que deseja fazer?");
        int opt = scan.nextInt();

        switch (opt){
            case 1:
                String nome = scan.nextLine();
                String cpf = scan.nextLine();

               cadastro = new ClientesController();

        }

    }
}
