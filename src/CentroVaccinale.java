import java.net.*;
import java.io.*;


public class CentroVaccinale {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5001);
        Socket s = ss.accept();
        System.out.println("Client connesso");
    }
}
