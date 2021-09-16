package br.com.exercicios.java;

import java.util.Arrays;
import java.util.Scanner;

public class ListaTres1 {
    public static void main(String[] args) {
        /*Escreva um programa que lê o nome de 5 frutas e armazena num carrinho de compras.
        Ao final da entrada dos 5 itens, exiba a lista completa.*/

        Scanner sc = new Scanner(System.in);
        System.out.println("Lista de Compras (Feira)");
        String[] frutas = new String[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite uma fruta");
            frutas[i] = sc.nextLine();
        }

        System.out.println("Carrinho de Compras: " + Arrays.toString(frutas));
        sc.close();
    }
}














