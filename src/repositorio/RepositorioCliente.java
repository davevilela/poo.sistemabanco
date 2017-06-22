package repositorio;

import exceptions.ClienteException;
import models.Cliente;

import java.util.ArrayList;


public class RepositorioCliente implements IRepositorioCliente {

    private ArrayList<Cliente> clientes;
    private static RepositorioCliente instancia;

    public static RepositorioCliente getInstance(){
        if(instancia == null){
            instancia = new RepositorioCliente();
            return instancia;
        }
        return instancia;
    }

    private RepositorioCliente(){
        clientes = new ArrayList<Cliente>();
    }

    @Override
    public void inserirCliente(Cliente c) throws ClienteException {
        clientes.add(c);
    }

    @Override
    public Cliente procurarCliente(String username) throws ClienteException {
        for(Cliente c : clientes){
            if(c.getUserName().equals(username)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void removerCliente(Cliente c) throws ClienteException {
        clientes.remove(c);
    }
}
