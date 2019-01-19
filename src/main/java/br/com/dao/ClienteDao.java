package br.com.dao;

import br.com.model.Cliente;

public class ClienteDao extends GenericDao<Cliente>{

    public Cliente buscarPorNome(String nome){
        Cliente cliente = (Cliente) getEntityManager()
                .createNamedQuery("Cliente.buscarPorNome")
                .setParameter("nome",nome)
                .getSingleResult();
        return cliente;
    }

}
