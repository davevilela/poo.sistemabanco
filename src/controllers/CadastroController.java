package controllers;

import models.*;
/**
 * Created by daviv on 19/06/2017.
 */
public class CadastroController {

    public boolean cadastrarClienteComum(String nome, String CPF, int year, int month, int day){
        Cliente c = new ClientePremium(nome, CPF, year, month, day);

        return false;
    }

    public boolean cadastrarClientePremium(){
        return false;
    }
}
