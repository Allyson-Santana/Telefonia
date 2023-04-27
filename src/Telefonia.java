import java.sql.Array;

public class Telefonia {
    private int numPrePagos;
    private int numPosPagos;

    private PrePago[] prePago;
    private PosPago[] posPago;

    public Telefonia() {
        this.posPago = new PosPago[5];
        this.prePago = new PrePago[5];
    }

    /** O sistema deverá solicitar o tipo de assinante, pré-pago ou pós-pago.
     Depois solicitar os dados do assinante específico; */
    public void cadastrarAssinante() {
        GerenciadorEntrada gerenciadorEntrada = GerenciadorEntrada.getInstancia();
        EnumClassificacaoAssinantes tipoAssinante = gerenciadorEntrada.solicitarTipoAssinante();

        boolean is_pospago = tipoAssinante.equals(EnumClassificacaoAssinantes.POSPAGO);
        boolean is_prepago = tipoAssinante.equals(EnumClassificacaoAssinantes.POSPAGO);

        if (is_pospago) {
            if (numPosPagos >= this.posPago.length) {
                System.out.println("Limite de Assinanntes Pospagos");
                return;
            }
            float assinatura = gerenciadorEntrada.solicitarValorAssinaturaPospago();
            Long cpfAssinante = gerenciadorEntrada.solicitarCpfAssinante();
            String[] dadosAssinante = gerenciadorEntrada.solicitarDadosAssinante();
            this.posPago[this.numPosPagos] = new PosPago(
                    cpfAssinante,
                    dadosAssinante[0],
                    Integer.valueOf(dadosAssinante[2]).intValue(),
                    assinatura
            );
            this.numPosPagos++;
        }

        if (is_prepago) {
            if (numPrePagos >= this.prePago.length) {
                System.out.println("Limite de Assinanntes Pospagos");
                return;
            }
            Long cpfAssinante = gerenciadorEntrada.solicitarCpfAssinante();
            String[] dadosAssinante = gerenciadorEntrada.solicitarDadosAssinante();
            this.prePago[this.numPrePagos] = new PrePago(
                    cpfAssinante,
                    dadosAssinante[0],
                    Integer.valueOf(dadosAssinante[2]).intValue()
            );
            this.numPrePagos++;
        }

    }

    /** O sistema deverá listar os dados de todos os assinantes pré-pagos e
     pós-pagos cadastrados; */
    public void listarAssinante() {
        for (PosPago pos: this.posPago) {
            System.out.println("POSPAGOS\n");
            if (pos == null) break;
            System.out.println(pos.toString());
        }
        for (PrePago pre: this.prePago) {
            System.out.println("PREPAGOS\n");
            if (pre == null)   break;
            System.out.println(pre.toString());
        }
    }

    /** O sistema deverá solicitar o tipo de assinante e seu CPF. Depois solicitar os
     dados da chamada, data e duração; */
    public void fazerChamada() {
        GerenciadorEntrada gerenciadorEntrada = GerenciadorEntrada.getInstancia();
        Long cpfAssinante = gerenciadorEntrada.solicitarCpfAssinante();
        PosPago assinante_pos = localizarPosPago(cpfAssinante);

        if (assinante_pos != null) {
            // code...
            String[] dados = gerenciadorEntrada.solicitarDadosChamada();
            System.out.println(dados[0]);
            System.out.println(dados[1]);
        } else {
            System.out.println("Assinante Não localizado...");
        }
    }

    /** O sistema deverá solicitar o CPF de um assinante pré-pago. Depois solicitar a
     data e o valor da recarga;*/
    public void fazerRecarga() {
        GerenciadorEntrada gerenciadorEntrada = GerenciadorEntrada.getInstancia();
        Long cpfAssinante = gerenciadorEntrada.solicitarCpfAssinante();
        PrePago assinante_pre = localizarPrePago(cpfAssinante);

        if (assinante_pre != null) {
            // code...
            String[] dados = gerenciadorEntrada.solicitarDadosRecarga();
            System.out.println(dados[0]);
            System.out.println(dados[1]);
        } else {
            System.out.println("Assinante Não localizado...");
        }

    }

    /** O sistema deverá solicitar o mês e imprimir todas as faturas dos assinantes
     pré-pagos e pós-pagos;*/
    public void implimirFaturas() {}

    /** encerra a execução do programa. */
    public void sairDoPrograma() {
        GerenciadorEntrada gerenciadorEntrada = GerenciadorEntrada.getInstancia();
        gerenciadorEntrada.closeScanner();
        System.exit(0);
    }

    private PrePago localizarPrePago(long cpf) {
        PrePago pre = null;

        for (int i = 0; i < this.numPrePagos; i++) {
            if (this.prePago[i].getCpf() == cpf) {
                pre = this.prePago[i];
                break;
            }
        }

        return pre;
    }

    private PosPago localizarPosPago(long cpf) {
        PosPago pos = null;

        for (int i = 0; i < this.numPosPagos; i++) {
            if (this.posPago[i].getCpf() == cpf) {
                pos = this.posPago[i];
                break;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        System.out.println("Welcome The Telefonia");
        Menu menu = new Menu();
        menu.exibirMenu();
    }

}
