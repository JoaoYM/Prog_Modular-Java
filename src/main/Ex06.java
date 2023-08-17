package src.main;

import java.util.Scanner;

public class Ex06 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sorteioOrganizacao(scan);

    }

    public static void sorteioOrganizacao(Scanner scanner) {

        System.out.print("Digite o primeiro prêmio da loteria federal (6 dígitos): ");
        int primeiroPremio = scanner.nextInt();

        System.out.print("Digite o segundo prêmio da loteria federal (6 dígitos): ");
        int segundoPremio = scanner.nextInt();

        int tresPrimeirosDigitosSegundoPremio = segundoPremio / 1000;
        int tresUltimosDigitosPrimeiroPremio = primeiroPremio % 1000;

        int numeroVencedor = (tresPrimeirosDigitosSegundoPremio * 1000) + tresUltimosDigitosPrimeiroPremio;

        System.out.println("Número vencedor da organização: " + numeroVencedor);

        scanner.close();
    }
}