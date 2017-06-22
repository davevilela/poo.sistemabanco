package models;

/**
 * Created by daviv on 22/06/2017.
 */
public interface IConta {

    public void setSaldo(double valor);

    public void setContadorOperacoes();

    public int getContadorOperacoes();

    public double getSaldo();

    public boolean auth(String senha);

    public String getNumero();

    public void setNumero(String numero);


}
