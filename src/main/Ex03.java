package src.main;

public class Ex03 {
    public static void main(String[] args) {
        imprimirRetangulo(5, 4, 'X');
    }

    public static void imprimirRetangulo(int largura, int altura, char caractere) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                    System.out.print(caractere);
                } else {
                    System.out.print(" ");
                }
            }
                    System.out.println();
        }
    }
}
