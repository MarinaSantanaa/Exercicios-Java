package listaquatro.java;

import java.util.Arrays;

public class ExercicioOito {
    private String[] nomes = {"Maria", "José", "Joaquim", "Carlos", "Roberta"};
    private double[] alturas = {1.60, 1.70, 1.66, 1.74, 1.80};
    private double[] pesos = {50, 74, 68, 76, 80};
    private double[] imc = new double[5];

    public ExercicioOito() {

    }

    public ExercicioOito(String[] nomes, double[] alturas, double[] pesos) {
        this.nomes = nomes;
        this.alturas = alturas;
        this.pesos = pesos;
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public double[] getAlturas() {
        return alturas;
    }

    public void setAlturas(double[] alturas) {
        this.alturas = alturas;
    }

    public double[] getPesos() {
        return pesos;
    }

    public void setPesos(double[] pesos) {
        this.pesos = pesos;
    }

    @Override
    public String toString() {
        return "ExercicioOito{" +
                "nomes=" + Arrays.toString(nomes) +
                ", alturas=" + Arrays.toString(alturas) +
                ", pesos=" + Arrays.toString(pesos) +
                '}';
    }

    public void calculo() {
        for (int i = 0; i < 5; i++) {
            double imc = pesos[i] / (alturas[i] * alturas[i]);
            if ((imc < 18.5) || (imc > 25)) {
                System.out.println("Quem está fora do peso ideal: " + nomes[i]);
            }
        }
    }

}

