import java.net.*;
import java.io.*;


public class CentroVaccinale {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5001);
        Socket sServerV = new Socket("localhost", 5101);
        Socket s = ss.accept();
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        System.out.println("Client connesso");

            TesseraSanitaria ts1 = (TesseraSanitaria) ois.readObject();
            TesseraSanitaria ts2 = (TesseraSanitaria) ois.readObject();
            TesseraSanitaria ts3 = (TesseraSanitaria) ois.readObject();
            // LETTURA TESSERE

            System.out.println(ts1.getTessera());
            System.out.println(ts1.getValido());
            System.out.println(ts1.getData());

            System.out.println(ts2.getTessera());
            System.out.println(ts2.getValido());
            System.out.println(ts2.getData());

            System.out.println(ts3.getTessera());
            System.out.println(ts3.getValido());
            System.out.println(ts3.getData());
        // PROBLEMA = "CENTROVACCINALE" NON RIESCE A MANDARE UN OGGETTO RICEVUTO DA UN CLIENT
            oos.writeObject(ts1);
            oos.writeObject(ts2);
            oos.writeObject(ts3);


            s.close();
            sServerV.close();


    }
}
