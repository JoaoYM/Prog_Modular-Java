package src.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex12 extends Ex04 {

    public static void main(String[] args) {
        switchPhraseFile();
    }

    public static void switchPhraseFile() {
        try {
            Scanner fileScanner = new Scanner(new File("frases.txt"));

            while (fileScanner.hasNextLine()) {
                String frase = fileScanner.nextLine();
                if (frase.equalsIgnoreCase("fim")) {
                    break;
                }
                String fraseInvertida = inverterFrase(frase);
                System.out.println("Frase invertida: " + fraseInvertida);
            }

            System.out.println("Programa encerrado.");
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
