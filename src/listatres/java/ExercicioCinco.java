package listatres.java;

import java.util.Arrays;
import java.util.Scanner;

public class ExercicioCinco {
    public static void main(String[] args) {
        /*Escreva um programa que lê o nome de 5 pessoas e armazena numa lista de convidados. Ao final, informe
        qual o nome mais longo presente na lista.*/
        Scanner sc = new Scanner(System.in);
        String[] convidados = new String[5];
        String nomeMaior = "";

        for (int i = 0; i < convidados.length; i++) {
            System.out.println("Digite um nome: ");
            convidados[i] = sc.nextLine();
            if (convidados[i].length() > nomeMaior.length()) {
                nomeMaior = convidados[i];
            }

        }

        System.out.println("Lista de Convidados " + Arrays.toString(convidados));
        System.out.println("O nome mais longo presente na lista é: " + nomeMaior);
        sc.close();
    }
}

