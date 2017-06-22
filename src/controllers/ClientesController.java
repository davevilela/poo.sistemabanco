package controllers;

import exceptions.ClienteException;
import exceptions.LoginException;
import models.*;
import repositorio.IRepositorioCliente;
import repositorio.RepositorioCliente;

public class ClientesController implements IClientesController {

    private static ClientesController instancia;
    IRepositorioCliente repositorio;

    private ClientesController(){
        repositorio = RepositorioCliente.getInstance();
    }

    public static ClientesController getInstancia(){
        if(instancia == null){
            instancia = new ClientesController();
            return instancia;
        }
        return instancia;
    }

    @Override
    public void inserirCliente(Cliente c) throws ClienteException {
        Cliente x = repositorio.procurarCliente(c.getUserName());
        if(x == null){
            throw new ClienteException("Usuário já existe! Digite outro user Name.");
        }else{
            repositorio.inserirCliente(c);
        }
    }

    @Override
    public Cliente procurarCliente(String username) throws ClienteException {
        Cliente c = repositorio.procurarCliente(username);
        if(c == null){
            throw new ClienteException("Cliente não encontrado.");
        }else{
            return c;
        }
    }

    @Override
    public Cliente logInCliente(String userName, String psswrd) throws LoginException, ClienteException {
        Cliente c = repositorio.procurarCliente(userName);
        if(c == null) {
            throw new ClienteException("Usuário não encontrado");
        }else if(c != null){
            boolean auth = c.getConta().auth(psswrd);
            if(auth){
                return c;
            }
            throw new LoginException("Senha Incorreta!");
        }
        throw new LoginException("Dados Incorretos!");
    }

    @Override
    public void removerCliente(Cliente c) throws ClienteException {
        Cliente x = repositorio.procurarCliente(c.getUserName());
        if(x == null){
            throw new ClienteException("Cliente inválido.");
        }else{
            repositorio.removerCliente(c);
        }
    }
}
