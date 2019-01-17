package br.com.testes;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TestaSelecaoDatas {

    @Test
    public void testarDatas(){
        Calendar d = Calendar.getInstance();
        Date data = d.getTime();
        DateFormat dt = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("data 1 ============= "+dt.format(data));
        DateFormat dt1 = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("data 1 ============= "+dt.format(data));
        DateFormat dt2 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("data 1 ============= "+dt.format(data));
    }

    @Test
    public void testaConversaoDatas() throws ParseException {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat dateFormat = DateFormat.getDateInstance();

        Date dt2 = dateFormat.parse("12/0/1994");
        System.out.println("Data formatada 1 == "+dt2 );

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data formatada 2 == "+dt.format(data));

        System.out.println("Data convertida == "+dt.parse("02/08/1908"));

    }

    @Test
    public void testaDateTimeFormater(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("23/11/1999",formato);
        System.out.println(formato.format(date));
    }

    @Test
    public void testaDateDataNascimento() throws ParseException{
        SimpleDateFormat fomater = new SimpleDateFormat("dd-MM-yyyy");
        String data = "12-07-1999";
        Date dataNascimento = fomater.parse(data);
        System.out.println(dataNascimento);
        System.out.println(fomater.parse(data));


    }
}
