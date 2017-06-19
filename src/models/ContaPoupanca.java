package models;

/**
 * Created by daviv on 19/06/2017.
 */
public class ContaPoupanca extends Conta {

    private double jurosPoupanca = 0.05;

    public void renderPoupanca(){
        double valor = this.saldo * this.jurosPoupanca;
        this.saldo += valor;
    }


    @Override
    public void setSaldo(double valor) {
        this.saldo = valor;
    }

}
