package views;
import controllers.CadastroController;
import models.Cliente;
import models.ClientePremium;

import java.util.Scanner;
/**
 * Created by daviv on 19/06/2017.
 */
public class MainMenu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CadastroController cadastro;
        System.out.print("O que deseja fazer?");
        int opt = scan.nextInt();

        switch (opt){
            case 1:
                String nome = scan.nextLine();
                String cpf = scan.nextLine();

               cadastro = new CadastroController();

        }

    }
}
