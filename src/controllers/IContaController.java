package controllers;

import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.OperacaoException;
import models.Conta;


public interface IContaController {


    public abstract double getSaldo();
    public abstract int getNumero();
    public abstract boolean saque(double valor) throws OperacaoException;
    public abstract boolean deposito(double valor) throws OperacaoException;
    public abstract boolean transferencia(double valor, String destino) throws OperacaoException, ClienteException;
    public abstract String getNome();
    public abstract void setConta(Conta c);
}
