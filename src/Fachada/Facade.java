package Fachada;

import controllers.*;
import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.OperacaoException;
import models.Cliente;
import models.Conta;


public class Facade implements IClientesController, IContaController{
    private static Facade instancia = new Facade();
    private IClientesController clientesController;
    private IContaController contaController;


    public static Facade getInstance() {
        if(instancia == null){
            instancia = new Facade();
        }
        return instancia;
    }

    private Facade() {
        clientesController = ClientesController.getInstancia();
        contaController = ContaController.getInstancia();
    }


    @Override
    public void inserirCliente(Cliente c) throws ClienteException {
        clientesController.inserirCliente(c);
    }

    @Override
    public void removerCliente(Cliente c) throws ClienteException {
        clientesController.removerCliente(c);
    }

    @Override
    public Cliente procurarCliente(String username) throws ClienteException {
        Cliente c = clientesController.procurarCliente(username);
        return c;
    }

    @Override
    public Cliente logInCliente(String userName, String psswrd) throws LoginException, ClienteException {
        return clientesController.logInCliente(userName, psswrd);
    }

    @Override
    public boolean clienteExists(String username) {
       boolean result;
        if (clientesController.clienteExists(username)) result = true;
        else result = false;

        return result;
    }

    //---Conta controller

    @Override
    public void setConta(Conta c) {
        contaController.setConta(c);
    }

    @Override
    public String getNome() {
        return contaController.getNome();
    }

    @Override
    public double getSaldo() {
        return contaController.getSaldo();
    }

    @Override
    public int getNumero() {
        return contaController.getNumero();
    }

    @Override
    public boolean saque(double valor) throws OperacaoException {
        boolean saque = contaController.saque(valor);
        return saque;
    }

    @Override
    public boolean deposito(double valor) throws OperacaoException {
        boolean deposito = contaController.deposito(valor);
        return deposito;
    }

    @Override
    public boolean transferencia(double valor, String destino) throws OperacaoException, ClienteException {
        boolean transferencia = contaController.transferencia(valor, destino);
        return transferencia;
    }
}
