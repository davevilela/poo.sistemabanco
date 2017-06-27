package controllers;

import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.OperacaoException;
import models.Cliente;
import models.Conta;



public class ContaController implements IContaController {

    private static ContaController instancia;
    private IClientesController cc = ClientesController.getInstancia();
    private Cliente cliente;
    private Conta conta;

    public static ContaController getInstancia(){
        if(instancia == null){
            instancia = new ContaController();
            return instancia;
        }
        return instancia;
    }

    private ContaController(){

    }

    public void setConta(Conta c){
        this.conta = c;
    }

    @Override
    public String getNome() {
        return cliente.getNome();
    }


    @Override
    public double getSaldo() {
        return conta.getSaldo();
    }

    @Override
    public int getNumero() {
        return conta.getNumero();
    }

    @Override
    public boolean saque(double valor) throws OperacaoException {
        try{
            conta.saque(valor);
        }catch(OperacaoException e){
            e.getMessage();
        }
        return true;
    }

    @Override
    public boolean deposito(double valor) throws OperacaoException {
        try{
            conta.deposito(valor);
        } catch(OperacaoException e){
            e.getMessage();
        }
        return true;
    }

    @Override
    public boolean transferencia(double valor, String destino) throws OperacaoException, ClienteException {
        Cliente x;
        try{
            x = cc.procurarCliente(destino);
            conta.updateContadorOperacoes();
            if(conta.getSaldo() > valor){
                double valorSaldo = conta.getSaldo() - valor;
                conta.setSaldo(valorSaldo);
                x.getConta().setSaldo(valor);
                conta.setContadorOperacoes();
            }
            throw new OperacaoException("Saldo inválido.");
        } catch(ClienteException e){
            e.getMessage();
        } catch(OperacaoException e){
            e.getMessage();
        }
        return true;
    }


}
