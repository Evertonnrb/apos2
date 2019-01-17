package br.com.dao;

import br.com.util.HibernateUtil;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDao<E> {

    private EntityManager em = HibernateUtil.getFactory();

    public  boolean CadastrarCliente(E entidade){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entidade);
        transaction.commit();
        return true;
    }

}
