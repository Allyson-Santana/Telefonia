import java.util.Date;

public class Recarga {
    private Date data;
    private float valor;

    public Recarga(Date data, float valor) {
        this.data = data;
        this.valor = valor;
    }
    public Date getData() {
        return this.data;
    }
    public float getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "A recarga foi feita em "+this.data+" no valor de "+this.valor;
    }
}
