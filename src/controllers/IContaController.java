package controllers;

import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.OperacaoException;
import models.Conta;
import models.IConta;



public interface IContaController {

    public boolean saque(double valor) throws OperacaoException;
    public boolean transferencia(double valor, Conta x) throws OperacaoException;
    public boolean deposito(double valor) throws OperacaoException;
    public void encerraOperacao();
    public void setConta(String username, String psswrd) throws LoginException, ClienteException;
}
