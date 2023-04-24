import java.net.*;
import java.io.*;


public class CentroVaccinale {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5001);
        Socket s = ss.accept();
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        System.out.println("Client connesso");
        TesseraSanitaria ts = (TesseraSanitaria)ois.readObject();
        if (ts.getTessera().matches("Yikes")){
            System.out.println(ts.getTessera());
        }else {
            System.out.println("Tessera non letta");
        }
        ss.close();


    }
}
