import java.io.*;
import java.net.*;
import java.util.*;

public class ClientS {
    static class GreenPass implements Serializable {
        String tessera;
        Date scadenza;
        int servizio;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.printf("usage: %s <IPaddress> <TesseraSanitaria>\n", args[0]);
            System.exit(1);
        }

        String tesseraSanitaria = args[1];
        if (tesseraSanitaria.length() != 20) {
            System.err.println("Tessera Sanitaria non valida");
            System.exit(1);
        }

        // preparo greenPass
        GreenPass greenPass = new GreenPass();
        greenPass.tessera = tesseraSanitaria;
        greenPass.servizio = 0;

        try (Socket socket = new Socket(args[0], 1026)) {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(greenPass);
            System.out.println("Richiesta Inoltrata");

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            greenPass = (GreenPass) in.readObject();

            System.out.printf("Tessera Sanitaria: %s\n", greenPass.tessera);
            System.out.printf("Scadenza: %s\n", greenPass.scadenza.toString());
            if (greenPass.scadenza.after(new Date())) {
                System.out.println("Validita greenPass: VALIDO");
            } else {
                System.out.println("Validita greenPass: NON VALIDO");
            }

        } catch (UnknownHostException e) {
            System.err.println("Host sconosciuto: " + args[0]);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Errore I/O sulla connessione al server: " + args[0]);
            System.exit(1);
        } catch (ClassNotFoundException e) {
            System.err.println("Classe non trovata: " + e.getMessage());
            System.exit(1);
        }
        System.exit(0);
    }
}
