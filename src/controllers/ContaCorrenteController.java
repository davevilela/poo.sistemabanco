package controllers;

import exceptions.ClienteException;
import exceptions.LoginException;
import exceptions.OperacaoException;
import models.Cliente;
import models.ClientePremium;
import models.Conta;
import models.ContaCorrente;


public class ContaCorrenteController implements IContaController {

    private IClientesController cc = ClientesController.getInstancia();
    private ClientePremium cliente;
    private ContaCorrente conta;

    public ContaCorrenteController(String username, String psswrd) throws LoginException, ClienteException {
        cliente = (ClientePremium) cc.logInCliente(username, psswrd);
        conta = (ContaCorrente) cliente.getConta();
    }

    @Override
    public boolean saque(double valor) throws OperacaoException {
        if(conta.getContadorOperacoes() % 5 == 0){
            conta.setSaldo(conta.getSaldo() - 0.10);
        }

        if(conta.getSaldo() >= valor){
            double valorSaque = (conta.getSaldo() - valor);
            conta.setSaldo(valorSaque);
            conta.setContadorOperacoes();
            return true;
        }else if(conta.getSaldo() < valor){
            if(conta.getLimite() > valor){
                double valorSaque = (conta.getSaldo() - valor);
                conta.setSaldo(valorSaque);
                double valorLimite = (conta.getLimite() + conta.getSaldo());
                conta.setLimite(valorLimite);
                conta.setContadorOperacoes();
                return true;
            }
        }
        throw new OperacaoException("Saldo inválido. Operação cancelada.");
    }

    @Override
    public boolean transferencia(double valor, String destino) throws OperacaoException, ClienteException {
        Cliente x = cc.procurarCliente(destino);
        if(x == null) throw new ClienteException("Destinatário não encontrado");

        //cobrança de taxa por operação
        if(conta.getContadorOperacoes() % 5 == 0){
            conta.setSaldo(conta.getSaldo() - 0.10);
            conta.setSaldo(conta.getSaldo() + valor);
        }

        //efetuando a transferencia
        if(conta.getSaldo() >= valor){
            double valorTransferencia = (conta.getSaldo() - valor);
            conta.setSaldo(valorTransferencia);
            x.getConta().setSaldo(valor);
            conta.setContadorOperacoes();
            return true;
        }else if(conta.getSaldo() < valor){
            if(conta.getLimite() > valor){
                double valorTransferencia = (conta.getSaldo() - valor);
                conta.setSaldo(valorTransferencia);
                double valorLimite = (conta.getLimite() + conta.getSaldo());
                conta.setLimite(valorLimite);
                x.getConta().setSaldo(valor);
                conta.setContadorOperacoes();
                return true;

            }throw new OperacaoException("Limite insuficiente. Operação cancelada.");
        }
        conta.setContadorOperacoes();
        conta.setSaldo(conta.getSaldo() + valor);
        throw new OperacaoException("Saldo inválido. Operação cancelada.");
    }

    @Override
    public boolean deposito(double valor) throws OperacaoException {
        if(valor > 0){
            conta.setSaldo(valor);
            return true;
        }
        throw new OperacaoException("Valor inválido. Tente novamente.");
    }

    @Override
    public void encerraOperacao() {
        this.conta = null;
        this.cliente = null;
    }

    @Override
    public void setConta(String username, String psswrd) throws LoginException, ClienteException {
        cliente = (ClientePremium) cc.logInCliente(username, psswrd);
        conta = (ContaCorrente) cliente.getConta();
    }
}
