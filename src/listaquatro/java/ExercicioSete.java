package listaquatro.java;

import java.util.Arrays;

    public class ExercicioSete {
        private String[] nomes = {"Maria", "José", "Joaquim", "Carlos", "Roberta"};
        private int[] idades = {20, 24, 50, 42, 28};
        private int maisVelho = 0, maisNovo = 0;
        private int soma;

        public ExercicioSete (){

        }

        public ExercicioSete(String[] nomes, int[] idades) {
            this.nomes = nomes;
            this.idades = idades;
        }

        public String[] getNomes() {
            return nomes;
        }

        public void setNomes(String[] nomes) {
            this.nomes = nomes;
        }

        public int[] getIdades() {
            return idades;
        }

        public void setIdades(int[] idades) {
            this.idades = idades;
        }

        @Override
        public String toString() {
            return "ListaQuatro7{" +
                    "nomes=" + Arrays.toString(nomes) +
                    ", idades=" + Arrays.toString(idades) +
                    '}';
        }

        public void calcular() {
            for (int i = 0; i < nomes.length; i++) {
                if (idades[i] > idades[maisVelho]) {
                    maisVelho = i;
                }
                if (idades[i] < idades[maisNovo]) {
                    maisNovo = i;
                }
                soma += idades[i];
            }
            System.out.println("Mais velho: " + nomes[maisVelho]);
            System.out.println("Mais novo: " + nomes[maisNovo]);
            System.out.println("Média de Idade: " + soma / nomes.length);
        }
    }

