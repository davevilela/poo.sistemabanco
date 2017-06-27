package models;


import exceptions.OperacaoException;

public class ContaCorrente extends Conta{

    private double limite = 16000;
    private double limiteTotal = 16000;
    private double jurosRotativo = 0.14;
    private double totalFinanciado;

    @Override
    public void setSaldo(double valor) {

            if (this.limite != this.limiteTotal){
                if((valor + this.limite) > this.limiteTotal){
                    double totalLimite = valor - this.limite;
                    double totalSaldo = valor - totalLimite;
                    this.limite += totalLimite;
                    this.saldo += totalSaldo;
                }else if((valor + this.limite) == this.limiteTotal){
                    this.limite = valor;
                }
            }
        this.saldo += valor;
    }

    @Override
    public void updateContadorOperacoes() {
        if(this.getContadorOperacoes() % 5 == 0){
            this.setSaldo(this.getSaldo() - 0.10);
        }
    }

    @Override
    public boolean saque(double valor) throws OperacaoException {
        this.updateContadorOperacoes();
        if(this.getSaldo() >= valor){
            double valorSaque = (this.getSaldo() - valor);
            this.setSaldo(valorSaque);
            this.setContadorOperacoes();
            return true;
        }else if(this.getSaldo() < valor){
            if(this.getLimite() > valor){
                double valorSaque = (this.getSaldo() - valor);
                this.setSaldo(valorSaque);
                double valorLimite = (this.getLimite() + this.getSaldo());
                this.setLimite(valorLimite);
                this.setContadorOperacoes();
                return true;
            }
        }
        throw new OperacaoException("Saldo inválido. Operação cancelada.");
    }

    @Override
    public boolean deposito(double valor) throws OperacaoException {
        if(valor > 0){
            this.setSaldo(valor);
            return true;
        }
        throw new OperacaoException("Valor inválido. Tente novamente.");
    }

    @Override
    public boolean transferencia(double valor, String destino) {
        return false;
    }


    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setLimiteTotal(double valor){
        this.limiteTotal = valor;
    }

    public double getLimiteTotal(){
        return this.limiteTotal;
    }

    public void calculaTotalFinanciado(){
        double total = (this.limite - this.limiteTotal) * this.jurosRotativo;
        this.totalFinanciado += total;
    }

    public void setTotalFinanciado(double valor){
        this.totalFinanciado = valor;
    }

    public double getTotalFinanciado(){
        return this.totalFinanciado;
    }
}
