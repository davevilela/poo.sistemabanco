package repositorio;

import exceptions.ClienteException;
import models.Cliente;

/**
 * Created by daviv on 22/06/2017.
 */
public interface IRepositorioCliente {

    public void inserirCliente(Cliente c);
    public Cliente procurarCliente(String username);
    public void removerCliente(Cliente c);
    public boolean clienteExists(String username);
}
