import java.net.*;
import java.io.*;
public class ClientUtente {
    public static void main(String[] args) throws Exception {
        TesseraSanitaria ts = new TesseraSanitaria();
        Socket s = new Socket("localhost", 5001);
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ts.setTessera("Yikes");
        oos.writeObject(ts);
        System.out.println("Tessera inviata");
        s.close();
    }
}