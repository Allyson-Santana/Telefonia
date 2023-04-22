import java.util.Scanner;

public class Menu {
   public static void exibirMenu() {
       Scanner scanner = new Scanner(System.in);
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
               break;
           case 2:
               System.out.println("Listar assinantes...");
               break;
           case 3:
               System.out.println("Fazer chamada...");
               break;
           case 4:
               System.out.println("Fazer recarga...");
               break;
           case 5:
               System.out.println("Imprimir faturas...");
               break;
           case 6:
               System.out.println("Sair do programa...");
               break;
       }
   }
}
