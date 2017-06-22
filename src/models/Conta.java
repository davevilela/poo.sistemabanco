package models;


public abstract class Conta implements IConta {

    protected String numero;
    protected double saldo;
    protected int id;
    protected String senha;
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

    public boolean auth(String senha){
        if(this.senha.equals(senha)){
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
