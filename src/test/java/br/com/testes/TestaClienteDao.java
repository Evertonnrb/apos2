package br.com.testes;

import br.com.dao.GenericDao;
import br.com.model.Cliente;
import br.com.model.Contato;
import br.com.model.enuns.Status;
import org.junit.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class TestaClienteDao {

    Cliente c;
    Contato contato;
    GenericDao<Cliente> clienteDao = new GenericDao<>();
    GenericDao<Contato> contatoGenericDao = new GenericDao<>();

    @Test
    public void deveSalvarCliente() {
        Calendar dataCadasto = Calendar.getInstance();
        DateFormat formatDataCasdastro = DateFormat.getDateInstance(DateFormat.FULL);
        Date data = dataCadasto.getTime();
        formatDataCasdastro.format(data);

        c = new Cliente();
        c.setNome("Zinedine Zidane");
        c.setCpf("001");
        c.setRg("32100");
        c.setDataNascimento(data);
        c.setDataCadastro(data);
        c.setStatus(Status.BLOQUEADO);
        c.setAtivo(true);
        c.setEndereco("Rua dos golaçes 33");
        assertTrue(clienteDao.salvar(c));
    }

    @Test
    public void deveListarUsuarios(){
        List<Cliente> clientes = clienteDao.listar(Cliente.class);
        for(Cliente c : clientes){
            System.out.println(c.getNome()+""+c.toString());
        }
        assertNotNull(clientes);
    }




}
