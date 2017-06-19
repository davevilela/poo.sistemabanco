package models;

/**
 * Created by daviv on 19/06/2017.
 */
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

    public void setLimiteTotal(double valor){
        this.limiteTotal = valor;
    }

    public double getLimiteTotal(){
        return this.limiteTotal;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
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
