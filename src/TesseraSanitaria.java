import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class TesseraSanitaria implements Serializable {
    private String tessera;
    private Boolean valido = false;
    private Date data;


    public TesseraSanitaria(String tessera, Boolean valido, Date data) {
        this.tessera = tessera;
        this.valido = valido;
        this.data = data;
    }
    public TesseraSanitaria(){

    }

    public String getTessera() {
        return tessera;
    }

    public void setTessera(String tessera) {
        this.tessera = tessera;
    }

    public Boolean getValido() {
        return valido;
    }

    public void setValido(Boolean valido) {
        this.valido = valido;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}