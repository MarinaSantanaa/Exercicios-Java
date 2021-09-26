package listaquatro.java;

public class TesteExercicioSete {
       public static void main(String[] args) {
        TesteExercicioSete aplicacao = new TesteExercicioSete();
        aplicacao.questaoSete();
    }

    private ExercicioSete[] iniciarArrayPessoas() {
        String[] nomes = {"Maria", "José", "Joaquim", "Carlos", "Roberta"};
        int[] idades = {20, 24, 50, 42, 28};
        ExercicioSete[] pessoasInterno = new ExercicioSete[5];

        for (int i=0; i < pessoasInterno.length; i++) {
            pessoasInterno[i] = new ExercicioSete(nomes[i], idades[i]);
        }
        return pessoasInterno;
    }

    private void questaoSete() {
        //Escreva um programa que lê nome e idade de 5 pessoas e ao final
        // informa quem é o mais novo, o mais velho e qual a média de idade.
        ExercicioSete[] pessoas = iniciarArrayPessoas();

        //------------------
        int maisNovoIndice = 0, maisVelhoIndice = 0;
        int somatorio = 0;

        for (int i=0; i< pessoas.length; i++) {
            int idade = pessoas[i].getIdade();
            if (idade > pessoas[maisVelhoIndice].getIdade()) {
                maisVelhoIndice = i;
            }
            if (idade < pessoas[maisNovoIndice].getIdade()) {
                maisNovoIndice = i;
            }
            somatorio += idade;
        }

        System.out.println("O mais VELHO é " + pessoas[maisVelhoIndice].getNome());
        System.out.println("O mais NOVO é " + pessoas[maisNovoIndice].getNome());
        System.out.println("A média de idade é " + somatorio/pessoas.length);
    }

}
