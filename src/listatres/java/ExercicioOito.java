package listatres.java;

import java.util.Scanner;

public class ExercicioOito {
    public static void main(String[] args) {
        /*Escreva um programa que lê nome, peso e altura de 5 pessoas, calcula o IMC de cada um e ao final
        informa se alguém está fora do peso ideal (o IMC ideal é entre 18,5 e 25).*/
        Scanner sc = new Scanner(System.in);
        String[] nome = new String[5];
        double [] peso = new double[5];
        double [] altura = new double[5];
        double [] imc = new double[5];

        for (int i=0; i< 5; i++) {
            System.out.println("Digite o nome: ");
            nome[i] = sc.nextLine();

            System.out.println("Digite o peso: ");
            peso[i] = sc.nextDouble();

            System.out.println("Digite a altura: ");
            altura[i] = sc.nextDouble();
            sc.nextLine();

            imc[i] = peso[i] / (altura[i] * altura[i]);
        }

        for(int i=0; i< 5; i++) {
            if((imc[i] < 18.5) || (imc[i] > 25)){
                System.out.println("Quem está fora do peso ideal: " + nome[i]);
            }
        }
        sc.close();
    }
}

