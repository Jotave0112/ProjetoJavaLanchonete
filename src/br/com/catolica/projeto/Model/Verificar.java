package br.com.catolica.projeto.Model;

import br.com.catolica.projeto.Contracts.ILogar;
import br.com.catolica.projeto.Enums.EnumCargo;

import java.util.Scanner;

public class Verificar implements ILogar {

    public double preco;
    protected double pegarPreco;
    protected int marcar = 0;
    protected double saldoRestaurante;
    int[] idFuncionario = new int[50];
    String[] funcioarioUser = new String[50];
    String[] funcionarioSenha = new String[50];
    String[] clienteUser = new String[15000];
    String[] clienteSenha = new String[15000];
    int[] clienteId = new int[15000];
    String[] gerente = new String[3];


    Cliente cliente;
    FuncionarioGerente funcionario;
    Lanches lanches;

    public Verificar() {
        gerente[1] = "J0t4v3";
        gerente[2] = "4m03tr4b4lh4r";
    }

    public Verificar(Cliente cliente) {
        this.cliente = cliente;
    }

    public Verificar(FuncionarioGerente funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public EnumCargo loginVerificar(String user, String senha) {
        for (int x = 0; x < clienteUser.length;x++) {
        if (clienteUser[x] != null && clienteSenha[x] != null) {
                if (clienteUser[x].equals(user) && clienteSenha[x].equals(senha) && clienteId[x] == x + 1){
                    return EnumCargo.CLIENTE;
                }
            }
        }
        for (int x = 0; x < idFuncionario.length; x++) {
            if (funcioarioUser[x] != null && funcionarioSenha[x] != null) {
                if (user.equals(funcioarioUser[x]) && senha.equals(funcionarioSenha[x]) && idFuncionario[x] == x + 1) {
                    return EnumCargo.FUNCIONARIO;
                }
            } else {
                break;
            }
        }
        for (int x = 0; x < gerente.length; x++){
            if (gerente[1].equals(user) && gerente[2].equals(senha)){
                return EnumCargo.GERENTE;
            }
        }
        return EnumCargo.VAZIO;
    }

    @Override
    public double tabelaPrecosLanches(String lanche, Lanches lanches) {
        int posicao = 0 ;
        for (int x = 0; x < lanches.precoLanches.length; x++) {
            if(lanche.equals(lanches.lanches[x])){
                break;
            } else {
                posicao+=1;
            }
        }
        return lanches.precoLanches[posicao];
    }

    @Override
    public void addFuncionario(String user, String senha, int func) {
        for (int x = 0; x < idFuncionario.length; x++) {
            if (!user.equals(clienteUser[x]) && !senha.equals(clienteSenha[x]) && !user.equals(funcioarioUser[x]) && !senha.equals(funcionarioSenha[x])
            && !gerente[1].equals(user) && !gerente[2].equals(senha)) {
                if (funcioarioUser[x] == null && funcionarioSenha[x] == null && idFuncionario[x] == 0) {
                    funcioarioUser[x] = user;
                    funcionarioSenha[x] = senha;
                    idFuncionario[x] = x + 1;
                    break;
                }
            }else {
                System.out.println("Usuario ou Senha ja possui remetente!");
                break;
            }
        }
    }
    @Override
    public void removerFuncionario(String user, Verificar verificar){
        int posicao = 0;
        for (int x = 0; x < idFuncionario.length; x++) {
            if(funcioarioUser[x].equals(user)){
                funcioarioUser[x] = null;
                funcionarioSenha[posicao] = null;
                idFuncionario[posicao] = 0;
                break;
            } else {
                posicao++;
            }
        }
    }

    @Override
    public void cadastrarCliente(String user, String senha) {
        for (int x = 0; x < clienteUser.length; x++) {
            if (!user.equals(clienteUser[x]) && !senha.equals(clienteSenha[x]) && !user.equals(funcioarioUser[x]) && !senha.equals(funcionarioSenha[x])
                    && !gerente[1].equals(user) && !gerente[2].equals(senha)) {
                if (clienteUser[x] == null && clienteSenha[x] == null) {
                    clienteUser[x] = user;
                    clienteSenha[x] = senha;
                    clienteId[x] = x + 1;
                    System.out.println("Cadastramento bem sucedido!");
                    break;
                }
            } else {
                System.out.println("Usuario ou Senha ja possui remetente!");
                break;
            }
        }
    }

    @Override
    public void addLanchesNovos(Lanches lanches){
        Scanner entrada = new Scanner(System.in);
        for(int x = 0; x < lanches.precoLanches.length;x++){
        if(lanches.getLanches()[x] == null) {
            if(lanches.precoLanches[x] == 0) {
                System.out.println("Insira o novo Lanche:");
                String pergunta = entrada.nextLine();
                System.out.println("Insira o preco do Lanche:");
                double perguntaDois = entrada.nextDouble();
                entrada.nextLine();
                lanches.precoLanches[x] = perguntaDois;
                lanches.getLanches()[x] = pergunta;
                System.out.println("Lanche Adicionado!");
                break;
                }
            }
        }
    }

    @Override
    public void removerLanches(Lanches lanches){
        int posicao = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o lanche que deverá ser Excluido do cardapio:");
        String pergunta = entrada.nextLine();
        for(int x = 0; x < lanches.getLanches().length;x++){
            if(pergunta.equals(lanches.getLanches()[x])){
                lanches.getLanches()[x] = null;
                lanches.precoLanches[posicao] = 0;
                System.out.println("Lanche Excluido!");
                break;
            } else {
                posicao++;
            }
        }
    }
}
