package br.com.catolica.projeto.Main;

import br.com.catolica.projeto.Enums.EnumCargo;
import br.com.catolica.projeto.Enums.EnumStatusPedido;
import br.com.catolica.projeto.Model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EnumCargo cargo;
        Lanches lanches =  new Lanches();
        Scanner entrada = new Scanner(System.in);
        Verificar verificar = new Verificar();
        Miscelanea miscelanea = new Miscelanea();

        boolean continuar = true;

        while(continuar){

            String opcao = miscelanea.menuPrincipal();

            switch (opcao){
                case "1":
                    System.out.println("Insira um Usuario: ");
                    String pergunta = entrada.nextLine();
                    System.out.println("Insira uma Senha:");
                    String pergunta2 = entrada.nextLine();
                    verificar.cadastrarCliente(pergunta,pergunta2);
                    break;
                case "2":
                    System.out.println("Insira um Usuario: ");
                    String perguntaDecisiva = entrada.nextLine();
                    System.out.println("Insira uma Senha:");
                    String perguntaDecisiva2 = entrada.nextLine();
                    if(verificar.loginVerificar(perguntaDecisiva, perguntaDecisiva2) != null && verificar.loginVerificar(perguntaDecisiva,perguntaDecisiva2).equals(EnumCargo.CLIENTE)){
                        Cliente cliente = new Cliente(perguntaDecisiva,perguntaDecisiva2,verificar);
                        System.out.printf("Seja bem Vindo(a) %s\n",perguntaDecisiva);
                        while(continuar){
                            String opcaoCliente = miscelanea.menuPrincipalCliente();
                            switch (opcaoCliente){
                                case "1":
                                    miscelanea.verCardapio(lanches);
                                    break;
                                case "2":
                                    System.out.println("Insira o nome do Lanche: ");
                                    String perguntarLanche = entrada.nextLine();
                                    System.out.println("Quantidade de Lanches: ");
                                    int quantidade = entrada.nextInt();
                                    entrada.nextLine();
                                    cliente.comprarLanches(quantidade,perguntarLanche,lanches,verificar);
                                    break;
                            }
                            if(opcaoCliente.equals("0")){
                                cliente.sairSistema();
                                break;
                            }
                        }
                    } else if (verificar.loginVerificar(perguntaDecisiva, perguntaDecisiva2) != null && verificar.loginVerificar(perguntaDecisiva,perguntaDecisiva2).equals(EnumCargo.FUNCIONARIO)) {
                        FuncionarioGerente funcionarioGerente = new FuncionarioGerente(perguntaDecisiva2,perguntaDecisiva,verificar);
                        System.out.printf("Seja bem Vindo(a) %s\n",perguntaDecisiva);
                        while(continuar){
                         String opcaoFuncionario = miscelanea.menuFuncionario();
                        switch (opcaoFuncionario){
                            case "1":
                                funcionarioGerente.statusLanche();
                                break;
                            case "2":
                                funcionarioGerente.terminarDia();
                                break;
                        }
                         if (opcaoFuncionario.equals("0")) {
                             break;
                         }
                     }
                    } else if (verificar.loginVerificar(perguntaDecisiva, perguntaDecisiva2) != null && verificar.loginVerificar(perguntaDecisiva,perguntaDecisiva2).equals(EnumCargo.GERENTE)) {
                        System.out.println("Bem vindo Gerente!");
                        FuncionarioGerente gerente = new FuncionarioGerente(perguntaDecisiva2,perguntaDecisiva,verificar);
                        while (continuar){
                            String opcaoGerente = miscelanea.menuGerente();
                            switch (opcaoGerente){
                                case "1":
                                    gerente.adicionarLanches(lanches);
                                    break;
                                case "2":
                                    gerente.remocaoLanches(lanches);
                                    break;
                                case "3":
                                    System.out.println("Insira um User para o Funcionario Contratado:");
                                    String contratarUser = entrada.nextLine();
                                    System.out.println("Insira uma senha para o Funcionario Contratado:");
                                    String contratarSenha = entrada.nextLine();
                                    gerente.contratarFuncionarios(contratarUser,contratarSenha);
                                    break;
                                case "4":
                                    gerente.demitirFuncionarios();
                                    break;
                                case "5":
                                    miscelanea.verCardapio(lanches);
                                    break;
                                case "6":
                                    gerente.saldoLanchonete();
                                    break;
                            }
                            if(opcaoGerente.equals("0")){
                                break;
                            }
                        }
                    }
            } if(opcao.equals("0")){
                System.out.println("Saindo...");
                break;
            }
        }
    }
}
