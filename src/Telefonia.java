public class Telefonia {
    private int numPrePagos;
    private int numPosPagos;

    public Telefonia() {}

    /** O sistema deverá solicitar o tipo de assinante, pré-pago ou pós-pago.
     Depois solicitar os dados do assinante específico; */
    public void cadastrarAssinante() {}

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
    public void sairDoPrograma() {}

    private PrePago localizarPrePago(long cpf) {return new PrePago(1 ,"nome",0);}

    private PosPago localizarPosPago(long cpf) {return new PosPago(1 ,"nome",0, 1f);}

    public static void main(String[] args) {
        System.out.println("Welcome The Telefonia");
        Menu.exibirMenu();
    }

}
