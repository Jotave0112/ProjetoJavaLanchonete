package br.com.catolica.projeto.Model;

public class Lanches {

    String[] lanches = new String[50];
    double[] precoLanches = new double[50];

    public Lanches(){
        lanches[0] = "sanduiche";
        lanches[1] = "pastel";
        lanches[2] = "esfirra";
        lanches[3] = "tapioca";
        lanches[4] = "agua";
        lanches[5] = "cafe";
        lanches[6] = "suco";
        lanches[7] = "refrigerante";

        precoLanches[0] = 8.00;
        precoLanches[1] = 4.00;
        precoLanches[2] = 4.00;
        precoLanches[3] = 4.00;
        precoLanches[4] = 2.00;
        precoLanches[5] = 2.00;
        precoLanches[6] = 3.00;
        precoLanches[7] = 4.00;
    }

    public String[] getLanches() {
        return lanches;
    }
}