import java.util.Scanner;

public class GerenciadorEntrada {
    private Scanner scanner;

    public GerenciadorEntrada() {
        this.scanner = new Scanner(System.in);
    }

    public String solicitarTipoAssinante() {
        System.out.println("Digite o tipo de assinante (pre ou pos): ");
        return scanner.nextLine().toLowerCase();
    }

    public String solicitarCpfAssinante() {
        System.out.println("Digite o CPF do assinante: ");
        return scanner.nextLine();
    }

    public String[] solicitarDadosAssinante() {
        String[] dados = new String[3];
        System.out.println("Digite o nome do assinante: ");
        dados[0] = scanner.nextLine();
        System.out.println("Digite o endereço do assinante: ");
        dados[1] = scanner.nextLine();
        System.out.println("Digite o telefone do assinante: ");
        dados[2] = scanner.nextLine();
        return dados;
    }

    public String[] solicitarDadosChamada() {
        String[] dados = new String[2];
        System.out.println("Digite a data da chamada: ");
        dados[0] = scanner.nextLine();
        System.out.println("Digite a duração da chamada: ");
        dados[1] = scanner.nextLine();
        return dados;
    }

    public String[] solicitarDadosRecarga() {
        String[] dados = new String[2];
        System.out.println("Digite a data da recarga: ");
        dados[0] = scanner.nextLine();
        System.out.println("Digite o valor da recarga: ");
        dados[1] = scanner.nextLine();
        return dados;
    }

    public String solicitarMesFaturas() {
        System.out.println("Digite o mês das faturas: ");
        return scanner.nextLine();
    }
}
