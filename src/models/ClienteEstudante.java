package models;


public class ClienteEstudante extends Cliente{



    public ClienteEstudante(String nome, String cpf, int year, int month, int day) {
        super(nome, cpf, year, month, day);
        this.conta = new ContaPoupanca();
    }

    @Override
    public Conta getConta() {
        return (ContaPoupanca) this.conta;
    }


}
