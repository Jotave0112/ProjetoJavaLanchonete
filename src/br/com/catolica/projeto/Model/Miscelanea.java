package br.com.catolica.projeto.Model;

import java.util.Scanner;

public class Miscelanea {

    Lanches lanches = new Lanches();

    public String menuPrincipal(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("---------Bem vindo!----------");
        System.out.println("[1] - Cadastramento");
        System.out.println("[2] - Login");
        System.out.println("[0] - Sair");
        System.out.println("-----------------------------\n");
        System.out.println("Digite a funcao desejada: ");
        String pergunta = entrada.next();
        switch (pergunta){
            case "1":
                return "1";
            case "2":
                return "2";
            case "0":
                return "0";
            default:
                return "-1";
        }
    }

    public String menuPrincipalCliente(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("---------Bem vindo!----------");
        System.out.println("[1] - Ver Cardapio");
        System.out.println("[2] - Comprar Lanches");
        System.out.println("[0] - Sair");
        System.out.println("-----------------------------\n");
        System.out.println("Digite a funcao desejada: ");
        String pergunta = entrada.next();
        switch (pergunta){
            case "1":
                return "1";
            case "2":
                return "2";
            case "0":
                return "0";
            default:
                return "-1";
            }
        }

    public void verCardapio(Lanches lanches){
        for(int y = 0; y < lanches.getLanches().length; y++ ){
            if(lanches.getLanches()[y] != null && lanches.precoLanches[y] != 0){
                System.out.printf("Um %s por %.2f\n", lanches.getLanches()[y],lanches.precoLanches[y]);
                    }
                }
            }

    public String menuFuncionario(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("---------Bem vindo!----------");
        System.out.println("[1] - Alterar Status do Pedido");
        System.out.println("[2] - Terminar Dia");
        System.out.println("[0] - Sair");
        System.out.println("-----------------------------\n");
        System.out.println("Digite a funcao desejada: ");
        String pergunta = entrada.next();
        switch (pergunta){
            case "1":
                return "1";
            case "2":
                return "2";
            case "0":
                return "0";
            default:
                return "-1";
        }
    }

    public String menuGerente(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("---------Bem vindo!----------");
        System.out.println("[1] - Adicionar Lanches");
        System.out.println("[2] - Remover Lanches");
        System.out.println("[3] - Contratar Funcionarios");
        System.out.println("[4] - Demitir Funcionarios");
        System.out.println("[5] - Listar Cardapio");
        System.out.println("[6] - Ver Saldo Lanchonete");
        System.out.println("[0] - SAIR");
        System.out.println("-----------------------------\n");
        System.out.println("Digite a funcao desejada: ");
        String pergunta = entrada.next();
        switch (pergunta){
            case "1":
                return "1";
            case "2":
                return "2";
            case "3":
                return "3";
            case "4":
                return "4";
            case "5":
                return "5";
            case "6":
                return "6";
            case "0":
                return "0";
            default:
                return "-1";
        }
    }
        }
