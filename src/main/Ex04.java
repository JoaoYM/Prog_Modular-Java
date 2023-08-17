package src.main;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        switchPhrase(scan);
    }

    public static void switchPhrase(Scanner scanner) {
        String frase;
        do {
            System.out.print("Digite uma frase (ou 'fim' para encerrar): ");
            frase = scanner.nextLine();

            if (!frase.equalsIgnoreCase("fim")) {
                String fraseInvertida = inverterFrase(frase);
                System.out.println("Frase invertida: " + fraseInvertida);
            }
        } while (!frase.equalsIgnoreCase("fim"));

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    public static String inverterFrase(String frase) {
        StringBuilder fraseInvertida = new StringBuilder();
        for (int i = frase.length() - 1; i >= 0; i--) {
            fraseInvertida.append(frase.charAt(i));
        }
        return fraseInvertida.toString();
    }
}