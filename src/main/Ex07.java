package src.main;

import java.util.Scanner;

public class Ex07 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        multiplicacaoPorOnze(scan);
    }

    public static void multiplicacaoPorOnze(Scanner scanner) {
        System.out.print("Digite um número de 2 dígitos: ");
        int numero = scanner.nextInt();

        int primeiroDigito = numero / 10;
        int segundoDigito = numero % 10;

        int produto = primeiroDigito + segundoDigito;
        if (produto > 9) {
            primeiroDigito += produto / 10;
            produto %= 10;
        }

        int novoNumero = (primeiroDigito * 100) + (produto * 10) + segundoDigito;

        System.out.println("Resultado da multiplicação por 11: " + novoNumero);

        scanner.close();
    }
}