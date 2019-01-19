package br.com.dao;

import br.com.util.HibernateUtil;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class GenericDao<E> {

    private EntityManager em = HibernateUtil.getFactory();

    public boolean salvar(E entidade) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entidade);
        transaction.commit();
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<E> listar(Class<E> entidade) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        List<E> lista = em.createQuery("FROM " + entidade.getName()).getResultList();
        transaction.commit();
        return lista;
    }

    @SuppressWarnings("unchecked")
    public E buscarPorId(E entidade) {
        Object id = HibernateUtil.getPrimaryKey(entidade);
        entidade = (E) em.find(entidade.getClass(),id);
        return entidade;
    }

    public E atualizar(E entidade){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entidade);
        transaction.commit();
        return entidade;
    }

    public boolean deletar(E entidade){
        Object id = HibernateUtil.getPrimaryKey(entidade);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(entidade);
        transaction.commit();
        return true;
    }

    public EntityManager getEntityManager(){
        return em;
    }



}
