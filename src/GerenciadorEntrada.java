import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

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
                System.out.println("Valor inválido.\nDigite PREPAGO ou POSPAGO: ");
            }
        } while (!entradaValida);

        return classificaçãoAssinantes;
    }

    public int solicitarMesFaturas() {
        System.out.println("Digite o nome do mes: ");
        EnumMonth mes = null;
        boolean entradaValida = false;

        do {
            String input = scanner.nextLine().toUpperCase();
            try {
                mes = EnumMonth.valueOf(input);
                entradaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Valor inválido. \nDigite o nome do mes: ");
            }
        } while (!entradaValida);

        return mes.ordinal();
    }

    public Long solicitarCpfAssinante() {
        System.out.println("Digite o CPF do assinante: ");
        Long value = scanner.nextLong();
        scanner.nextLine();
        return value;
    }

    public float solicitarValorAssinaturaPospago() {
        System.out.println("Digite o valor da assinatura do Pospago: ");
        float value = scanner.nextFloat();
        scanner.nextLine();
        return value;
    }

    public String[] solicitarDadosAssinante() {
        String[] dados = new String[2];
        System.out.println("Digite o nome do assinante: ");
        dados[0] = scanner.nextLine();
        System.out.println("Digite o telefone do assinante: ");
        dados[1] = scanner.nextLine();
        return dados;
    }

    public GregorianCalendar solicitarData() {
        System.out.println("Digite a data (formato dd/MM/yyyy HH:mm:ss");
        String dataHoraStr = scanner.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        GregorianCalendar dataHora = new GregorianCalendar();

        try {
            Date dataHoraDate = sdf.parse(dataHoraStr);
            dataHora.setTime(dataHoraDate);
        } catch (ParseException e) {
            System.out.println("Data inválida");
            scanner.nextLine();
            dataHora = null;
        }

        return dataHora;
    }

    public float solicitarValorRecarga() {
        float valor = 0f;
        System.out.println("Digite o valor da recarga: ");
        valor = scanner.nextFloat();
        scanner.nextLine();
        return valor;
    }
    public int solicitarDuracaoChamada() {
        int duracao = 0;
        System.out.println("Digite a duracao da chamada em minutos: ");
        duracao = scanner.nextInt();
        scanner.nextLine();
        return duracao;
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
