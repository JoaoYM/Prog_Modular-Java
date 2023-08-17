package src.main;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        switchArray(scan);
    }

    public  Ex01(){
        System.out.print("OK");
    }

    public static int[] switchArray(Scanner scan) {
        int[] array = new int[6];

        for (int i = 0; i < 6; i++) {
            System.out.printf("Favor inserir um numero para a posi\u00E7ao %d do array: \t", i);
            array[i] = scan.nextInt();
        }

        int anterior = 0;
        int next = array.length - 1;

        while (anterior < next) {
            int temp = array[anterior];
            array[anterior] = array[next];
            array[next] = temp;
            System.out.printf(" - %d - ", array[anterior]);
            anterior++;
            next--;
        }

        for (int i = 0; i < array.length / 2; i++) {
            System.out.printf(" - %d -", array[(array.length / 2) + (i)]);
        }

        scan.close();
        return array;
    }
}
