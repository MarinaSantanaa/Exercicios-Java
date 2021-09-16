package listatres.java;

import java.util.Scanner;

public class ExercicioSete {
    public static void main(String[] args) {
        /*Escreva um programa que lê nome e idade de 5 pessoas e ao final informa quem é o mais novo,
        quem é o mais velho e qual a média de idade.*/
        Scanner sc = new Scanner(System.in);
        String[] nome = new String[5];
        int[] idade = new int[5];
        int idadeMaisNovo = 0;
        String nomeMaisNovo = "";
        int idadeMaisVelho = 0;
        String nomeMaisVelho = "";
        float soma = 0;

        for (int i = 0; i < nome.length; i++) {
            System.out.println("Digite o nome: ");
            nome[i] = sc.nextLine();

            System.out.println("Digite a idade: ");
            idade[i] = sc.nextInt();
            sc.nextLine();

            if (i == 0) {
                idadeMaisVelho = idade[i];
                idadeMaisNovo = idade[i];
            }

            if (idade[i] < idadeMaisNovo) {
                idadeMaisNovo = idade[i];
                nomeMaisNovo = nome[i];
            }
            if (idade[i] > idadeMaisVelho) {
                idadeMaisVelho = idade[i];
                nomeMaisVelho = nome[i];
            }

            soma = soma + idade[i];
        }

        System.out.println("Mais novo: " + nomeMaisNovo);
        System.out.println("Idade: " + idadeMaisNovo);
        System.out.println("Mais velho: " + nomeMaisVelho);
        System.out.println("Idade: " + idadeMaisVelho);
        System.out.println("A média é " + (soma / 5));
        sc.close();
    }
}

