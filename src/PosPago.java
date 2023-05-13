import java.util.Calendar;
import java.util.GregorianCalendar;

public class PosPago extends Assinante {
    private float assinatura;

    public PosPago(long cpf, String nome, int numero, float assinatura) {
        super(cpf, nome, numero);
        this.assinatura = assinatura;
    }

    public void fazerChamada(GregorianCalendar data, int duracao) {
        if (this.numChamadas >= this.chamadas.length) {
            System.out.println("Assinante com limite de chamadas.");
            return;
        }

        this.chamadas[this.numChamadas] = new Chamada(data, duracao);
        this.numChamadas++;

        System.out.println("Valor da assinatura: " + this.assinatura);
        System.out.println("numChamadas: " + this.numChamadas);
        System.out.println("Data Chamada: " + this.chamadas[this.numChamadas-1].getData().getTime());
        System.out.println("Duracao Chamada: " + this.chamadas[this.numChamadas-1].getDuracao());
    }

    public void imprimirFaturas(int mes) {
        float valorChamadaTotal = 0f;
        float valorChamada = 0f;
        System.out.println("===============================");

        System.out.println("Dados Pessoais...");
        System.out.println(this.toString());

        System.out.print("\nChamadas...");
        for (int i = 0; i < this.numChamadas; i++) {
            if (mes == this.chamadas[i].getData().get(Calendar.MONTH)) {
                System.out.println("\n  Data: " + this.chamadas[i].getData().getTime());
                System.out.println("  Duracao: " + this.chamadas[i].getDuracao());
                valorChamada = (float) (this.chamadas[i].getDuracao() * 1.04);
                System.out.println("  valorChamada: " + valorChamada);
                valorChamadaTotal += valorChamada;
                if (valorChamadaTotal > this.assinatura)
                    this.assinatura = valorChamadaTotal;
            } else {
                System.out.println("  Nenhuma...");
            }
        }
        System.out.print("\n  Valor final da assinatura: " +  this.assinatura);

        System.out.println("\n");
    }
}
