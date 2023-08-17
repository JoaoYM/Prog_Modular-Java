
package src.main;

import java.util.Scanner;

import src.main.*;
// import src.main.Ex02;
// import src.main.Ex03;
// import src.main.Ex04;
// import src.main.Ex05;
// import src.main.Ex06;
// import src.main.Ex07;
// import src.main.Ex08;
// import src.main.Ex09;
// import src.main.Ex10;
// import src.main.Ex11;
// import src.main.Ex12;

public class index {
    public static void main(String[] args){
        Ex01 temp01 = new Ex01();
        // Ex02 temp02 = new Ex02();
        // Ex03 temp03 = new Ex03();
        // Ex04 temp04 = new Ex04();
        // Ex05 temp05 = new Ex05();
        // Ex06 temp06 = new Ex06();
        // Ex07 temp07 = new Ex07();
        // Ex08 temp08 = new Ex08();
        // Ex09 temp09 = new Ex09();
        // Ex10 temp10 = new Ex10();
        // Ex11 temp11 = new Ex11();
        // Ex12 temp12 = new Ex12();

        Scanner scan = new Scanner(System.in); 

        int x = 0;

            System.out.println("Selecione um programa: ");

        do{
            System.out.println("(1)  Inverter array numerico.");
            System.out.println("(2)  Somar numeros vizinhos em um array.");
            System.out.println("(3)  Imprimir retangulo.");
            System.out.println("(4)  Inverter frase.");
            System.out.println("(5)  Montar cronograma de estudos.");
            System.out.println("(6)  Gerador numeros sorteio.");
            System.out.println("(7)  Multiplicacao por 11. ");
            System.out.println("(8)  Validador de Datas.");
            System.out.println("(9)  Validador Data x DiaDaSemana.");
            System.out.println("(10) Inverter array numerico - FILE. ");
            System.out.println("(11) Validador de Datas - FILE. ");
            System.out.println("(12) Inverter frase - FILE.");
            System.out.println("Finalizar a execução (0)");

            x = scan.nextInt();

         switch (x) {

                case 1:
                    temp01.switchArray(scan);
                    break;
                // case 2:
                //     temp02.sumNext(scan);
                //     break;
                // case 3:
                //     temp03.imprimirRetangulo(5, 4, 'X');
                //     break;
                // case 4:
                //     temp04.switchPhrase(scan);
                //     break;
                // case 5:
                //     temp05.disciplinasTempo(scan);
                //     break;
                // case 6:
                //     temp06.sorteioOrganizacao(scan);
                //     break;
                // case 7:
                //     temp07.multiplicacaoPorOnze(scan);
                //     break;
                // case 8:
                //     temp08.validacaoData(scan);
                //     break;
                // case 9:
                //     temp09.validacaoDataEDiaDaSemana(scan);
                //     break;
                // case 10:
                //     temp10.readVectorsFromFile();
                //     break;
                // case 11:
                //     temp11.validDataFile();
                //     break;
                // case 12:
                //     temp12.switchPhraseFile();
                //     break;
                default:
                    break;
            }
        } while (x != 0);
    }
}