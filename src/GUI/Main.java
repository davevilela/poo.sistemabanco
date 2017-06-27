package GUI;

import Fachada.Facade;
import exceptions.*;
import models.Cliente;
import models.ClienteEstudante;
import models.ClientePremium;
import models.Conta;

import java.util.Scanner;


public class Main {
    static Scanner scan = new Scanner(System.in);
    static Facade f = Facade.getInstance();

    public static void main(String[] args) throws ClienteException, LoginException {
        menuPrincipal();
    }

    private static void menuPrincipal() throws ClienteException, LoginException {
        int opt = 0;
        do {
            showMsg("BISF - BANCO INTERNACIONAL SENFUNDOS");
            showMsg("O que deseja fazer?");
            showMsg("1 ---- Abrir uma conta!");
            showMsg("2 ---- Acessar sua conta com o internet banking");
            opt = scan.nextInt();
        }while(opt == 0);

        switch (opt){

            case 1:
                    menuCadastro();
                break;
            case 2:
                menuAcesso();
                break;
        }

    }


    private static void showMsg(String message){
        System.out.println(message);
    }

    private static void menuCadastro() throws ClienteException, LoginException {
        int opt = 0;
        Cliente c;
        showMsg("Bem vindo ao BISF!");
        showMsg("Vamos iniciar o processo de abertura da conta.");
        showMsg("Por favor, insira os dados a seguir:");
        showMsg("Nome Completo: ");
        String nome = scan.nextLine();
        do {
            nome = scan.nextLine();
            if (nome.isEmpty()) {
                showMsg("Nome inválido. Insira novamente.");
            }
        } while (nome.isEmpty());

        showMsg("CPF (Só numeros): ");
        String cpf;
        do {
            cpf = scan.nextLine();
            if (cpf.isEmpty() || (cpf.length() > 11)) {
                showMsg("CPF inválido. Insira novamente.");
            }
        } while (cpf.isEmpty() || (cpf.length() != 11));

        showMsg("Data de nascimento: ");
        int day, month, year;
        do {
            showMsg("Dia: ");
            day = scan.nextInt();
            showMsg("Mês: ");
            month = scan.nextInt();
            showMsg("Ano: ");
            year = scan.nextInt();
            if ((day < 0 || day > 31) || (month < 0 || month > 12) || (year < 1917 || year > 2017)) {
                showMsg("Data inválida.");
            }
        } while ((day < 0 || day > 31) || (month < 0 || month > 12) || (year < 1917 || year > 2017));

        scan = new Scanner(System.in);

        showMsg("Agora defina um nome de usuário único.");
        String username = scan.nextLine();
        boolean x;
        do {
            if (f.clienteExists(username)) x = true;
            else x = false;
            if(x == true){
                showMsg("Usuário já existe!");
                username = scan.nextLine();
            }
        } while (x != false);

        showMsg("Agora defina uma senha com mais de 6 digitos para o internet banking: ");
        String psswrd = scan.nextLine();
        do{
            if(psswrd.length() < 6){
                showMsg("Senha inválida. Escolha outra.");
                psswrd = scan.nextLine();
            }
        }while(psswrd.length() < 6);

        showMsg("Agora escolha seu tipo de conta: ");
        showMsg("1 ---- Conta Estudante Senfundo na medida!");
        showMsg("2 ---- Conta Corrente Senfundo premium!");
        opt = scan.nextInt();
        switch (opt){
            case 1:
                c = new ClienteEstudante(nome, cpf, year, month, day);
                try {
                    f.inserirCliente(c);
                    c.setUserName(username);
                    c.getConta().setSenha(psswrd);
                } catch (ClienteException e) {
                    e.getMessage();
                }
                break;
            case 2:
                c = new ClientePremium(nome, cpf, year, month, day);
                try {
                    f.inserirCliente(c);
                    c.setUserName(username);
                    c.getConta().setSenha(psswrd);
                } catch (ClienteException e) {
                    e.getMessage();
                }
                break;
        }

        showMsg("Ótimo! Agora espere um momento enquanto processamos seu cadastro.");
        showMsg("Cadastro efetuado ! pressione qualquer tecla para voltar ao menu principal!");
        scan = new Scanner(System.in);

        String press = scan.nextLine();

        menuPrincipal();
    }

    private static void menuAcesso() throws LoginException, ClienteException {
        int opt;
        scan = new Scanner(System.in);

        showMsg("Login internet banking:");
        System.out.print("Username: ");
        String username = scan.nextLine();
        System.out.print("Senha: ");
        String psswrd = scan.nextLine();

        Cliente c = null;

        try{
            c = f.logInCliente(username, psswrd);
        }catch (ClienteException e){
            e.getMessage();
        }catch (LoginException e){
            e.getMessage();
        }


        if(c != null){
            menuOptions();
        }

    }

    private static void menuSaque(){
        scan = new Scanner(System.in);
        double valor;
        showMsg("Digite a quantia do saque: ");
        valor = scan.nextDouble();

        try {
            boolean b = f.saque(valor);

            if(b) {
                showMsg("Saque efetuado com sucesso.");
                menuOptions();
            }
        } catch (OperacaoException e) {
            e.printStackTrace();
        }

    }

    private static void menuDeposito(){
        scan = new Scanner(System.in);
        double valor;
        showMsg("Informe a quantia a depositar: ");
        valor = scan.nextDouble();

        try {
            boolean b = f.deposito(valor);
            if(b){
                showMsg("Depósito efetuado com sucesso.");
                menuOptions();
            }
        } catch (OperacaoException e) {
            e.printStackTrace();
        }
    }

    private static void menuTransferencia(){
        scan = new Scanner(System.in);
        double valor;
        String destino;

        showMsg("Digite a quantia a ser transferida");
        valor = scan.nextDouble();
        showMsg("Digite a conta de destino");
        destino = scan.nextLine();

        try {
            boolean b = f.transferencia(valor, destino);
            if(b){
                showMsg("Transferencia efetuada com sucesso.");
                menuOptions();
            }
        } catch (OperacaoException e) {
            e.getMessage();
        } catch (ClienteException e) {
            e.getMessage();
        }
    }

    private static void menuOptions(){
        showMsg("O que deseja fazer?");
        showMsg("1 ---- Consultar saldo");
        showMsg("2 ---- Fazer saque");
        showMsg("3 ---- Fazer depósito");
        showMsg("4 ---- Fazer transferência");

        int opt = scan.nextInt();

        switch (opt){
            case 1:
                showMsg("Seu saldo é de: R$" + f.getSaldo());
                break;
            case 2:
                menuSaque();
                break;
            case 3:
                menuDeposito();
                break;
            case 4:
                menuTransferencia();
                break;
        }

    }
}
