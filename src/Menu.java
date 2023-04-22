import java.util.Scanner;

public class Menu {
   public static void exibirMenu() {
       Scanner scanner = new Scanner(System.in);
       Menu menu = new Menu();
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
               menu.cadastrarAssinante();
               break;
           case 2:
               System.out.println("Listar assinantes...");
               menu.listarAssinante();
               break;
           case 3:
               System.out.println("Fazer chamada...");
               menu.fazerChamada();
               break;
           case 4:
               System.out.println("Fazer recarga...");
               menu.fazerRecarga();
               break;
           case 5:
               System.out.println("Imprimir faturas...");
               menu.implimirFaturas();
               break;
           case 6:
               System.out.println("Sair do programa...");
               menu.sairDoPrograma();
               break;
       }
   }

    public void cadastrarAssinante() {
        /** O sistema deverá solicitar o tipo de assinante, pré-pago ou pós-pago.
         Depois solicitar os dados do assinante específico; */
    }

    public void listarAssinante() {
       /** O sistema deverá listar os dados de todos os assinantes pré-pagos e
        pós-pagos cadastrados; */
    }

    public void fazerChamada() {
       /** O sistema deverá solicitar o tipo de assinante e seu CPF. Depois solicitar os
        dados da chamada, data e duração; */
    }

    public void fazerRecarga() {
       /** O sistema deverá solicitar o CPF de um assinante pré-pago. Depois solicitar a
        data e o valor da recarga;*/
    }

    public void implimirFaturas() {
       /** O sistema deverá solicitar o mês e imprimir todas as faturas dos assinantes
        pré-pagos e pós-pagos;*/
    }

    public void sairDoPrograma() {
       /** encerra a execução do programa. */
    }

}
