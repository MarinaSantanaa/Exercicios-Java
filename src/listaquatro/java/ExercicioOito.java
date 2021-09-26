package listaquatro.java;

public class ExercicioOito {
    public static void main(String[] args) {
        ExercicioOito aplicacao = new ExercicioOito();
        aplicacao.questaoOito();
    }

    private void questaoOito() {
        // Escreva um programa que lê nome, peso e altura de 5 pessoas,
        // calcula o IMC de cada um e ao final informa se alguém
        // está fora do peso ideal (o IMC ideal é entre 18.5 e 25).
        TesteExercicioOito[] pessoas = iniciarArrayPessoas();
        for (int i = 0; i < pessoas.length; i++) {
            double imc = pessoas[i].getPeso() / Math.pow(pessoas[i].getAltura(), 2);
            if (imc < 18.5 || imc > 25) {
                System.out.printf("%s está fora do peso ideal com imc = %.2f.%n",
                        pessoas[i].getNome(), imc);
            }
        }
    }

    private TesteExercicioOito[] iniciarArrayPessoas() {
        String[] nomes = {"Joao", "Jose", "Jota", "Junior", "Janio"};
        double[] alturas = {1.60, 1.70, 1.90, 1.82, 1.68};
        double[] pesos = {92, 70, 60, 75, 48};
       TesteExercicioOito[] pessoas = new TesteExercicioOito[][5];
        for (int i = 0; i < pessoas.length; i++) {
            pessoas[i] = new TesteExercicioOito(nomes[i], pesos[i], alturas[i]);
        }
        return pessoas;
    }
}