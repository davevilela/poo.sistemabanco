package models;

import util.Date;

/**
 * Created by daviv on 19/06/2017.
 */
public abstract class Cliente {

    private String nome;
    private String cpf;
    private int id;
    private double limite;
    private Date dataNascimento;
    protected Conta conta;
    private String userName;


    public Cliente(String nome, String cpf, int year, int month, int day){
        this.dataNascimento = new Date(year, month, day);
        this.nome = nome;
        this.cpf = cpf;
        this.id = (int) (1 + (Math.random() * 10001));
    }

    public void setDataNascimento(int year, int month, int day) {
        this.dataNascimento.setDate(year, month, day);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public abstract void setConta();

    public int getId() {
        return this.id;
    }

    public abstract double getLimite();


    public Date getDataNascimento() {
        return dataNascimento;
    }
}
