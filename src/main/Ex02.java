package src.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        sumNext(scan);
    }

    public static void sumNext(Scanner scan) {

        ArrayList<Integer> vetorDinamico = new ArrayList<>();

        int n = 0;

        // Adicionar elementos ao vetor
        System.out.println("A seguir insira valores de sua escolha no vetor, ao final digite 0 para concluir: ");

        System.out.printf("Insira o próximo valor, digite 0 caso tenha inserido todos os valores desejados: \t");
        while ((n = scan.nextInt()) != 0) {
            vetorDinamico.add(n);
            System.out.printf("\n");
            System.out.printf("Insira o próximo valor, digite 0 caso tenha inserido todos os valores desejados: \t");
        }

        vetorDinamico = GetNeighbor(vetorDinamico);

        System.out.printf("\n");

        for (int i = vetorDinamico.size() - 1; i >= 0; i--) {
            int num = vetorDinamico.get(i);
            if (i > 0) {
                System.out.printf("%d - ", num);
            } else {
                System.out.printf("%d", num);
            }
        }

    }

    public static ArrayList<Integer> GetNeighbor(ArrayList<Integer> array) {

        ArrayList<Integer> newVetor = new ArrayList<>();

        for (int i = 1; i <= array.size(); i++) {
            newVetor.add(array.get((array.size()) - i) + array.get((array.size()) - (++i)));
        }

        if (array.size() % 2 != 0) {
            newVetor.add(array.get(((array.size()) - 1) + array.get((array.size()) - 1)));
        }

        return newVetor;
    }
}
