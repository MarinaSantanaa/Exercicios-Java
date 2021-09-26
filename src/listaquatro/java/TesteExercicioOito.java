package listaquatro.java;

public class TesteExercicioOito {

    public static void main(String[] args) {
        TesteExercicioOito aplicacao = new TesteExercicioOito();
        aplicacao.questaoOito();
    }

    private void questaoOito() {
        // Escreva um programa que lê nome, peso e altura de 5 pessoas,
        // calcula o IMC de cada um e ao final informa se alguém
        // está fora do peso ideal (o IMC ideal é entre 18.5 e 25).
        ExercicioOito[] pessoas = iniciarArrayPessoas();
        for (int i = 0; i < pessoas.length; i++) {
            double imc = pessoas[i].getPeso() / Math.pow(pessoas[i].getAltura(), 2);
            if (imc < 18.5 || imc > 25) {
                System.out.printf("%s está fora do peso ideal com imc = %.2f.%n",
                        pessoas[i].getNome(), imc);
            }
        }
    }

    private ExercicioOito[] iniciarArrayPessoas() {
        String[] nomes = {"Maria", "José", "Joaquim", "Carlos", "Roberta"};
        double[] alturas = {1.60, 1.70, 1.66, 1.74, 1.80};
        double[] pesos = {50, 74, 68, 76, 80};
       ExercicioOito[] pessoas = new ExercicioOito[5];
        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new ExercicioOito(nomes[i], pesos[i], alturas[i]);
        }
        return pessoas;
    }
}