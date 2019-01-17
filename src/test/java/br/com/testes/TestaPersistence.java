package br.com.testes;

import org.junit.Test;

import javax.persistence.Persistence;

public class TestaPersistence {

    @Test
    public void deveGerarTAbelas() {
        Persistence.createEntityManagerFactory("default");
    }
}
