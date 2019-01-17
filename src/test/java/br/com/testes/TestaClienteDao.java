package br.com.testes;

import br.com.dao.GenericDao;
import br.com.model.Cliente;
import br.com.model.enuns.Status;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.TestCase.assertTrue;

public class TestaClienteDao {

    private Cliente c;
    private GenericDao<Cliente> dao = new GenericDao<>();

    @Test
    public void deveSalvarCliente(){
        c = new Cliente();
        Calendar dataCadasto = Calendar.getInstance();
        DateFormat formatDataCasdastro = DateFormat.getDateInstance(DateFormat.FULL);
        Date data = dataCadasto.getTime();
        formatDataCasdastro.format(data);

        c.setNome("Jiraia");
        c.setCpf("0800");
        c.setRg("00010");
        c.setDataNascimento(data);
        c.setDataCadastro(data);
        c.setStatus(Status.OK);
        c.setAtivo(true);
        c.setEmail("jiraia@gmail.com");
        //c.setTefefone1("(67)3344-9090");
        //c.setTefefone2("(67)3344-3030");
        c.setEndereco("Rua da paz 333");

        System.out.println(c.toString());
        System.out.println(c.getNome());

        assertTrue(dao.CadastrarCliente(c));
    }

}
