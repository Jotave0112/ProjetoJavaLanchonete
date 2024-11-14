package br.com.catolica.projeto.Model;

import br.com.catolica.projeto.Contracts.IClient;
import br.com.catolica.projeto.Enums.EnumCargo;

import java.util.Scanner;

public class Cliente extends Pessoa implements IClient{

    EnumCargo cargoE;
    Lanches lanchar;
    Verificar verificar;
    String[] pedido;


    public Cliente(
            String senha,
            String user,
            Verificar verificar
    ) {
        super(senha, user);
        pedido = new String[100];
        this.lanchar = new Lanches();
        this.verificar = verificar;
    }

    @Override
    public void comprarLanches(int qnt, String lanche,Lanches lanches, Verificar verificar) {
        int marcador = 0;
            while (true) {
                for (int x = 0; x < lanches.getLanches().length; x++) {
                    if (lanches.getLanches()[x].equals(lanche)) {
                        verificar.preco += (qnt * verificar.tabelaPrecosLanches(lanche, lanches));
                        System.out.println("\nLanche(s) comprado(s)!");
                        verificar.saldoRestaurante += verificar.preco;
                        verificar.pegarPreco += verificar.preco;
                        pedido[marcador] = lanche;
                        break;
                    }
                }

                System.out.println("Voce deseja outro lanche?| sim/nao |");
                Scanner entrada = new Scanner(System.in);
                String pergunta = entrada.nextLine();
                if (pergunta.equals("sim")) {
                    marcador++;
                    System.out.println("Digite o nome do lanche:");
                    lanche = entrada.nextLine();
                    System.out.println("Digite a Quantidade: ");
                    qnt = entrada.nextInt();
                }
                else{
                    for (int x = 0; x <= marcador; x++){
                        System.out.printf("Seu Pedido: %s\n",pedido[x]);
                        pedido[x] = null;
                    }
                    System.out.printf("Preco Total: %.2f\n", verificar.preco);
                    verificar.preco = 0;
                    break;
                }
            }
        }

    @Override
    public void sairSistema() {
        System.out.println("Saindo...");
    }

    @Override
    public void cadastramentoCliente() {
        verificar.cadastrarCliente(getUser(),getSenha());
    }

}
