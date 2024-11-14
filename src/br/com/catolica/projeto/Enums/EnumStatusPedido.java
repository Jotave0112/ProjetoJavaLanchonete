package br.com.catolica.projeto.Enums;

public enum EnumStatusPedido {

    ZERO(0),
    PEDENTE(1),
    PREPARO(2),
    PRONTO(3);

    int valor;

    EnumStatusPedido(int valor){
        this.valor = valor;
    }
}
