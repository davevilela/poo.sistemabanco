package repositorio;

import exceptions.ClienteException;
import models.Cliente;

/**
 * Created by daviv on 22/06/2017.
 */
public interface IRepositorioCliente {

    public void inserirCliente(Cliente c) throws ClienteException;
    public Cliente procurarCliente(String username) throws ClienteException;
    public void removerCliente(Cliente c) throws ClienteException;
}
