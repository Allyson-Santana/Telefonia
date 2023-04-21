import java.util.Date;

public class Chamada {
    private Date data;
    private int duracao;

    public Chamada(Date data,int duracao) {
        this.data = data;
        this.duracao = duracao;
    }

    public Date getData() {
        return this.data;
    }
    public int getDuracao() {
        return this.duracao;
    }

    @Override
    public String toString() {
        return "A chamada foi feita em "+this.data+" com duração de "+this.duracao+" Minutes";
    }

}
