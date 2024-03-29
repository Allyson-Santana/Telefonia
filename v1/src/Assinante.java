public class Assinante {
    private long cpf;
    private String nome;
    private int nummero;
    protected int numChamadas = 0;

    protected Chamada[] chamadas;
    
    public Assinante(long cpf, String nome, int numero) {
        this.cpf = cpf;
        this.nome = nome;
        this.nummero = numero;
        this.chamadas = new Chamada[5];
    }

    public long getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return
                "  Cpf: "+this.cpf+"\n" +
                "  Nome: " +this.nome+"\n" +
                "  Numero: "+this.nummero;
    }
}
