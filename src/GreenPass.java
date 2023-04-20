import java.time.LocalDateTime;

public class GreenPass {
    String tessera;
    int servizio;
    LocalDateTime scadenza;

    public GreenPass(String tessera, int servizio, LocalDateTime scadenza) {
        this.tessera = tessera;
        this.servizio = servizio;
        this.scadenza = scadenza;
    }
}

