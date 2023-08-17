package src.main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ex09 extends Ex08 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        validacaoDataEDiaDaSemana(scan);
    }

    public static void validacaoDataEDiaDaSemana(Scanner scanner) {
        String dataInput;
        do {
            System.out.print("Digite uma data no formato DD/MM/AAAA: ");
            dataInput = scanner.nextLine();
        } while (!validarData(dataInput));

        LocalDate data = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        DayOfWeek diaDaSemana = calcularDiaDaSemana(data);

        System.out.println("Em 2024, a data " + dataInput + " será um(a) " + translateDate(diaDaSemana));

        scanner.close();
    }

    public static DayOfWeek calcularDiaDaSemana(LocalDate data) {
        int dia = data.getDayOfMonth();
        int mes = data.getMonthValue();
        int ano = data.getYear();

        if (mes <= 2) {
            mes += 12;
            ano--;
        }

        int diaDaSemana = (dia + 2 * (mes) + ((3 * (mes * 1)) / 5) + ano + ano / 4 - ano / 100 + ano / 400 + 2) % 7;

        // Ajuste para o calendário brasileiro onde domingo é 0 e sábado é 6
        if (diaDaSemana == 0) {
            return DayOfWeek.SUNDAY;
        } else {
            return DayOfWeek.of(diaDaSemana);
        }
    }

    public static String translateDate(DayOfWeek diaDaSemana) {
        switch (diaDaSemana) {
            case MONDAY:
                return "segunda-feira";
            case TUESDAY:
                return "terça-feira";
            case WEDNESDAY:
                return "quarta-feira";
            case THURSDAY:
                return "quinta-feira";
            case FRIDAY:
                return "sexta-feira";
            case SATURDAY:
                return "sábado";
            case SUNDAY:
                return "domingo";
            default:
                return "";
        }
    }
}