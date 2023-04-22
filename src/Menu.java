import java.util.Scanner;

public class Menu {
   public static void exibirMenu() {
       Scanner scanner = new Scanner(System.in);
       Telefonia telefonia = new Telefonia();
       int opcao = 0;

       do {
           System.out.println("(1) Cadastrar assinante.");
           System.out.println("(2) Listar assinantes.");
           System.out.println("(3) Fazer chamada.");
           System.out.println("(4) Fazer recarga.");
           System.out.println("(5) Imprimir faturas.");
           System.out.println("(6) Sair do programa.");

           System.out.print("\nDigite sua opção: ");
           opcao = scanner.nextInt();
       } while(opcao < 1 && opcao > 6);

       scanner.close();

       switch (opcao) {
           case 1:
               System.out.println("Cadastrar assinante...");
               telefonia.cadastrarAssinante();
               break;
           case 2:
               System.out.println("Listar assinantes...");
               telefonia.listarAssinante();
               break;
           case 3:
               System.out.println("Fazer chamada...");
               telefonia.fazerChamada();
               break;
           case 4:
               System.out.println("Fazer recarga...");
               telefonia.fazerRecarga();
               break;
           case 5:
               System.out.println("Imprimir faturas...");
               telefonia.implimirFaturas();
               break;
           case 6:
               System.out.println("Sair do programa...");
               telefonia.sairDoPrograma();
               break;
       }
   }
}
