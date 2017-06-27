package models;

import controllers.IContaController;
import util.Date;


public abstract class Cliente {

    private String nome;
    private String cpf;
    private Endereco endereco;
    private int id;
    private Date dataNascimento;
    protected Conta conta;
    private String userName;
    public String tipoConta;

    public Cliente(String nome, String cpf, int year, int month, int day){
        this.dataNascimento = new Date(year, month, day);
        this.nome = nome;
        this.cpf = cpf;
        this.id = (int) (1 + (Math.random() * 100001));
    }


    public abstract Conta getConta();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    public void setDataNascimento(int year, int month, int day) {
        this.dataNascimento.setDate(year, month, day);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }
}

