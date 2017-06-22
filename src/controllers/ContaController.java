package controllers;

import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.OperacaoException;
import models.Cliente;
import models.Conta;
import models.IConta;

public abstract class ContaController implements IContaController {

    IClientesController cc = ClientesController.getInstancia();
    protected Cliente cliente;
    protected Conta conta;


    public ContaController(String username, String psswrd) throws LoginException, ClienteException {
        cliente = cc.logInCliente(username, psswrd);
        conta = cliente.getConta();
    }

    @Override
    public abstract boolean saque(double valor) throws OperacaoException;

    @Override
    public abstract boolean transferencia(double valor, Conta x) throws OperacaoException;

    @Override
    public boolean deposito(double valor) throws OperacaoException {
        if(valor > 0){
            conta.setSaldo(valor);
            return true;
        }else throw new OperacaoException("Valor inválido");

    }

    @Override
    public void encerraOperacao() {
        this.conta = null;
    }

    @Override
    public void setConta(String username, String psswrd) throws LoginException, ClienteException {
        if(this.conta == null){
            cliente = cc.logInCliente(username, psswrd);
            if(cliente == null) throw new LoginException("Login inválido!");
            this.conta = cliente.getConta();
        }
    }

}
