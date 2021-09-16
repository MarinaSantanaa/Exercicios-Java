package listatres.java;

import java.util.Scanner;

public class ExercicioDois {
    public static void main(String[] args) {
        /*Escreva um programa que lê uma palavra e a escreve de volta ao contrário*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Escreva uma palavra:");
        String palavra = sc.nextLine();
        String palavraInversa = "";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInversa = palavraInversa + palavra.charAt(i);
        }
        System.out.println("O inverso da palavra " + palavra + " é " + palavraInversa);
        sc.close();
    }
}

