package br.com.catolica.projeto.Enums;

public enum EnumCargo {

    VAZIO(0),
    CLIENTE(1),
    FUNCIONARIO(2),
    GERENTE(3);

    int valor;

    EnumCargo(int valor){
        this.valor = valor;
    }

}
