package controllers;


import exceptions.ClienteException;
import exceptions.LoginException;
import models.Cliente;
import models.Conta;

public interface IClientesController {

    public void inserirCliente(Cliente c) throws ClienteException;
    public void removerCliente(Cliente c) throws ClienteException;
    public Cliente procurarCliente(String username) throws ClienteException;
    public Cliente logInCliente(String userName, String psswrd) throws LoginException, ClienteException;
    public boolean clienteExists(String username);
}
