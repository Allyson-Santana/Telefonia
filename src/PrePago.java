import java.util.Date;

public class PrePago extends Assinante {
    private float creditos;
    private int numRecargas;

    private Recarga[] recargas;

    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.recargas = new Recarga[5];
    }

    public void recarregar(Date data, float valor) {}

    public float fazerChamada(Date data, int duracao) {return 1f;}

    public void imprimirFatura(int mes) {}
}
