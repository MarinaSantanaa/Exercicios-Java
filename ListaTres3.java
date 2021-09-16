package br.com.exercicios.java;

import java.util.Scanner;

public class ListaTres3 {
    public static void main(String[] args) {
        /*Escreva um programa que lê 5 números. Ao final, escreva primeiro todos os impares, depois todos os pares*/
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];

        for (int i = 0; i < num.length; i++) {
            System.out.println("Digite um número: ");
            num[i] = sc.nextInt();
        }

        System.out.println("Números Impares: ");
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 != 0) {
                System.out.println(num[i]);
            }
        }

        System.out.println("Números Pares: ");
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.println(num[i]);
            }
            sc.close();
        }
    }
}
