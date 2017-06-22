package controllers;

import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.OperacaoException;
import models.*;


public class ContaPoupancaController implements IContaController {

    private IClientesController cc = ClientesController.getInstancia();
    private ClienteEstudante cliente;
    private ContaPoupanca conta;

    public ContaPoupancaController(String username, String psswrd) throws LoginException, ClienteException {
        cliente = (ClienteEstudante) cc.logInCliente(username, psswrd);
        conta = (ContaPoupanca) cliente.getConta();
    }


    @Override
    public boolean saque(double valor) throws OperacaoException {
        if(conta.getContadorOperacoes() % 2 == 0) {
            conta.setSaldo(conta.getSaldo() - 0.10);
        }

        if(conta.getSaldo() > valor){
            double valorSaldo = conta.getSaldo() - valor;
            conta.setSaldo(valorSaldo);
            conta.setContadorOperacoes();
            return true;
        }
        throw new OperacaoException("Saldo insuficiente. Operação cancelada.");
    }

    @Override
    public boolean transferencia(double valor, String destino) throws OperacaoException, ClienteException {
        Cliente x = cc.procurarCliente(destino);
        if(x == null) throw new ClienteException("Destinatário inválido!");
        if(valor < 0) throw new OperacaoException("Valor inválido");

        if(conta.getContadorOperacoes() % 2 == 0) {
            conta.setSaldo(conta.getSaldo() - 0.10);
        }


        if(conta.getSaldo() > valor){
            double valorSaldo = conta.getSaldo() - valor;
            conta.setSaldo(valorSaldo);
            x.getConta().setSaldo(valor);
            conta.setContadorOperacoes();
            return true;
        }
        throw new OperacaoException("Saldo inválido.");
    }


    @Override
    public boolean deposito(double valor) throws OperacaoException {
        if(valor > 0){
            conta.setSaldo(valor);
            conta.renderPoupanca();
            return true;
        }
        throw new OperacaoException("Valor inválido. Tente novamente.");
    }

    @Override
    public void encerraOperacao() {
        this.conta = null;
        this.cliente = null;
    }

    @Override
    public void setConta(String username, String psswrd) throws LoginException, ClienteException {
        cliente = (ClienteEstudante) cc.logInCliente(username, psswrd);
        conta = (ContaPoupanca) cliente.getConta();
    }
}
