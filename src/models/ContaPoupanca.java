package models;


import exceptions.OperacaoException;

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

    @Override
    public void updateContadorOperacoes() {
        if(this.getContadorOperacoes() % 2 == 0){
            this.setSaldo(this.getSaldo() - 0.10);
        }
    }

    @Override
    public boolean saque(double valor) throws OperacaoException {
        this.updateContadorOperacoes();

        if(this.getSaldo() > valor){
            double valorSaldo = this.getSaldo() - valor;
            this.setSaldo(valorSaldo);
            this.setContadorOperacoes();
            return true;
        }
        throw new OperacaoException("Saldo insuficiente. Operação cancelada.");
    }

    @Override
    public boolean deposito(double valor) throws OperacaoException {
        if(valor > 0){
            this.setSaldo(valor);
            this.renderPoupanca();
            return true;
        }
        throw new OperacaoException("Valor inválido. Tente novamente.");
    }

    @Override
    public boolean transferencia(double valor, String destino){
        return false;
    }

}
