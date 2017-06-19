package controllers;

import models.Conta;

/**
 * Created by daviv on 19/06/2017.
 */

public abstract class OperacoesController {

    Conta c;

    public String getExtrato(){
        String extrato = "Seu saldo é de: R$" + c.getSaldo();
        return extrato;
    }

    public abstract boolean saque(double valor);
    public abstract boolean transferencia(double valor, Conta x);
    public abstract boolean deposito(double valor);

}
