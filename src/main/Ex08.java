package src.main;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); 
            validacaoData(scan);                
    }
    
    public static void  validacaoData(Scanner scanner) {

        System.out.print("Digite uma data no formato DD/MM/AAAA: ");
        String data = scanner.nextLine();

        if (validarData(data)) {
            System.out.println("A data é válida.");
        } else {
            System.out.println("A data é inválida.");
        }

        scanner.close();
    }

    public static boolean validarData(String data) {
        String[] partes = data.split("/");
        if (partes.length != 3) {
            System.out.println("A data não está no formato correto (DD/MM/AAAA).");
            return false;
        }

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        if (ano < 1 || ano > 9999) {
            System.out.println("Ano inválido. Deve estar entre 0001 e 9999.");
            return false;
        }

        if (mes < 1 || mes > 12) {
            System.out.println("Mês inválido. Deve estar entre 01 e 12.");
            return false;
        }

        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
            diasPorMes[2] = 29; // Ano bissexto, fevereiro tem 29 dias
        }

        if (dia < 1 || dia > diasPorMes[mes]) {
            System.out.println("Dia inválido para o mês informado.");
            return false;
        }

        return true;
}
}