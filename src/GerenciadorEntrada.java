import java.util.Scanner;

public class GerenciadorEntrada {
    private static GerenciadorEntrada instancia;
    private Scanner scanner;

    private GerenciadorEntrada() {
        instanceScanner();
    }

    public void instanceScanner() {
        if (scanner == null) {
            this.scanner = new Scanner(System.in);
        }
    }

    public static GerenciadorEntrada getInstancia() {
        if (instancia == null) {
            instancia = new GerenciadorEntrada();
        }
        return instancia;
    }

    public EnumClassificacaoAssinantes solicitarTipoAssinante() {
        System.out.println("Digite o tipo de assinante (PREPAGO ou POSPAGO): ");
        EnumClassificacaoAssinantes classificaçãoAssinantes = null;
        boolean entradaValida = false;

        do {
            String input = scanner.nextLine().toUpperCase();
            try {
                classificaçãoAssinantes = EnumClassificacaoAssinantes.valueOf(input);
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Valor inválido. Digite PREPAGO ou POSPAGO: ");
            }
        } while (!entradaValida);

        return classificaçãoAssinantes;
    }

    public Long solicitarCpfAssinante() {
        System.out.println("Digite o CPF do assinante: ");
        scanner.nextLine();
        Long value = scanner.nextLong();
        return value;
    }

    public float solicitarValorAssinaturaPospago() {
        System.out.println("Digite o valor da assinatura do Pospago: ");
        float value = scanner.nextFloat();
        scanner.nextLine();
        return value;
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

    public int getOpcao() {
        System.out.print("\nDigite sua opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public void closeScanner() {
        scanner.close();
    }

}
