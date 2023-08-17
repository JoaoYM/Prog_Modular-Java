package src.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex10 extends Ex02 {
    public static void main(String[] args) {
        readVectorsFromFile();
    }

    public static void readVectorsFromFile() {
        try {
            Scanner fileScanner = new Scanner(new File("vetores.txt"));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] elements = line.split(";");

                ArrayList<Integer> vetorDinamico = new ArrayList<>();
                for (String element : elements) {
                    vetorDinamico.add(Integer.parseInt(element));
                }

                vetorDinamico = GetNeighbor(vetorDinamico);

                for (int i = vetorDinamico.size() - 1; i >= 0; i--) {
                    int num = vetorDinamico.get(i);
                    if (i > 0) {
                        System.out.printf("%d - ", num);
                    } else {
                        System.out.printf("%d", num);
                    }
                }

                System.out.println();
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
