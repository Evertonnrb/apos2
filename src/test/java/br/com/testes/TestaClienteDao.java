package br.com.testes;

import br.com.dao.ClienteDao;
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
    ClienteDao clienteDao = new ClienteDao();

    @Test
    public void deveSalvarCliente() {
        Calendar dataCadasto = Calendar.getInstance();
        DateFormat formatDataCasdastro = DateFormat.getDateInstance(DateFormat.FULL);
        Date data = dataCadasto.getTime();
        formatDataCasdastro.format(data);

        c = new Cliente();
        c.setNome("teste delete");
        c.setCpf("delete");
        c.setRg("delete");
        c.setDataNascimento(data);
        c.setDataCadastro(data);
        c.setStatus(Status.ATRASADO);
        c.setAtivo(true);
        c.setEndereco("delete");
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

    @Test
    public void deveBuscarPeloId(){
        c = new Cliente();
        c.setId(1L);
        c = clienteDao.buscarPorId(c);
        assertNotNull(c);
        System.out.println(c);
    }

    @Test
    public void deveAtaulizar(){
        c = new Cliente();
        c.setId(1L);
        c = clienteDao.buscarPorId(c);
        c.setNome("EL  MARADONA");
        c.setCpf("0022");
        c.setRg("32193");
        assertNotNull(clienteDao.atualizar(c));
        System.out.println(c.toString());
    }


    @Test
    public void deveBuscarPeloNome(){
        String nome = "Thierry Henry";
        assertNotNull(clienteDao.buscarPorNome(nome));
        System.out.println(clienteDao.buscarPorNome(nome));
    }

    @Test
    public void deveDeletarEntidade(){
        c = new Cliente();
        c.setId(7L);
        c = clienteDao.buscarPorId(c);
        assertTrue(clienteDao.deletar(c));

    }

}
