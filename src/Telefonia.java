public class Telefonia {
    private int numPrePagos;
    private int numPosPagos;

    public Telefonia() {}
    public void cadstrarAssinante() {}
    public void listarAssinante() {}
    public void fazerChamada() {}
    public void fazerRecarga() {}
    private PrePago localizarPrePago(long cpf) {return new PrePago(1 ,"nome",0);}
    private PosPago localizarPosPago(long cpf) {return new PosPago(1 ,"nome",0, 1f);}
    public void implimirFaturas() {}

    public static void main(String[] args) {
        System.out.println("Welcome The Telefonia");
        Menu.exibirMenu();
    }

}
