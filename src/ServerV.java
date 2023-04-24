import java.net.*;
import java.io.*;
public class ServerV {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5101);
        Socket s = ss.accept();
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

        // PROBLEMA = IL SERVER NON RIESCE A LEGGERE LE TESSERE DA "CENTRO VACCINALE"
            TesseraSanitaria ts1 = (TesseraSanitaria) ois.readObject();
            TesseraSanitaria ts2 = (TesseraSanitaria) ois.readObject();
            TesseraSanitaria ts3 = (TesseraSanitaria) ois.readObject();

            System.out.println(ts1.getTessera());
            System.out.println(ts1.getValido());
            System.out.println(ts1.getData());
            s.close();

    }
}
