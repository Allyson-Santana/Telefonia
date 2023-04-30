import java.util.Calendar;
import java.util.GregorianCalendar;

public class PrePago extends Assinante {
    private float creditos = 0f;
    private int numRecargas = 0;
    private Recarga[] recargas;

    public PrePago(long cpf, String nome, int numero) {
        super(cpf, nome, numero);
        this.recargas = new Recarga[5];
    }

    public void recarregar(GregorianCalendar data, float valor) {
        if (this.numRecargas >= this.recargas.length) {
            System.out.println("Assinannte com limite de recarga.");
            return;
        }
        this.recargas[this.numRecargas] = new Recarga(data, valor);
        this.creditos += valor;
        this.numRecargas++;

        System.out.println("creditos: " + this.creditos);
        System.out.println("numRecargas: " + this.numRecargas);
        System.out.println("Data: " + this.recargas[this.numRecargas-1].getData().getTime());
    }

    public Float fazerChamada(GregorianCalendar data, int duracao) {

        if (this.numChamadas >= this.chamadas.length) {
            System.out.println("Assinante com limite de chamadas.\n");
            return null;
        }

        if (this.creditos < (1.45 * duracao)) {
            System.out.println("Assinante nao possui creditos para completar a chamadas.");
            System.out.printf("Credito restate do assinante: %.2f\n", this.creditos);
            System.out.printf("Credito necessarrio para completa a chamada: %.2f\n\n", (1.45 * duracao));
            return null;
        }
        this.chamadas[this.numChamadas] = new Chamada(data, duracao);
        this.creditos -= (1.45) * duracao;
        this.numChamadas++;

        System.out.println("credito restate: " + this.creditos);
        System.out.println("numChamadas: " + this.numChamadas);
        System.out.println("Data Chamada: " + this.chamadas[this.numChamadas-1].getData().getTime());
        System.out.println("Duracao Chamada: " + this.chamadas[this.numChamadas-1].getDuracao());

        return creditos;
    }

    public void imprimirFaturas(int mes) {
        System.out.println("===============================");

        System.out.println("Dados Pessoais...");
        System.out.println(this.toString());

        System.out.print("\nChamadas...");
        for (int i = 0; i < this.numChamadas; i++) {
            if (mes == this.chamadas[i].getData().get(Calendar.MONTH)) {
                System.out.println("\n  Data: " + this.chamadas[i].getData().getTime());
                System.out.println("  Duracao: " + this.chamadas[i].getDuracao());
                System.out.println("  valorChamada:" + this.chamadas[i].getDuracao() * 1.45);
            } else {
                System.out.print("  Nenhuma...");
            }
        }

        System.out.print("\nRecarrega...");
        for (int i = 0; i < this.numRecargas; i++) {
            if (mes == this.recargas[i].getData().get(Calendar.MONTH)) {
                System.out.println("\n  Data: " + this.recargas[i].getData().getTime());
                System.out.println("  Valor da recarrega: " + this.recargas[i].getValor());
            } else {
                System.out.print("  Nenhuma...");
            }
        }

        System.out.println("\n");
    }
}
