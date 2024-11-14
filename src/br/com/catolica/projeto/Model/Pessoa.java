package br.com.catolica.projeto.Model;

public abstract class Pessoa {

    private String senha;
    private String user;

    public Pessoa(String senha,
                  String user){
        this.senha = senha;
        this.user = user;
    }

    public String getSenha(){
        return senha;
    }

    public String getUser(){
        return user;
    }

}
