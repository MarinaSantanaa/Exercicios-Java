package br.com.exercicios.java;

import java.util.Scanner;

public class ListaTres6 {
    public static void main(String[] args) {
        /*Escreva um programa que lê uma palavra e escreve de volta com os caracteres ímpares em maiúsculo.*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palavra: ");
        String palavra = sc.nextLine();

        for (int i = 0; i < palavra.length(); i++) {
            if (i % 2 != 0) {
                String maiusculas = "" + palavra.charAt(i);
                System.out.printf("%s", maiusculas.toUpperCase());
            } else {
                System.out.printf("%s", palavra.charAt(i));
            }
        }
        sc.close();
    }
}

