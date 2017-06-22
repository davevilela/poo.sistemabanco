package controllers;

import models.Conta;
import models.ContaPoupanca;

/**
 * Created by daviv on 19/06/2017.
 */
public class OperacoesControllerCP extends ContaController {

    ContaPoupanca c;

    public OperacoesControllerCP(ContaPoupanca c){
        this.c = c;
    }


    @Override
    public boolean saque(double valor) {
        if(c.getContadorOperacoes() % 2 == 0) {
            c.setSaldo(c.getSaldo() - 0.10);
        }

        if(c.getSaldo() > valor){
            double valorSaldo = c.getSaldo() - valor;
            c.setSaldo(valorSaldo);
            c.setContadorOperacoes();
            return true;
        }
        return false;
    }

    @Override
    public boolean transferencia(double valor, Conta x) {
        if(c.getContadorOperacoes() % 2 == 0) {
            c.setSaldo(c.getSaldo() - 0.10);
        }

        if(c.getSaldo() > valor){
            double valorSaldo = c.getSaldo() - valor;
            c.setSaldo(valorSaldo);
            x.setSaldo(valor);
            c.setContadorOperacoes();
            return true;
        }
        return false;
    }

    @Override
    public boolean deposito(double valor) {
        if(valor > 0){
            c.setSaldo(valor);
            return true;
        }
        return false;
    }


}
