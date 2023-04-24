import java.net.*;
import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class ClientUtente {

    /* Stiamo assumendo che la data di scadenza di un green pass è di 30 giorni. Il fine di questa scelta è per semplificare
     i controlli e l'esecuzione del programma. */
    public static void main(String[] args) throws Exception {
        TesseraSanitaria ts1 = new TesseraSanitaria();
        TesseraSanitaria ts2 = new TesseraSanitaria();
        TesseraSanitaria ts3 = new TesseraSanitaria();
        Socket s = new Socket("localhost", 5001);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

        // TESSERA 1

        ts1.setTessera("CN71B99NA");
        ts1.setValido(false);
        Date ts1Date = new Date(123, Calendar.JUNE,05);
        ts1.setData(ts1Date);
        oos.writeObject(ts1);

        // TESSERA 2

        ts2.setTessera("BC98L23PA");
        ts2.setValido(false);
        Date ts2Date = new Date(123, Calendar.FEBRUARY,24);
        ts2.setData(ts2Date);
        oos.writeObject(ts2);

        // TESSERA 3

        ts3.setTessera("PI54O96LA");
        ts3.setValido(false);
        Date ts3Date = new Date(123, Calendar.MAY,30);
        ts3.setData(ts3Date);
        oos.writeObject(ts3);
        System.out.println("Tessera inviata");

        s.close();
    }
}