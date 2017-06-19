package models;

/**
 * Created by daviv on 19/06/2017.
 */
public abstract class Conta {

    protected String numero;
    protected double saldo;
    protected int id;
    protected double senha;
    protected int contadorOperacoes = 0;

    public Conta(){
        this.id = (int) (1 + (Math.random() * 10000));
    }

    public abstract void setSaldo(double valor);

    public void setContadorOperacoes(){
        contadorOperacoes++;
    }

    public int getContadorOperacoes(){
        return this.contadorOperacoes;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean auth(double senha){
        if(senha == this.senha){
            return true;
        }
        return false;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
