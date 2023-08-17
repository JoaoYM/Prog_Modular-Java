package src.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex05 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        disciplinasTempo(scan);
    }

    public static void disciplinasTempo(Scanner scanner) {

        System.out.print("Digite o tempo disponível para estudo (horas): ");
        int horasDisponiveis = scanner.nextInt();

        System.out.print("Digite o tempo disponível para estudo (minutos): ");
        int minutosDisponiveis = scanner.nextInt();

        System.out.print("Digite o número de disciplinas: ");
        int numDisciplinas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Map<String, Integer> disciplinas = new HashMap<>();
        for (int i = 1; i <= numDisciplinas; i++) {
            System.out.print("Digite o nome da disciplina " + i + ": ");
            String nomeDisciplina = scanner.nextLine();
            disciplinas.put(nomeDisciplina, 0);
        }

        organizarPlanoDeEstudos(disciplinas, horasDisponiveis, minutosDisponiveis);

        scanner.close();
    }

    public static void organizarPlanoDeEstudos(Map<String, Integer> disciplinas, int horasTotal, int minutosTotal) {
        int totalMinutosDisponiveis = (horasTotal * 60) + minutosTotal;
        int numDisciplinas = disciplinas.size();
        int pausa = 20;

        int tempoPorDisciplina = (totalMinutosDisponiveis - (numDisciplinas - 1) * pausa) / numDisciplinas;

        System.out.println("Tempo de estudo por disciplina:");
        for (Map.Entry<String, Integer> entry : disciplinas.entrySet()) {
            String disciplina = entry.getKey();
            int horas = tempoPorDisciplina / 60;
            int minutos = tempoPorDisciplina % 60;

            System.out.println(disciplina + ": " + horas + " horas e " + minutos + " minutos");
        }

        System.out.println("Tempo de pausa entre disciplinas: " + pausa + " minutos");
        System.out.println("Tempo por disciplina: " + tempoPorDisciplina / 60 + " horas e " + (tempoPorDisciplina % 60)
                + " minutos");
    }

}
