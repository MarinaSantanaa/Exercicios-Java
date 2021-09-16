package listatres.java;

import java.util.Scanner;

public class ExercicioQuatro {
    public static void main(String[] args) {
        /*Escreva um programa que lê 5 números e informa o maior, o menor e a média deles.*/
        Scanner sc = new Scanner(System.in);
        float[] num = new float[5];
        float maior = 0;
        float menor = 0;
        float soma = 0;

        for (int i = 0; i < num.length; i++) {
            System.out.println("Digite um número: ");
            num[i] = sc.nextInt();

            if (i == 0) {
                maior = num[i];
                menor = num[i];
            }

            if (num[i] > maior) {
                maior = num[i];
            }

            if (num[i] < menor) {
                menor = num[i];
            }
            soma = soma + num[i];
        }
        System.out.println("O maior nº digitado foi " + maior);
        System.out.println("O menor nº digitado foi " + menor);
        System.out.println("A média é " + (soma / 5));
        sc.close();
    }
}

