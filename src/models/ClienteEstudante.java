package models;

/**
 * Created by daviv on 19/06/2017.
 */
public class ClienteEstudante extends Cliente{


    public ClienteEstudante(String nome, String cpf, int year, int month, int day) {
        super(nome, cpf, year, month, day);
        this.conta = new ContaPoupanca();
    }

    @Override
    public void setConta() {
        if(this.conta == null){
            this.conta = new ContaPoupanca();
        }
    }

    @Override
    public double getLimite() {
        return 0;
    }
}
