package models;


public class ClientePremium extends Cliente {


    public ClientePremium(String nome, String cpf, int year, int month, int day) {
        super(nome, cpf, year, month, day);
        this.conta = new ContaCorrente();
        tipoConta = "premium";
    }

    @Override
    public Conta getConta() {
       return (ContaCorrente) this.conta;
    }


}
