package src.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex11 extends Ex08 {
    public static void main(String[] args) {
        validDataFile();
    }

    public static void validDataFile() {
        try {
            Scanner fileScanner = new Scanner(new File("datas.txt"));

            int numDatas = Integer.parseInt(fileScanner.nextLine());

            for (int i = 0; i < numDatas; i++) {
                String data = fileScanner.nextLine();
                if (validarData(data)) {
                    System.out.println("A data " + data + " é válida.");
                } else {
                    System.out.println("A data " + data + " é inválida.");
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}