import java.sql.Array;

public class Telefonia {
    private int numPrePagos;
    private int numPosPagos;

    private PrePago prePago;
    private PosPago posPago;

    public Telefonia() {}

    /** O sistema deverá solicitar o tipo de assinante, pré-pago ou pós-pago.
     Depois solicitar os dados do assinante específico; */
    public void cadastrarAssinante() {
        GerenciadorEntrada gerenciadorEntrada = GerenciadorEntrada.getInstancia();
        String cpfAssinante = gerenciadorEntrada.solicitarCpfAssinante();
        EnumClassificacaoAssinantes tipoAssinante = gerenciadorEntrada.solicitarTipoAssinante();
        String[] dadosAssinante = gerenciadorEntrada.solicitarDadosAssinante();

        if (tipoAssinante.equals(EnumClassificacaoAssinantes.POSPAGO)) {
            float assinatura = gerenciadorEntrada.solicitarValorAssinaturaPospago();
            this.posPago = new PosPago(
                    Long.valueOf(cpfAssinante).longValue(),
                    dadosAssinante[0],
                    Integer.valueOf(dadosAssinante[2]).intValue(),
                    assinatura
            );
            this.numPosPagos++;
        } else if (tipoAssinante.equals(EnumClassificacaoAssinantes.PREPAGO)) {
            this.prePago = new PrePago(
                    Long.valueOf(cpfAssinante).longValue(),
                    dadosAssinante[0],
                    Integer.valueOf(dadosAssinante[2]).intValue()
            );
            this.numPrePagos++;
        }

        System.out.println(cpfAssinante);
        System.out.println(tipoAssinante);
        System.out.println(dadosAssinante[0].toString());
        System.out.println(dadosAssinante[1].toString());
        System.out.println(dadosAssinante[2].toString());

    }

    /** O sistema deverá listar os dados de todos os assinantes pré-pagos e
     pós-pagos cadastrados; */
    public void listarAssinante() {}

    /** O sistema deverá solicitar o tipo de assinante e seu CPF. Depois solicitar os
     dados da chamada, data e duração; */
    public void fazerChamada() {}

    /** O sistema deverá solicitar o CPF de um assinante pré-pago. Depois solicitar a
     data e o valor da recarga;*/
    public void fazerRecarga() {}

    /** O sistema deverá solicitar o mês e imprimir todas as faturas dos assinantes
     pré-pagos e pós-pagos;*/
    public void implimirFaturas() {}

    /** encerra a execução do programa. */
    public void sairDoPrograma() {
        GerenciadorEntrada gerenciadorEntrada = GerenciadorEntrada.getInstancia();
        gerenciadorEntrada.closeScanner();
        System.exit(0);
    }

    private PrePago localizarPrePago(long cpf) {return new PrePago(1 ,"nome",0);}

    private PosPago localizarPosPago(long cpf) {return new PosPago(1 ,"nome",0, 1f);}

    public static void main(String[] args) {
        System.out.println("Welcome The Telefonia");
        Menu menu = new Menu();
        menu.exibirMenu();
    }

}
