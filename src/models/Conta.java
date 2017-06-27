package models;


import exceptions.ClienteException;
import exceptions.OperacaoException;

public abstract class Conta{

    protected int numero;
    protected double saldo;
    protected int id;
    protected String senha;
    protected int contadorOperacoes = 0;

    public Conta(){
        this.id = (int) (1 + (Math.random() * 10000));
        this.numero = (int) (1 + (Math.random() * 10000));
    }

    public abstract void setSaldo(double valor);

    public void setContadorOperacoes(){
        contadorOperacoes++;
    }

    public int getContadorOperacoes(){
        return this.contadorOperacoes;
    }

    public abstract void updateContadorOperacoes();

    public double getSaldo() {
        return saldo;
    }

    public boolean auth(String senha){
        if(this.senha.equals(senha)){
            return true;
        }
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public void setSenha(String psswrd){
        this.senha = psswrd;
    }

    public abstract boolean saque(double valor) throws OperacaoException;
    public abstract boolean deposito(double valor) throws OperacaoException;
    public abstract boolean transferencia(double valor, String destino) throws OperacaoException, ClienteException;


}
